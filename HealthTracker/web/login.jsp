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
        <title>Login</title>
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

                    <h1>Login Page</h1>

                    <p class="lead">Please enter your username and password.</p>

                        <div class="messages"></div>

                        <div class="controls">
                            <form id="contact-form" method="POST" action="display.jsp" role="form">

                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="form_uname">Username *</label>
                                            <input id="form_uname" type="text" name="username" class="form-control" placeholder="Please enter your username *" required="required" data-error="Username is required.">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="form_pwd">Password *</label>
                                            <input id="form_pwd" type="password" name="password" class="form-control" placeholder="Please enter your password *" required="required" data-error="Password is required.">
                                              <button type="button" class="btn btn-primary" data-toggle="button" onclick="togglePwdView()" aria-pressed="false" autocomplete="off"> Show Password</button>
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    
                                </div>
                                
                                <div class="row">
                                    <div class="col-md-12">
                                        <input type="submit" class="btn btn-success btn-send" value="Submit" name="submit">
                                        <input type="reset" class="btn btn-warning btn-send" value="Clear" name="clear" />
                                    </div>
                                    
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <p class="text-muted"><strong>*</strong> Indicates a required field.</p>
                                    </div>
                                </div>

                            </form>  
                        </div>
                        
                        <form action="index.jsp">
                            <label for="login">No account? Create one below :</label>
                                <div class="row">
                                    <div class="col-md-12">
                                        <input id="login" type="submit" value="Create Account">
                                    </div>
                                </div>
                        </form>  
                </div>  <!-- Center alignment column -->
            </div>  <!-- Row -->
        </div> <!-- Container -->
        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="validator.js"></script>
        <script src="contact.js"></script>
        
        <script>
            function togglePwdView() {
                var x = document.getElementById("form_pwd");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
        </script>
    </body>
</html>
