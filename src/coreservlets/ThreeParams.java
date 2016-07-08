package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/** Servlet that prints out the param1, param2, and param3
 *  request parameters. Does not filter out HTML tags.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */

@WebServlet("/three-params")
public class ThreeParams extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Reading Three Request Parameters";
    String docType = "<!DOCTYPE html>\n";
    out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#FDF5E6\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>param1</b>: "
                + request.getParameter("param1") + "</li>" + "\n" +
                "  <li><b>param2</b>: "
                + request.getParameter("param2") + "</li>" + "\n" +
                "  <li><b>param3</b>: "
                + request.getParameter("param3") + "</li>" + "\n" +
                "</ul>\n" +
                "</body></html>");
  }
}
