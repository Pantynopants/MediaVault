package coreservlets;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

/** Servlet that reads a code snippet from the request
 *  and displays it inside a PRE tag. Filters
 *  the special HTML characters.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */

@WebServlet("/code-preview-good")
public class CodePreviewGood extends CodePreviewBad {
  @Override
  protected String getCode(HttpServletRequest request) {
    return(ServletUtilities.filter(super.getCode(request)));
  }
}
