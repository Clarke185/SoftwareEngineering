package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

public final class editProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("</script>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='custom.css' rel='stylesheet' type='text/css'>\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <title>User Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body background=\"BackgroundImage\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"controls\">\n");
      out.write("            <form name=\"editprofileform\" method=\"POST\" action=\"editProfile.jsp\">\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <div class=\"text-center\">\n");
      out.write("                        <h4><label for=\"form_name\">Firstname</label></h4>\n");
      out.write("                        <input id=\"first\" type=\"text\" name=\"firstname\" class=\"form-control\" placeholder=\"Please enter your firstname\" required=\"required\" data-error=\"Firstname is required.\">\n");
      out.write("                        <div class=\"help-block with-errors\"></div>\n");
      out.write("                        <h4><label for=\"form_name\">Surname</label></h4>\n");
      out.write("                        <input id=\"last\" type=\"text\" name=\"surname\" class=\"form-control\" placeholder=\"Please enter your surname\" required=\"required\" data-error=\"Surname is required.\">\n");
      out.write("                        <div class=\"help-block with-errors\"></div>\n");
      out.write("                        <h4> ");
 out.println(userName); 
      out.write("</h4>\n");
      out.write("                        <img src='GetImage' width=\"200\" height=\"200\" border=\"5\" alt=\"\">\n");
      out.write("                        <hr />\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                        \n");
      out.write("            \n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    </br></br></br>\n");
      out.write("                    <p class=\"lead\">Your Details: </p>\n");
      out.write("                    <hr />\n");
      out.write("                                <div class=\"row\" oninput=\"x.value=(parseFloat(b.value)/(parseFloat(a.value/100)**2)).toFixed(2)\">\n");
      out.write("\n");
      out.write("                                    <div class=\"col-md-3\">\n");
      out.write("                                        <label>Height(cm):</label>\n");
      out.write("                                        <input class=\"form-control\" type=\"number\" name=\"height\" value=\"Height(cm)\" id=\"a\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-3\">\n");
      out.write("                                        <label>Weight(kg):</label>\n");
      out.write("                                        <input class=\"form-control\" type=\"number\" name=\"weight\" value=\"Weight(Kg)\" id=\"b\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-3\">\n");
      out.write("                                        <label>BMI:</label>\n");
      out.write("                                        <input class=\"form-control\"  value=\"BMI\" name=\"bmi\" id=\"x\" for=\"a b\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"help-block with-errors\"></div>\n");
      out.write("                                </div>\n");
      out.write("                    \n");
      out.write("                                <label>Bio:</label>\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"userbio\" />\n");
      out.write("                                </br>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input type=\"hidden\" name=\"hidden\" value=\"");
      out.print( result );
      out.write("\" />\n");
      out.write("                                        <input type=\"hidden\" name=\"username\" value=\"");
      out.print( userName );
      out.write("\">\n");
      out.write("                                        <input type=\"hidden\" name=\"password\" value=\"");
      out.print( passWord );
      out.write("\">\n");
      out.write("                                        <input type=\"submit\" class=\"btn btn-success btn-send\" value=\"Submit\" name=\"submit\">\n");
      out.write("                                        <input type=\"reset\" class=\"btn btn-warning btn-send\" value=\"Clear\" name=\"clear\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                </div>\n");
      out.write("                </div>\n");
      out.write("            </form>  \n");
      out.write("            </div>\n");
      out.write("                                        \n");
      out.write("            <form action=\"login.jsp\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <input id=\"login\" type=\"submit\" value=\"Login Page\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("                                        \n");
      out.write("            <form action=\"DatabaseUpload\" method=\"POST\" onclick=\"button2()\" enctype=\"multipart/form-data\">\n");
      out.write("                <input type=\"file\" name=\"userimg\" value=\"file\" class=\"btn btn-info btn-sm\">\n");
      out.write("                <input type=\"submit\" value=\"Upload Photo\" class=\"btn btn-info btn-sm\">\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-4\" style=\"padding-left:20px;  padding-right:50px; border-right: 3px solid #ccc;\">\n");
      out.write("                    <p class=\"lead\">Goals</p> \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\" style=\"padding-left:20px; padding-right:50px; border-right: 3px solid #ccc;\">\n");
      out.write("                    <p class=\"lead\">Groups</p> \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\" style=\"padding-left:20px; padding-right:50px; border-right: 3px solid #ccc;\">\n");
      out.write("                    <p class=\"lead\">Diets</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        <script language=\"JavaScript\">\n");
      out.write("            function displayResult(){\n");
      out.write("                if(document.editprofileform.hidden.value == 1){\n");
      out.write("                    alert(\"Data Inserted.\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function button1(){\n");
      out.write("                document.editprofileform.action = \"editProfile.jsp\";\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function button2(){\n");
      out.write("                document.\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
