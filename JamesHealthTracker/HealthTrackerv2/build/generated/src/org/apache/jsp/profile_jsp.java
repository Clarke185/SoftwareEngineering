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

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("    function sleep(milliseconds) {\n");
      out.write("      var start = new Date().getTime();\n");
      out.write("      for (var i = 0; i < 1e7; i++) {\n");
      out.write("        if ((new Date().getTime() - start) > milliseconds){\n");
      out.write("          break;\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function change(){\n");
      out.write("        sleep(500);\n");
      out.write("        document.getElementById(\"uploadbutton\").type=\"submit\"; \n");
      out.write("    }\n");
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
      out.write("        ");

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
            
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <div class=\"text-center\">\n");
      out.write("                        <h1> ");
 out.println(firstName + " " + lastName); 
      out.write("</h1>\n");
      out.write("                        <h4> ");
 out.println(userName); 
      out.write("</h4>\n");
      out.write("                        <!--<a class=\"btn-primary btn-xs\" href=\"#\" role=\"button\"> Facebook </a>\n");
      out.write("                        <a class=\"btn-primary btn-xs\" href=\"#\" role=\"button\"> Twitter </a>\n");
      out.write("                        <a class=\"btn-primary btn-xs\" href=\"#\" role=\"button\"> Instagram </a><br/> -->\n");
      out.write("                        <img src='GetImage' width=\"200\" height=\"200\" border=\"5\" alt=\"\">\n");
      out.write("                        <hr />\n");
      out.write("                        <p align=\"left\">Want to edit your profile? Click the button below!</p>\n");
      out.write("                        <form action=\"editProfile.jsp\" method=\"POST\">\n");
      out.write("                            <input type=\"submit\" value=\"Edit Profile\" class=\"btn btn-info btn-sm\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                        \n");
      out.write("                \n");
      out.write("                        \n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    </br></br></br>\n");
      out.write("                    <p class=\"lead\">Your Details: </p>\n");
      out.write("                    <hr />\n");
      out.write("                    <table border=\"0\" width=\"100%\">\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><h4>Height (cm):</h4></td>\n");
      out.write("                                <td><h4>Weight (kg):</h4></td>\n");
      out.write("                                <td><h4>BMI:</h4></td>\n");
      out.write("                                <td><h4>Overall Rating:</h4></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><h4>");
 out.println(height);
      out.write("</h4></td>\n");
      out.write("                                <td><h4>");
 out.println(weight);
      out.write("</h4></td>\n");
      out.write("                                <td><h4>");
out.println(bmi);
      out.write("</h4></td>\n");
      out.write("                                <td><h4>\n");
      out.write("                                    ");
                              
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
                                    }
      out.write("\n");
      out.write("                                </h4></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                    <hr />\n");
      out.write("                    <table border=\"0\" width=\"100%\">\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><h4>User Bio: </h4></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><p> ");
 out.println(userbio); 
      out.write(" </p></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <br/>\n");
      out.write("            <hr />\n");
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
