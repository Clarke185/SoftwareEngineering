<%-- 
    Document   : profile
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
    function sleep(milliseconds) {
      var start = new Date().getTime();
      for (var i = 0; i < 1e7; i++) {
        if ((new Date().getTime() - start) > milliseconds){
          break;
        }
      }
    }
    
    function change(){
        sleep(500);
        document.getElementById("uploadbutton").type="submit"; 
    }
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
        <%
            String userid = (String)session.getAttribute("userid");
            String userName = (String)session.getAttribute("user");
            String firstName = (String)session.getAttribute("first");
            String lastName = (String)session.getAttribute("last");
            int height = (int)session.getAttribute("height");
            int weight = (int)session.getAttribute("weight");
            int bmi = (int)session.getAttribute("bmi");
            String userbio = (String)session.getAttribute("userbio");
            
            if(userbio == "" || userbio == null){
                userbio = "This user does not have a bio.";
            }
            
            String userimg = "C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 8.0.27\\webapps\\data\\" + userid + ".jpg";
            
        %>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="text-center">
                        <h1> <% out.println(firstName + " " + lastName); %></h1>
                        <h4> <% out.println(userName); %></h4>
                        <!--<a class="btn-primary btn-xs" href="#" role="button"> Facebook </a>
                        <a class="btn-primary btn-xs" href="#" role="button"> Twitter </a>
                        <a class="btn-primary btn-xs" href="#" role="button"> Instagram </a><br/> -->
                        <img src='GetImage' width="200" height="200" border="5" alt="">
                        <hr />
                        <p align="left">Want to edit your profile? Click the button below!</p>
                        <form action="editProfile.jsp" method="POST">
                            <input type="submit" value="Edit Profile" class="btn btn-info btn-sm">
                        </form>
                    </div>
                </div>
                        
                
                        
                <div class="col-md-8">
                    </br></br></br>
                    <p class="lead">Your Details: </p>
                    <hr />
                    <table border="0" width="100%">
                        <tbody>
                            <tr>
                                <td><h4>Height (cm):</h4></td>
                                <td><h4>Weight (kg):</h4></td>
                                <td><h4>BMI:</h4></td>
                                <td><h4>Overall Rating:</h4></td>
                            </tr>
                            <tr>
                                <td><h4><% out.println(height);%></h4></td>
                                <td><h4><% out.println(weight);%></h4></td>
                                <td><h4><%out.println(bmi);%></h4></td>
                                <td><h4>
                                    <%                              
                                    if(bmi < 19){
                                        out.println("Underweight");
                                    } else if(bmi >= 19 && bmi < 25){
                                        out.println("Ideal BMI");
                                    } else if(bmi >= 25 && bmi < 30){
                                        out.println("Overweight");
                                    } else if(bmi >= 30 && bmi < 34){
                                        out.println("Obese");
                                    } else if(bmi >= 35 && bmi < 39){
                                        out.println("Severely Obese");
                                    } else {
                                        out.println("Morbidly Obese");
                                    }%>
                                </h4></td>
                            </tr>
                        </tbody>
                    </table>
                    <hr />
                    <table border="0" width="100%">
                        <tbody>
                            <tr>
                                <td><h4>User Bio: </h4></td>
                            </tr>
                            <tr>
                                <td><p> <% out.println(userbio); %> </p></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <br/>
            <hr />
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
    </body>
</html>
