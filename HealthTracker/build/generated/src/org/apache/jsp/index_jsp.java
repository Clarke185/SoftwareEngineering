package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Home</title>\n");
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
      out.write("                    \n");
      out.write("                    <h1>Home</h1>\n");
      out.write("\n");
      out.write("                    <p class=\"lead\">Please select where you want to go.</p>\n");
      out.write("\n");
      out.write("                        <div class=\"messages\"></div>\n");
      out.write("\n");
      out.write("                        <div class=\"controls\">\n");
      out.write("                        \n");
      out.write("                        <form action=\"newuser.jsp\">\n");
      out.write("                            <label for=\"newuser\">User Creation Page:</label>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input id=\"newuser\" type=\"submit\" value=\"New User\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                        </form> \n");
      out.write("                    \n");
      out.write("                        <form action=\"login.jsp\">\n");
      out.write("                            <label for=\"login\">Login Page:</label>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-12\">\n");
      out.write("                                        <input id=\"login\" type=\"submit\" value=\"Login\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                        </form>\n");
      out.write("                        </div>\n");
      out.write("                </div>  <!-- Center alignment column -->\n");
      out.write("            </div>  <!-- Row -->\n");
      out.write("        </div> <!-- Container -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-1.12.0.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"validator.js\"></script>\n");
      out.write("        <script src=\"contact.js\"></script>\n");
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
