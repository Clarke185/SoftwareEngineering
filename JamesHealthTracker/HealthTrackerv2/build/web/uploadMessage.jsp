<%-- 
    Document   : uploadMessage
    Created on : 03-May-2018, 11:55:20
    Author     : James Clarke - jamesmichaelclarke@hotmail.co.uk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
        <link href='custom.css' rel='stylesheet' type='text/css'>
        <title>Message</title>
    </head>
    <body background="BackgroundImage">
        <center>
            
            <h2><%=request.getAttribute("Message")%></h2>
            <p>Click the button below to return to your profile</p>
            <form id="contact-form" method="POST" action="loginAction.jsp" role="form">
                <input type="submit" class="btn btn-success btn-send" value="Profile" name="submit">
                <input type="hidden" name="username" value=<%=request.getSession().getAttribute("username")%> >
                <input type="hidden" name="password" value=<%=request.getSession().getAttribute("password")%> >
                
            </form>
        </center>
    </body>
</html>
