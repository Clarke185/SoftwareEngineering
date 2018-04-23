<%-- 
    Document   : display
    Created on : 16-Mar-2018, 11:34:57
    Author     : James
--%>
<%@page import="java.sql.*"%>
<%
    Class.forName("org.postgresql.Driver"); 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        
        <%!
        public class User {
            String URL = "jdbc:postgresql://localhost:5432/HealthTracker";
            String USERNAME = "postgres";
            String PASSWORD = "";

            Connection connection = null;
            PreparedStatement selectUsers = null;
            ResultSet resultSet = null;

            public User(){
                try {
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    
                    selectUsers = connection.prepareStatement(
                        "SELECT userid, firstname, surname, username, email, height, weight, bmi FROM userinfo"
                         + " WHERE username = ? AND password = ?");
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

            public ResultSet getUsers(String username, String password){
                try {
                    selectUsers.setString(1, username);
                    selectUsers.setString(2, password);
                    resultSet = selectUsers.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return resultSet;
            }
        }
        %>
        <%
            String userName = new String();
            String passWord = new String();

            userName = request.getParameter("username");
            passWord = request.getParameter("password");
            
            User user = new User();
            ResultSet users = user.getUsers(userName, passWord);
        %>
        
        <h1>User (From database) :</h1>
        
        <table border="1">
            <tbody>
                <tr>
                    <td>UserID</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Username</td>
                    <td>Email</td>
                    <td>Height (cm)</td>
                    <td>Weight (kg)</td>
                    <td>BMI</td>
                </tr>
                <% while(users.next()){ %>
                <tr>
                    <td><%= users.getInt("userid") %></td>
                    <td><%= users.getString("firstname") %></td>
                    <td><%= users.getString("surname") %></td>
                    <td><%= users.getString("username") %></td>
                    <td><%= users.getString("email") %></td>
                    <td><%= users.getInt("height") %></td>
                    <td><%= users.getInt("weight") %></td>
                    <td><%= users.getInt("bmi") %></td>
                </tr>
                <% } %>
            </tbody>
        </table>

    </body>
</html>
