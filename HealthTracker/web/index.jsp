<%-- 
    Document   : user
    Created on : 16-Mar-2018, 10:57:06
    Author     : James Clarke - jamesmichaelclarke@hotmail.co.uk
--%>
<%@page import="java.sql.*"%>
<%
    Class.forName("org.postgresql.Driver"); 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
        <link href='custom.css' rel='stylesheet' type='text/css'>
    </head>
    <body>

        <div class="container">

            <div class="row">

                <div class="col-lg-8 col-lg-offset-2">
                    
                    <h1>Home</h1>

                    <p class="lead">Please select where you want to go.</p>

                        <div class="messages"></div>

                        <div class="controls">
                        
                        <form action="newuser.jsp">
                            <label for="newuser">User Creation Page:</label>
                                <div class="row">
                                    <div class="col-md-12">
                                        <input id="newuser" type="submit" value="New User">
                                    </div>
                                </div>
                        </form> 
                    
                        <form action="login.jsp">
                            <label for="login">Login Page:</label>
                                <div class="row">
                                    <div class="col-md-12">
                                        <input id="login" type="submit" value="Login">
                                    </div>
                                </div>
                        </form>
                        </div>
                </div>  <!-- Center alignment column -->
            </div>  <!-- Row -->
        </div> <!-- Container -->
        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="validator.js"></script>
        <script src="contact.js"></script>
    </body>
</html>
