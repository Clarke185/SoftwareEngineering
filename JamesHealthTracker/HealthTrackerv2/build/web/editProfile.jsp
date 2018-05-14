<%-- 
    Document   : editProfile
    Created on : 27-Apr-2018, 15:15:00
    Author     : James Clarke - jamesmichaelclarke@hotmail.co.uk
--%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page import ="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
<%@ page import = "org.apache.commons.io.output.*" %>

<script>
</script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
        <link href='custom.css' rel='stylesheet' type='text/css'>
        <link type="text/css" rel="stylesheet" href="style.css">
        <title>User Page</title>
    </head>
    <body background="BackgroundImage">
        <%@ page session="true" %>
        
        
        
        <%!
        public class User {
            String URL = "jdbc:postgresql://localhost:5432/HealthTracker";
            String USERNAME = "postgres";
            String PASSWORD = "";

            Connection connection = null;
            PreparedStatement editUsers = null;
            ResultSet resultSet = null;

            public User(){
                try {
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    
                    editUsers = connection.prepareStatement(
                    "UPDATE userinfo SET firstname = ?, surname = ?, height = ?, weight = ?, bmi = ?, userbio = ? WHERE username = ? AND password = ?");
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

            public int setUsers(String fir, String sur, int he, int we, double bm, String bio, String usr, String pw){
                int result = 0;
                
                try{
                    editUsers.setString(1, fir);
                    editUsers.setString(2, sur);
                    editUsers.setInt(3, he);
                    editUsers.setInt(4, we);
                    editUsers.setDouble(5, bm);
                    editUsers.setString(6, bio);
                    editUsers.setString(7, usr);
                    editUsers.setString(8, pw);
                    result = editUsers.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                return result;
            }
        }
        %>
        <%
            int result = 0;
            String userid = (String)session.getAttribute("userid");
            String userName = (String)session.getAttribute("user");
            String passWord = (String)session.getAttribute("pass");
            
            String firstName = new String();
            String lastName = new String();
            String userbio = new String();
//            firstName = (String)session.getAttribute("first");
//            lastName = (String)session.getAttribute("last");
            
            
            int height = 0;
            int weight = 0;
            double bmi = 0.0;
            
            firstName = request.getParameter("firstname");
            lastName = request.getParameter("surname");
            if(request.getParameter("height") != null){
                height = Integer.parseInt(request.getParameter("height"));
            } else {height = 0;}
            if(request.getParameter("weight") != null){
                weight = Integer.parseInt(request.getParameter("weight"));
            } else {weight = 0;}
            if(request.getParameter("bmi") != null){
                bmi = Double.parseDouble(request.getParameter("bmi"));
            } else {bmi = 0;}
            
            userbio = request.getParameter("userbio");
            
            
            User user = new User();
            result = user.setUsers(firstName, lastName, height, weight, bmi, userbio, userName, passWord);
        %>
        
        <div class="container">
            <div class="controls">
            <form name="editprofileform" method="POST" action="editProfile.jsp">
                <div class="col-md-3">
                    <div class="text-center">
                        <h4><label for="form_name">Firstname</label></h4>
                        <input id="first" type="text" name="firstname" class="form-control" placeholder="Please enter your firstname" required="required" data-error="Firstname is required.">
                        <div class="help-block with-errors"></div>
                        <h4><label for="form_name">Surname</label></h4>
                        <input id="last" type="text" name="surname" class="form-control" placeholder="Please enter your surname" required="required" data-error="Surname is required.">
                        <div class="help-block with-errors"></div>
                        <h4> <% out.println(userName); %></h4>
                        <img src='GetImage' width="200" height="200" border="5" alt="">
                        <hr />
                    </div>
                </div>
                        
            
                <div class="col-md-8">
                    </br></br></br>
                    <p class="lead">Your Details: </p>
                    <hr />
                                <div class="row" oninput="x.value=(parseFloat(b.value)/(parseFloat(a.value/100)**2)).toFixed(2)">

                                    <div class="col-md-3">
                                        <label>Height(cm):</label>
                                        <input class="form-control" type="number" name="height" value="Height(cm)" id="a">
                                    </div>
                                    <div class="col-md-3">
                                        <label>Weight(kg):</label>
                                        <input class="form-control" type="number" name="weight" value="Weight(Kg)" id="b">
                                    </div>
                                    <div class="col-md-3">
                                        <label>BMI:</label>
                                        <input class="form-control"  value="BMI" name="bmi" id="x" for="a b">
                                    </div>
                                    <div class="help-block with-errors"></div>
                                </div>
                    
                                <label>Bio:</label>
                                <input class="form-control" type="text" name="userbio" />
                                </br>
                                <div class="row">
                                    <div class="col-md-12">
                                        <input type="hidden" name="hidden" value="<%= result %>" />
                                        <input type="hidden" name="username" value="<%= userName %>">
                                        <input type="hidden" name="password" value="<%= passWord %>">
                                        <input type="submit" class="btn btn-success btn-send" value="Submit" name="submit">
                                        <input type="reset" class="btn btn-warning btn-send" value="Clear" name="clear" />
                                    </div>
                                    
                                </div>
                </div>
            </form>  
            </div>
                                        
            <form action="login.jsp">
                <div class="row">
                    <div class="col-md-12">
                        <input id="login" type="submit" value="Login Page">
                    </div>
                </div>
            </form>
                                        
            <form action="DatabaseUpload" method="POST" onclick="button2()" enctype="multipart/form-data">
                <input type="hidden" name="username" value="<%=userName%>" />
                <input type="file" name="file" class="btn btn-info btn-sm">
                <input type="submit" value="Upload Photo" class="btn btn-info btn-sm">
            </form>

            <div class="row">
                <div class="col-md-4" style="padding-left:20px;  padding-right:50px; border-right: 3px solid #ccc;">
                    <p class="lead">Goals</p> 
                </div>
                <div class="col-md-4" style="padding-left:20px; padding-right:50px; border-right: 3px solid #ccc;">
                    <p class="lead">Groups</p> 
                </div>
                <div class="col-md-4" style="padding-left:20px; padding-right:50px; border-right: 3px solid #ccc;">
                    <p class="lead">Diets</p>
                </div>
            </div>
        </div>
            
        <script language="JavaScript">
            function displayResult(){
                if(document.editprofileform.hidden.value == 1){
                    alert("Data Inserted.");
                }
            }
            
            function button1(){
                document.editprofileform.action = "editProfile.jsp";
            }
            
            function button2(){
                document.
            }
        </script>
    </body>
</html>
