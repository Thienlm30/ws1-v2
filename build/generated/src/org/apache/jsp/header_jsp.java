package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import thien.ws1.controller.Action;
import thien.ws1.dto.Account;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Product Intro</title>\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"bg-gray-200 shadow shadow-gray-300 w-100 px-8 md:px-auto sticky top-0 z-50\">\n");
      out.write("            <div class=\"md:h-16 h-28 mx-auto md:px-4 container flex items-center justify-between flex-wrap md:flex-nowrap\">\n");
      out.write("\n");
      out.write("                <div class=\"text-gray-500 order-3 w-full md:w-auto md:order-3\">\n");
      out.write("                    <ul class=\"flex font-semibold justify-between\">\n");
      out.write("                        <li class=\"md:px-4 md:py-2 text-indigo-500\"><a href=\"MainController?action=");
      out.print( Action.WELCOME);
      out.write("\">Home</a></li>\n");
      out.write("                        <li class=\"md:px-4 md:py-2 hover:text-indigo-400\"><a href=\"MainController?action=");
      out.print( Action.VIEW_ACCOUNT);
      out.write("\">Account</a></li>\n");
      out.write("                        <li class=\"md:px-4 md:py-2 hover:text-indigo-400\"><a href=\"MainController?action=");
      out.print( Action.VIEW_CATEGORY);
      out.write("\">Categories</a></li>\n");
      out.write("                        <li class=\"md:px-4 md:py-2 hover:text-indigo-400\"><a href=\"MainController?action=");
      out.print( Action.VIEW_PRODUCT);
      out.write("\">Product</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"order-2 md:order-3\">\n");
      out.write("                    <button class=\"px-4 py-2 bg-indigo-500 hover:bg-indigo-600 text-gray-50 rounded-xl flex items-center gap-2\">\n");
      out.write("                        <a href=\"MainController?action=");
      out.print( Action.LOGIN);
      out.write("\">Login</a>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
