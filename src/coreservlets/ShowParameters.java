package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

/** Shows all the parameters sent to the servlet via either
 *  GET or POST. Specially marks parameters that have
 *  no values or multiple values.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */

@WebServlet("/show-params")
public class ShowParameters extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Reading All Request Parameters";
    out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#FDF5E6\">\n" +
                "<h1 align=center>" + title + "</H1>\n" +
                "<table border=1 align=center>\n" +
                "<tr bgcolor=\"#FFAD00\">\n" +
                "<th>Parameter Name</th> <th>Parameter Value(s)</th></tr>");
    Enumeration<String> paramNames = request.getParameterNames();
    while(paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      out.print("<tr><td>" + paramName + "</td>\n<td>");
      String[] paramValues =
        request.getParameterValues(paramName);
      if (paramValues.length == 1) {
        String paramValue = paramValues[0];
        if (paramValue.length() == 0)
          out.println("<i>No Value</i>");
        else
          out.println(paramValue);
      } else {
        out.println("<ul>");
        for(int i=0; i<paramValues.length; i++) {
          out.println("<li>" + paramValues[i] + "</li>");
        }
        out.println("</ul>");
      }
      out.println("</td></tr>");
    }
    out.println("</table>\n</body></html>");
  }

  @Override
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
