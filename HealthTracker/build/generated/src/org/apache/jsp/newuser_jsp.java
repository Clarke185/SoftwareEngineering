package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class newuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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
      out.write("        <title>New User</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='custom.css' rel='stylesheet' type='text/css'>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body onload=\"displayResult()\">\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-8 col-lg-offset-2\">\n");
      out.write("                    <h1>New User Form</h1>\n");
      out.write("\n");
      out.write("                    <p class=\"lead\">Please enter your details below for creating a new user.</p>\n");
      out.write("                    \n");
      out.write("                        <div class=\"messages\"></div>\n");
      out.write("\n");
      out.write("                        <div class=\"controls\">\n");
      out.write("                            <form name=\"newuserform\" method=\"POST\" action=\"newuser.jsp\">\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"form_name\">Firstname *</label>\n");
      out.write("                                            <input id=\"first\" type=\"text\" name=\"firstname\" class=\"form-control\" placeholder=\"Please enter your firstname *\" required=\"required\" data-error=\"Firstname is required.\">\n");
      out.write("                                            <div class=\"help-block with-errors\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label for=\"form_lastname\">Lastname *</label>\n");
      out.write("                                                <input id=\"last\" type=\"text\" name=\"surname\" class=\"form-control\" placeholder=\"Please enter your lastname *\" required=\"required\" data-error=\"Lastname is required.\">\n");
      out.write("                                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"form_uname\">Username *</label>\n");
      out.write("                                            <input id=\"form_uname\" type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"Please enter a username *\" required=\"required\" data-error=\"Username is required.\">\n");
      out.write("                                            <div class=\"help-block with-errors\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"form_pwd\">Password *</label>\n");
      out.write("                                            <input id=\"form_pwd\" type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Please enter a password *\" required=\"required\" data-error=\"Password is required.\">\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\" onclick=\"togglePwdView()\" aria-pressed=\"false\" autocomplete=\"off\"> Show Password</button>\n");
      out.write("                                            <div class=\"help-block with-errors\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"form_email\">Email Address *</label>\n");
      out.write("                                            <input id=\"form_email\" type=\"email\" name=\"email\" class=\"form-control\" placeholder=\"Please enter an email address *\" required=\"required\" data-error=\"Valid email is required.\">\n");
      out.write("                                            <div class=\"help-block with-errors\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
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
      out.write("                                </br>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input type=\"hidden\" name=\"hidden\" value=\"");
      out.print( result );
      out.write("\" />\n");
      out.write("                                        <input type=\"submit\" class=\"btn btn-success btn-send\" value=\"Submit\" name=\"submit\">\n");
      out.write("                                        <input type=\"reset\" class=\"btn btn-warning btn-send\" value=\"Clear\" name=\"clear\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <p class=\"text-muted\"><strong>*</strong> Indicates a required field.</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </form>  \n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <form action=\"login.jsp\">\n");
      out.write("                            <label for=\"login\">Login Page:</label>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input id=\"login\" type=\"submit\" value=\"Login Page\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                        </form>\n");
      out.write("                        <form action=\"index.jsp\">\n");
      out.write("                            <label for=\"home\">Home Page:</label>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input id=\"home\" type=\"submit\" value=\"Home Page\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                        </form>\n");
      out.write("                </div>  <!-- Center alignment column -->\n");
      out.write("            </div>  <!-- Row -->\n");
      out.write("        </div> <!-- Container -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-1.12.0.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"validator.js\"></script>\n");
      out.write("        <script src=\"contact.js\"></script>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function togglePwdView() {\n");
      out.write("                var x = document.getElementById(\"form_pwd\");\n");
      out.write("                if (x.type === \"password\") {\n");
      out.write("                    x.type = \"text\";\n");
      out.write("                } else {\n");
      out.write("                    x.type = \"password\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script language=\"JavaScript\">\n");
      out.write("            function displayResult(){\n");
      out.write("                if(document.newuserform.hidden.value == 1){\n");
      out.write("                    alert(\"Data Inserted.\");\n");
      out.write("                }\n");
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
