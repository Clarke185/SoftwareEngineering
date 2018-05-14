<%-- 
    Document   : newUser
    Created on : 16-Mar-2018, 10:57:06
    Author     : James Clarke - jamesmichaelclarke@hotmail.co.uk
--%>
<%@page import="java.sql.*"%>
<% Class.forName("org.postgresql.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New User</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
        <link href='custom.css' rel='stylesheet' type='text/css'>
    </head>
    
    <body onload="displayResult()">
        
        <%!
        public class User {
            String URL = "jdbc:postgresql://localhost:5432/HealthTracker";
            String USERNAME = "postgres";
            String PASSWORD = "";

            Connection connection = null;
            PreparedStatement insertUsers = null;
            ResultSet resultSet = null;

            public User(){
                try {
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    
                    insertUsers = connection.prepareStatement(
                    "INSERT INTO userinfo(firstname, surname, username, email, password, height, weight, bmi) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

            public int setUsers(String first, String last, String usr, String email, String pwd, int height, int weight, double bmi){
                int result = 0;
                
                try{
                    insertUsers.setString(1, first);
                    insertUsers.setString(2, last);
                    insertUsers.setString(3, usr);
                    insertUsers.setString(4, email);
                    insertUsers.setString(5, pwd);
                    insertUsers.setInt(6, height);
                    insertUsers.setInt(7, weight);
                    insertUsers.setDouble(8, bmi);
                    result = insertUsers.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                return result;
            }
        }
        %>
        <%
            int result = 0;
            String firstName = new String();
            String lastName = new String();
            String userName = new String();
            String email = new String();
            String password = new String();
            int height = 0;
            int weight = 0;
            double bmi = 0.0;
            
            firstName = request.getParameter("firstname");
            lastName = request.getParameter("surname");
            userName = request.getParameter("username");
            email = request.getParameter("email");
            password = request.getParameter("password");
            if(request.getParameter("height") != null){
                height = Integer.parseInt(request.getParameter("height"));
            } else {height = 0;}
            if(request.getParameter("weight") != null){
                weight = Integer.parseInt(request.getParameter("weight"));
            } else {weight = 0;}
            if(request.getParameter("bmi") != null){
                bmi = Double.parseDouble(request.getParameter("bmi"));
            } else {bmi = 0;}
            
            
            
            User user = new User();
            result = user.setUsers(firstName, lastName, userName, email, password, height, weight, bmi);
        %>
        
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <h1>New User Form</h1>

                    <p class="lead">Please enter your details below for creating a new user.</p>
                    
                        <div class="messages"></div>

                        <div class="controls">
                            <form name="newuserform" method="POST" action="newUser.jsp">

                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="form_name">Firstname *</label>
                                            <input id="first" type="text" name="firstname" class="form-control" placeholder="Please enter your firstname *" required="required" data-error="Firstname is required.">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="form_lastname">Lastname *</label>
                                                <input id="last" type="text" name="surname" class="form-control" placeholder="Please enter your lastname *" required="required" data-error="Lastname is required.">
                                                <div class="help-block with-errors"></div>
                                            </div>
                                        </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="form_uname">Username *</label>
                                            <input id="form_uname" type="text" name="username" class="form-control" placeholder="Please enter a username *" required="required" data-error="Username is required.">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="form_pwd">Password *</label>
                                            <input id="form_pwd" type="password" name="password" class="form-control" placeholder="Please enter a password *" required="required" data-error="Password is required.">
                                            <button type="button" class="btn btn-primary" data-toggle="button" onclick="togglePwdView()" aria-pressed="false" autocomplete="off"> Show Password</button>
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="form_email">Email Address *</label>
                                            <input id="form_email" type="email" name="email" class="form-control" placeholder="Please enter an email address *" required="required" data-error="Valid email is required.">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                </div>
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
                                </br>
                                <div class="row">
                                    <div class="col-md-12">
                                        <input type="hidden" name="hidden" value="<%= result %>" />
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
                        
                        <form action="login.jsp">
                            <label for="login">Login Page:</label>
                                <div class="row">
                                    <div class="col-md-12">
                                        <input id="login" type="submit" value="Login Page">
                                    </div>
                                </div>
                        </form>
                        <form action="profile.jsp">
                            <label for="profile">Profile Page:</label>
                                <div class="row">
                                    <div class="col-md-12">
                                        <input id="home" type="submit" value="Profile Page">
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
        <script language="JavaScript">
            function displayResult(){
                if(document.newuserform.hidden.value == 1){
                    alert("Data Inserted.");
                }
            }
        </script>
    </body>
</html>
