package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class GDDangNhap670_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>GaraMan - Đăng nhập</title>\n");
      out.write("    <style>\n");
      out.write("        /* Main body styling */\n");
      out.write("        body {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            height: 100vh;\n");
      out.write("            margin: 0;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-color: #E3F2FD; /* Light blue background */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Container for the login form */\n");
      out.write("        .container {\n");
      out.write("            background: #ffffff;\n");
      out.write("            border-radius: 12px;\n");
      out.write("            box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.1);\n");
      out.write("            padding: 40px;\n");
      out.write("            width: 100%;\n");
      out.write("            max-width: 420px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Logo and heading styling */\n");
      out.write("        .logo img {\n");
      out.write("            width: 300px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h1 {\n");
      out.write("            color: #1A237E; /* Dark blue for branding */\n");
      out.write("            font-size: 24px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            font-weight: 700;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Label styling */\n");
      out.write("        label {\n");
      out.write("            font-size: 15px;\n");
      out.write("            color: #0D47A1; /* Deep blue for labels */\n");
      out.write("            display: block;\n");
      out.write("            text-align: left;\n");
      out.write("            margin-bottom: 6px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Input styling */\n");
      out.write("        input[type=\"text\"], input[type=\"password\"] {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            border: 1px solid #90CAF9;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            font-size: 16px;\n");
      out.write("            background-color: #E3F2FD; /* Light blue for inputs */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Button styling */\n");
      out.write("        .btn-login {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            color: #ffffff;\n");
      out.write("            background-color: #1976D2; /* Vibrant blue for button */\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Hover effect for button */\n");
      out.write("        .btn-login:hover {\n");
      out.write("            background-color: #1565C0; /* Slightly darker blue on hover */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Error message styling */\n");
      out.write("        .error {\n");
      out.write("            color: #D32F2F; /* Red for error message */\n");
      out.write("            font-size: 14px;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <!-- Logo Section -->\n");
      out.write("        <!-- Page Title -->\n");
      out.write("        <h1>Đăng nhập</h1>\n");
      out.write("\n");
      out.write("        <!-- Login Form -->\n");
      out.write("        <form method=\"POST\" action=\"doDangNhap670.jsp\">\n");
      out.write("            <label for=\"username\">Tên đăng nhập</label>\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\" required>\n");
      out.write("\n");
      out.write("            <label for=\"password\">Mật khẩu</label>\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" required>\n");
      out.write("\n");
      out.write("            <button type=\"submit\" class=\"btn-login\">Đăng nhập</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("       ");
 
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    
      out.write("\n");
      out.write("        <p style=\"color: red;\">");
      out.print( errorMessage );
      out.write("</p>\n");
      out.write("    ");
 
        }
    
      out.write("\n");
      out.write("    \n");
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
