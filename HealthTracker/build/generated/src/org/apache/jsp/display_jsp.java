package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class display_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        public class User {
            String URL = "jdbc:postgresql://localhost:5432/HealthTracker";
            String USERNAME = "postgres";
            String PASSWORD = "";

            Connection connection = null;
            PreparedStatement selectUsers = null;
            ResultSet resultSet = null;

            public User(){
                try {
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    
                    selectUsers = connection.prepareStatement(
                        "SELECT userid, firstname, surname, username, email, height, weight, bmi FROM userinfo"
                         + " WHERE username = ? AND password = ?");
                } catch (SQLException e){
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

      out.write('\n');
      out.write('\n');

    Class.forName("org.postgresql.Driver"); 

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            String userName = new String();
            String passWord = new String();

            userName = request.getParameter("username");
            passWord = request.getParameter("password");
            
            User user = new User();
            ResultSet users = user.getUsers(userName, passWord);
        
      out.write("\n");
      out.write("        \n");
      out.write("        <h1>User (From database) :</h1>\n");
      out.write("        \n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>UserID</td>\n");
      out.write("                    <td>First Name</td>\n");
      out.write("                    <td>Last Name</td>\n");
      out.write("                    <td>Username</td>\n");
      out.write("                    <td>Email</td>\n");
      out.write("                    <td>Height (cm)</td>\n");
      out.write("                    <td>Weight (kg)</td>\n");
      out.write("                    <td>BMI</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 while(users.next()){ 
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( users.getInt("userid") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( users.getString("firstname") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( users.getString("surname") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( users.getString("username") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( users.getString("email") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( users.getInt("height") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( users.getInt("weight") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( users.getInt("bmi") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("<!-- Page Content -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("      <!-- Introduction Row -->\n");
      out.write("      <h1 class=\"my-4\">About Us\n");
      out.write("        <small>It's Nice to Meet You!</small>\n");
      out.write("      </h1>\n");
      out.write("      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sint, explicabo dolores ipsam aliquam inventore corrupti eveniet quisquam quod totam laudantium repudiandae obcaecati ea consectetur debitis velit facere nisi expedita vel?</p>\n");
      out.write("\n");
      out.write("      <!-- Team Members Row -->\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("          <h2 class=\"my-4\">Our Team</h2>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4 col-sm-6 text-center mb-4\">\n");
      out.write("          <img class=\"rounded-circle img-fluid d-block mx-auto\" src=\"http://placehold.it/200x200\" alt=\"\">\n");
      out.write("          <h3>John Smith\n");
      out.write("            <small>Job Title</small>\n");
      out.write("          </h3>\n");
      out.write("          <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4 col-sm-6 text-center mb-4\">\n");
      out.write("          <img class=\"rounded-circle img-fluid d-block mx-auto\" src=\"http://placehold.it/200x200\" alt=\"\">\n");
      out.write("          <h3>John Smith\n");
      out.write("            <small>Job Title</small>\n");
      out.write("          </h3>\n");
      out.write("          <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4 col-sm-6 text-center mb-4\">\n");
      out.write("          <img class=\"rounded-circle img-fluid d-block mx-auto\" src=\"http://placehold.it/200x200\" alt=\"\">\n");
      out.write("          <h3>John Smith\n");
      out.write("            <small>Job Title</small>\n");
      out.write("          </h3>\n");
      out.write("          <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4 col-sm-6 text-center mb-4\">\n");
      out.write("          <img class=\"rounded-circle img-fluid d-block mx-auto\" src=\"http://placehold.it/200x200\" alt=\"\">\n");
      out.write("          <h3>John Smith\n");
      out.write("            <small>Job Title</small>\n");
      out.write("          </h3>\n");
      out.write("          <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4 col-sm-6 text-center mb-4\">\n");
      out.write("          <img class=\"rounded-circle img-fluid d-block mx-auto\" src=\"http://placehold.it/200x200\" alt=\"\">\n");
      out.write("          <h3>John Smith\n");
      out.write("            <small>Job Title</small>\n");
      out.write("          </h3>\n");
      out.write("          <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4 col-sm-6 text-center mb-4\">\n");
      out.write("          <img class=\"rounded-circle img-fluid d-block mx-auto\" src=\"http://placehold.it/200x200\" alt=\"\">\n");
      out.write("          <h3>John Smith\n");
      out.write("            <small>Job Title</small>\n");
      out.write("          </h3>\n");
      out.write("          <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /.container -->\n");
      out.write("        \n");
      out.write("\n");
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
