<%-- 
    Document   : deleteData
    Created on : 14-May-2018, 12:14:18
    Author     : znu16qvu
--%>

<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%
    Class.forName("org.postgresql.Driver");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diet</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>

        <link href='' rel='stylesheet' type='text/css'>
    </head>
    <body onLoad="displayResults()">
        <h1>Diet</h1>
        <form action="index.jsp">
            <input type="submit" value="Homepage" />
        </form>
        <form action="diet.jsp">
            <input type="submit" value="View Meals" />
        </form>
        
        <%!
//            Declare Connection to dB PostgreSQL (labs)
            public class mealTypes {

                String URL = "jdbc:postgresql://127.0.0.1/studentdb";
                String USERNAME = "student";
                String PASSWORD = "dbpassword";

                Connection connection = null;
                PreparedStatement selectMeals = null;
                PreparedStatement deleteMeals = null;
                ResultSet resultset = null;
                
//                Declare SQL statemenets to manipulate data with
                public mealTypes() {
                    try {
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                        selectMeals = connection.prepareStatement("SELECT mealName, mealType, calorieAmount FROM mealTypes");

                        deleteMeals = connection.prepareStatement("DELETE FROM mealTypes WHERE calorieAmount = ?");
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

                public int deleteMeals(Integer id) {
                    int result = 0;

                    try {

                        deleteMeals.setInt(1, id);
                        result = deleteMeals.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return result;
                }
            }
        
        %>
        <%
            int result = 0;
            
            mealTypes meal = new mealTypes();
            ResultSet meals = meal.getMeals();
            
            Integer mealId = new Integer(0);
            

            if (request.getParameter("submit") != null) {
                mealId = Integer.parseInt(request.getParameter("mealName"));
                result = meal.deleteMeals(mealId);
            }

            %>

        <h2>Delete meals</h2>

        <form name="removingForm" action="deleteData.jsp" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Meal Name:</td>
                        <td><select class="form-control" id="sel1" name="mealName">
                                <!--Get all the meals based on amount of calorie rows
                                stored in the list for each of the meals-->
                                <% while (meals.next()) { %>
                                <option value="<%= meals.getInt("calorieAmount") %>" ><%= meals.getString("mealName") %></option>
                                <% } %>
                            </select>
                        </td>
                    </tr>
                </tbody>
            </table>
                            <input type="hidden" name="hidden" value="<%= result %>" />                
            <input type="submit" value="Submit" name="submit" />


        </form>
            
            <script>
                function displayResult() {
                    if(document.removinForm.hidden.value == 1) {
                        alert("Data deleted!");
                    }
                }
            </script>

    </body>
</html>
