<%-- 
    Document   : loginAction
    Created on : 02-May-2018, 11:57:01
    Author     : James Clarke - jamesmichaelclarke@hotmail.co.uk
--%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@ page import ="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Class.forName("org.postgresql.Driver");  //Postgres database
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
        <link href='custom.css' rel='stylesheet' type='text/css'>
        <title>Logging in</title>
    </head>
    <body>
        <%@page session="true" %>
        <%!
        public class User{

            String URL = "jdbc:postgresql://localhost:5432/HealthTracker";
            String USERNAME = "postgres";
            String PASSWORD = "";

            Connection connection = null;
            PreparedStatement selectUsers = null;
            ResultSet resultSet = null;


            public User(){
                try{
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                    selectUsers = connection.prepareStatement(
                        "SELECT userid, firstname, surname, username, email, "
                            + "height, weight, bmi, userbio, userimg FROM "
                            + "userinfo WHERE username = ? AND password = ?");

                } catch(SQLException e){
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
                        
            if(users.next()){
                out.println("Valid login credentials");
                String userid = users.getString("userid");
                String first = users.getString("firstname");
                String last = users.getString("surname");
                session.setAttribute("password", passWord);
                session.setAttribute("username", userName);
                int height = users.getInt("height");
                int weight = users.getInt("weight");
                int bmi = users.getInt("bmi");
                
                String userbio = users.getString("userbio");
                if(userbio == null){
                    userbio = "This user does not have a bio.";
                }
                
                String test = users.getString("userimg");
                System.out.println(test);
                if(test == null){
                    System.out.println("Image path is empty");
                } else {
                    InputStream imageStream = users.getBinaryStream("userimg");
                    String imageName = "C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 8.0.27\\webapps\\data\\" + userid + ".jpg";
                    FileOutputStream f = new FileOutputStream(imageName);
                    byte buff[] = new byte[1024];
                    int l;
                    while((l = imageStream.read(buff)) > 0){
                        f.write(buff, 0, l);
                    }
                    f.close();
                }
                session.setAttribute("userid", userid);
                session.setAttribute("user", userName);
                session.setAttribute("pass", passWord);
                session.setAttribute("first", first);
                session.setAttribute("last", last);
                session.setAttribute("height", height);
                session.setAttribute("weight", weight);
                session.setAttribute("bmi", bmi);
                session.setAttribute("userbio", userbio);

                response.sendRedirect("http://localhost:8084/HealthTrackerv2/profile.jsp");
            } else {
                out.println("Invalid login credentials");
                //response.sendRedirect("http://localhost:8084/HealthTrackerv2/login.jsp");
            }
        %>

    </body>
</html>
