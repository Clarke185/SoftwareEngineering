<%-- 
    Document   : diet
    Created on : 12-Mar-2018, 15:22:18
    Author     : znu16qvu
--%>


<%@page import="healthtracker.Diet.mealDietType"%>
<%@page import="healthtracker.Diet"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%
    Class.forName("org.postgresql.Driver");
%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>

        <link href='' rel='stylesheet' type='text/css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diet</title>
        
        <style>
            #sel1 {
                width: 10%;
            }
            
            .table-hover {
                width: 35%;
            }
            
        </style>
    </head>


    <body>
        <h1>Diet</h1>

        <form action="index.jsp">
            <input type="submit" value="Homepage" />
        </form>
        <form action="insertData.jsp">
            <input type="submit" value="Add custom meal" />
        </form>
        <form action="deleteData.jsp">
            <input type="submit" value="Delete a meal" />
        </form>

        <h2>Select a meal</h2>
        <%
            // Declare arraylist for meal name, pass enum from diet.java 
            ArrayList<String> mealsArray = new ArrayList();

            mealsArray.add("Banana.");
            mealsArray.add("Beef.");
            mealsArray.add("Eggs.");
            mealsArray.add("Cheese.");
            mealsArray.add("Chocolate.");

            List<mealDietType> list = Arrays.asList(mealDietType.values());

//            for (int i = 0; i < list.size(); i++) {
//                out.println(list.get(i));
//            }
            // Declare arraylist for calories of the default meals
            ArrayList<Integer> caloriesArray = new ArrayList();
            caloriesArray.add(95);
            caloriesArray.add(188);
            caloriesArray.add(155);
            caloriesArray.add(461);
            caloriesArray.add(530);

        %>

        <%--Select and confirm selection from drop down list--%>
        <form name="selectMeal" method="get" action="#">
            <select class="form-control" id="sel1"  name="mealArrays">
                <%  for (int i = 0; i < mealsArray.size(); i++) {
                        String option = (String) mealsArray.get(i);
                %>

                <%
                    int cal = (int) caloriesArray.get(i);
                %>

                <option value="<%= option%> 
                        <% out.println("Meal Type : " + list.get(i));%>
                        <% out.println("Calories amount : " + cal
                                    + " per 100g");%>
                        ">

                    <%= option%></option>
                    <% } %>


            </select>

            <input type="submit" name="submit" value="Select Meal"/>

        </form>

        <%-- To display selected item from dropdown list. --%>
        <%
            String food = request.getParameter("mealArrays");

            if (food != null) {
                out.println("Selected meal is : " + food + ".");

            }
        %>


        <%!
            public class mealTypes {

                String URL = "jdbc:postgresql://127.0.0.1/studentdb";
                String USERNAME = "student";
                String PASSWORD = "dbpassword";

                Connection connection = null;
                PreparedStatement selectMeals = null;
                ResultSet resultset = null;

                public mealTypes() {
                    try {
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                        selectMeals = connection.prepareStatement("SELECT mealName, mealType, calorieAmount FROM mealTypes");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public ResultSet getMeals() {

                    try {

                        resultset = selectMeals.executeQuery();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return resultset;
                }
            }
        %>
        <%
            mealTypes mealtypes = new mealTypes();
            ResultSet diet = mealtypes.getMeals();
        %>

        <h2>Custom meals list</h2>
        <table class="table table-hover" border="1">

            <tbody>
                <tr>
                    <td>Meal Name</td>
                    <td>Meal Type</td>
                    <td>Calories</td>
                </tr>
                <% while (diet.next()) {%>
                <tr>
                    <td><%= diet.getString("mealName")%></td>
                    <td><%= diet.getString("mealType")%></td>
                    <td><%= diet.getInt("calorieAmount")%></td>
                </tr>
                <% }%>
            </tbody>
        </table>


    </body>
</html>
