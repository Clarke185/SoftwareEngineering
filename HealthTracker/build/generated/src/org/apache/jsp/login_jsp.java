package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    Class.forName("org.postgresql.Driver"); 

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Login</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='custom.css' rel='stylesheet' type='text/css'>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("                <div class=\"col-lg-8 col-lg-offset-2\">\n");
      out.write("\n");
      out.write("                    <h1>Login Page</h1>\n");
      out.write("\n");
      out.write("                    <p class=\"lead\">Please enter your username and password.</p>\n");
      out.write("\n");
      out.write("                        <div class=\"messages\"></div>\n");
      out.write("\n");
      out.write("                        <div class=\"controls\">\n");
      out.write("                            <form id=\"contact-form\" method=\"POST\" action=\"display.jsp\" role=\"form\">\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"form_uname\">Username *</label>\n");
      out.write("                                            <input id=\"form_uname\" type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"Please enter your username *\" required=\"required\" data-error=\"Username is required.\">\n");
      out.write("                                            <div class=\"help-block with-errors\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"form_pwd\">Password *</label>\n");
      out.write("                                            <input id=\"form_pwd\" type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Please enter your password *\" required=\"required\" data-error=\"Password is required.\">\n");
      out.write("                                              <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\" onclick=\"togglePwdView()\" aria-pressed=\"false\" autocomplete=\"off\"> Show Password</button>\n");
      out.write("                                            <div class=\"help-block with-errors\"></div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input type=\"submit\" class=\"btn btn-success btn-send\" value=\"Submit\" name=\"submit\">\n");
      out.write("                                        <input type=\"reset\" class=\"btn btn-warning btn-send\" value=\"Clear\" name=\"clear\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <p class=\"text-muted\"><strong>*</strong> Indicates a required field.</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </form>  \n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <form action=\"index.html\">\n");
      out.write("                            <label for=\"login\">No account? Create one below :</label>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input id=\"login\" type=\"submit\" value=\"Create Account\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                        </form>  \n");
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
