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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Register Guest</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/reset.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/grid_12.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/style.css\">\n");
      out.write("<script src=\"js/jquery-1.7.min.js\"></script>\n");
      out.write("<script src=\"js/jquery.easing.1.3.js\"></script>\n");
      out.write("<script src=\"js/cufon-yui.js\"></script>\n");
      out.write("<script src=\"js/cufon-replace.js\"></script>\n");
      out.write("<script src=\"js/Kozuka_L_300.font.js\"></script>\n");
      out.write("<script src=\"js/Kozuka_B_700.font.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<!--==============================header=================================-->\n");
      out.write("<header>\n");
      out.write("  <div class=\"main\">\n");
      out.write("    <h1><a href=\"homepage.html\"><img src=\"images/logo.png\" alt=\"\"></a></h1>\n");
      out.write("    <div class=\"clear\"></div>\n");
      out.write("  </div>\n");
      out.write("</header>\n");
      out.write("<nav>\n");
      out.write("  <ul class=\"menu\">\n");
      out.write("    <li><a href=\"registerguestuser.html\">Guest Registration</a></li>\n");
      out.write("  </ul>\n");
      out.write("  <div class=\"clear\"></div>\n");
      out.write("</nav>\n");
      out.write("<!--==============================content================================-->\n");
      out.write("<section id=\"content\">\n");
      out.write("   <div align=\"center\">\n");
      out.write("        <div id=\"header\">\n");
      out.write("        <h2>Login Page</h2>\n");
      out.write("    </div>\n");
      out.write("    <!-- Put link here -->\n");
      out.write("    <form action=\"Servlet\" method=\"post\">\n");
      out.write("        <div id=\"login\">\n");
      out.write("            <div>\n");
      out.write("                <label for=\"username\">Username:</label>\n");
      out.write("                <input type=\"text\" id=\"username\" name=\"username\" class=\"textcl\" />\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div>\n");
      out.write("                <label for=\"password\">Password:&nbsp;</label>\n");
      out.write("                <input type=\"password\" id=\"password\" name=\"password\" class=\"textcl\" />\n");
      out.write("            </div>\n");
      out.write("            <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("            <br>\n");
      out.write("            <button name=\"signin\" class=\"btn\">Sign in</button>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("<!--==============================footer=================================-->\n");
      out.write("<footer>\n");
      out.write("  <div>\n");
      out.write("    <p>� Team 2 - CSCI 6050 (Spring 2017)<br></p>\n");
      out.write("  </div>\n");
      out.write("</footer>\n");
      out.write("<script>Cufon.now();</script>\n");
      out.write("</body>\n");
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
