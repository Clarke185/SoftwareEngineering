<%-- 
    Document   : index
    Created on : 12-Mar-2018, 10:50:14
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
                width: 20%;
            }
            
        </style>
    </head>


    <body onload="displayResults()">

        <h1>Diet</h1>
        <form action="index.jsp">
            <input type="submit" value="Homepage" />
        </form>
        <form action="diet.jsp">
            <input type="submit" value="View Meals" />
        </form>


        <%!
            public class insertMeals {

                String URL = "jdbc:postgresql://127.0.0.1/studentdb";
                String USERNAME = "student";
                String PASSWORD = "dbpassword";

                Connection connection = null;
                PreparedStatement insertMeals = null;
                ResultSet resultset = null;

                public insertMeals() {

                    try {

                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                        insertMeals = connection.prepareStatement("INSERT INTO mealTypes(mealName, mealType, calorieAmount) VALUES(?, ?, ?)");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public int setMeals(String mealname, String mealtype, int cal) {
                    int result = 0;
                    try {
                        insertMeals.setString(1, mealname);
                        insertMeals.setString(2, mealtype);
                        insertMeals.setInt(3, cal);

                        result = insertMeals.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    return result;

                }
            }
        %>

        <%
            int result = 0;

            if (request.getParameter("submit") != null) {

                String mealName = new String();
                String mealType = new String();
                int cal = 0;

                if (request.getParameter("mealName") != null) {
                    mealName = request.getParameter("mealName");
                }

                if (request.getParameter("mealType") != null) {
                    mealType = request.getParameter("mealType");
                }

                if (request.getParameter("calorieAmount") != null) {
                    cal = Integer.parseInt(request.getParameter("calorieAmount"));
                } else {
                    cal = 0;
                }

                insertMeals meals = new insertMeals();
                result = meals.setMeals(mealName, mealType, cal);
            }
        %>


        <h1>Add a custom meal</h1>
        <form name="insertionDietForm" action="insertData.jsp" method="POST">
            <table border="0">

                <tbody>
                    <tr>
                        <td>Meal Name :</td>
                        <td><input type="text" name="mealName" value="" size="25" /></td>
                    </tr>
                    <tr>
                        Meal Type :
                <select class="form-control" id="sel1" name="mealType">
                    <option>Fruit/Veg</option>
                    <option>Carbs</option>
                    <option>Protein</option>
                    <option>Milk/Dairy</option>
                    <option>Fat/Sugar</option>
                </select>

                </tr>
                <tr>
                    <td>Calories : </td>
                    <td><input type="text" name="calorieAmount" value="" size="25" /></td>
                </tr>
                </tbody>
            </table>
            <input type="hidden" name="hidden" value="<%= result%>" />
            <input type="reset" value="Clear" name="clear" />
            <input type="submit" value="Submit" name="submit" />
        </form>

        <script language="JavaScript">
            function displayResults()
            {
                if (document.insertionDietForm.hidden.value == 1) {
                    alert("Meal Inserted!");
                }
            }


        </script>
    </body>
</html>
