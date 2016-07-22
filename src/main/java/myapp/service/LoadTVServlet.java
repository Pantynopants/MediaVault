package myapp.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myapp.model.*;
import myapp.util.JPAUtil;

/**
 * Servlet implementation class CreateAlbum
 */
@WebServlet(name="loadtv",urlPatterns="/loadtv")
public class LoadTVServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager em = JPAUtil.getEntityManager();
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadTVServlet() {
		// TODO Auto-generated constructor stub
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		em.getTransaction().begin();
		
		AllResource allResource = em.find(AllResource.class, new Long(1));
		TVshow tvshows = new TVshow();
		
		for(int i=1; i <= allResource.getTVshow().size(); i++){
			tvshows = em.find(TVshow.class, new Long(i));
			if (tvshows == null) {
				continue;
			}
			System.out.println("Id: " + i + ", name: " + tvshows.gettName());
			printTV(request, response, em, tvshows);
		}
		
		
		em.getTransaction().commit();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	public void printTV(HttpServletRequest req, HttpServletResponse resp, EntityManager em, TVshow tv) throws ServletException, IOException {
		resp.setContentType("text/html");
	    PrintWriter out = resp.getWriter();
	    String coverAddr = tv.gettCover();
	    if (coverAddr.startsWith("\\")) {
	    	coverAddr = coverAddr.substring(coverAddr.lastIndexOf("\\")+1);
	    	coverAddr = "images/" + coverAddr;
		}
	    out.println("<div class='col-lg-4'>");
	    out.println("<a href='" + "display.jsp?tvID="+ tv.gettvID() +"' >");
	    out.println(" <div class='pic-hover-msg' style=' background: "
	    		+ "url(" + coverAddr + "); "
	    		+ "width:320px;height:200px;'> </div>");
	    out.println("</a><h3>"
	    		+ tv.gettName()
	    		+ ":" + tv.gettGenre()
	    		+ "</h3>");
	    out.println(tv.getStudio() + "<br>"+ tv.geteNumber() + "  " + tv.getTypicalLength() + "</div>");
	    
	}
}
