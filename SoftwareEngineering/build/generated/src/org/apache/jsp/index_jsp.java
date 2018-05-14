package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>New Exercise</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h1>Enter new</h1>\n");
      out.write("        <form name=\"singleExerciseForm\" action=\"display.jsp\" method=\"POST\">\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Exercise identifier : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"exerciseID\" value=\"e.g. Friday Night Run\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Exercise type : </td>\n");
      out.write("                        <td><select name=\"exerciseType\">\n");
      out.write("                                <option>Cycling</option>\n");
      out.write("                                <option>Walking</option>\n");
      out.write("                                <option>Dancing</option>\n");
      out.write("                                <option>Running</option>\n");
      out.write("                                <option>Yoga</option>\n");
      out.write("                                <option>Housework</option>\n");
      out.write("                                <option>Swimming</option>\n");
      out.write("                                <option>Weight-lifting</option>\n");
      out.write("                                <option>Team sport (e.g. football)</option>\n");
      out.write("                                <option>Unspecified (high heart rate)</option>\n");
      out.write("                                <option>Unspecified (low heart rate)</option>\n");
      out.write("                            </select></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Exercise time : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"exerciseTime\" value=\"in minutes\" size=\"30\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                ");

//                String exerciseID = new String();
//                String exerciseType = new String();
//                String exerciseTimeString = new String();
//                
//                exerciseID = request.getParameter("exerciseID");
//                exerciseType = request.getParameter("exerciseType");
//                exerciseTimeString = request.getParameter("exerciseTime");
////                int exerciseTime = Integer.parseInt(exerciseTimeString);
//                int calsPerHour = 0;
//                int calsBurnt = 0;
//
//                switch (exerciseType) {
//                    case "Cycling" :  calsPerHour = 270;
//                             break;
//                    case "Walking" :  calsPerHour = 180;
//                             break;
//                    case "Dancing" :  calsPerHour = 360;
//                             break;
//                    case "Running" :  calsPerHour = 720;
//                             break;
//                    case "Yoga" :  calsPerHour = 250;
//                             break;
//                    case "Housework" :  calsPerHour = 130;
//                             break;
//                    case "Swimming ":  calsPerHour = 500;
//                             break;
//                    case "Weight-lifting" :  calsPerHour = 180;
//                             break;
//                    case "Team sport (e.g. football)":  calsPerHour = 590;
//                             break;
//                    case "Unspecified (high heart rate)" : calsPerHour = 800;
//                             break;
//                    case "Unspecified (low heart rate)" : calsPerHour = 200;
//                             break;
//                }
//                calsBurnt = exerciseTime * (calsPerHour/60);
                
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"reset\" value=\"CLEAR\" name=\"clear\" />\n");
      out.write("            <input type=\"submit\" value=\"SUBMIT\" name=\"submit\" />\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("        \n");
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
