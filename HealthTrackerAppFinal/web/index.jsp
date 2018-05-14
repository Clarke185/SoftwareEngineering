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
    </head>


    <body>

        <h1>Diet</h1>

        <form action="diet.jsp">
            <input type="submit" value="Meals" />
        </form>




    </body>
</html>
