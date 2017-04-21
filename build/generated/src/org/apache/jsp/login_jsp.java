package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Register Guest</title>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/reset.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/grid_12.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/style.css\">\r\n");
      out.write("        <script src=\"js/jquery-1.7.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.easing.1.3.js\"></script>\r\n");
      out.write("        <script src=\"js/cufon-yui.js\"></script>\r\n");
      out.write("        <script src=\"js/cufon-replace.js\"></script>\r\n");
      out.write("        <script src=\"js/Kozuka_L_300.font.js\"></script>\r\n");
      out.write("        <script src=\"js/Kozuka_B_700.font.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!--==============================header=================================-->\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"main\">\r\n");
      out.write("                <h1><a><img src=\"images/logo.png\" alt=\"\"></a></h1>\r\n");
      out.write("                <div class=\"clear\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <!--==============================content================================-->\r\n");
      out.write("        <section id=\"content\">\r\n");
      out.write("            <div align=\"center\">\r\n");
      out.write("                <div id=\"header\">\r\n");
      out.write("                    <h2>Login Page</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Put link here -->\r\n");
      out.write("                <form action=\"Servlet\" method=\"post\">\r\n");
      out.write("                    <div id=\"login\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <label for=\"username\">Username:</label>\r\n");
      out.write("                            <input type=\"text\" id=\"username\" name=\"username\" class=\"textcl\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <label for=\"password\">Password:&nbsp;</label>\r\n");
      out.write("                            <input type=\"password\" id=\"password\" name=\"password\" class=\"textcl\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p> <!--Error message is printed here from servlet.java-->\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <button name=\"signin\" class=\"btn\">Sign in</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!--==============================footer=================================-->\r\n");
      out.write("        <footer>\r\n");
      out.write("            <div>\r\n");
      out.write("                <p>� Team 2 - CSCI 6050 (Spring 2017)<br></p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("        <script>Cufon.now();</script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
