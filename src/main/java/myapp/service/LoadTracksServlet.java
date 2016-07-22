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
import myapp.model.AllResource;
import myapp.util.JPAUtil;

/**
 * Servlet implementation class CreateAlbum
 */
@WebServlet(name="loadtrack",urlPatterns="/loadtrack")
public class LoadTracksServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EntityManager em = JPAUtil.getEntityManager();
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadTracksServlet() {
		// TODO Auto-generated constructor stub
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//put it into GET sothat every time request can get different AllResource
		em.getTransaction().begin();
		        
		AllResource allResource = em.find(AllResource.class, new Long(1));
		printTrack(request, response, em);
		em.getTransaction().commit();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	public void printTrack(HttpServletRequest request, HttpServletResponse response, EntityManager em) throws IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    Long albumID = (Long) request.getSession().getAttribute("album");
	    
	    if (albumID == null) {
			albumID = new Long(1);
		}
	    Album ownerAlbum = em.find(Album.class, albumID);
	    
	    for(int i=0; i < ownerAlbum.getTracks().size(); i++){
	    	Track track = ownerAlbum.getTracks().get(i);
	    	if (track == null) {
				continue;
			}
	    	
			String title = track.getTrackName();
			String position = track.gettAddress();
			String duration = track.gettDuration();
			
			System.err.println(position);
			if (position.startsWith("\\")) {
				position = position.substring(position.lastIndexOf("\\")+1);
			}			
			if (!position.startsWith("images") || !position.startsWith("/images")) {
				position = "images/" + position;
			}
			System.out.println(position);
			out.println("<tr>");
				out.println("<td>" + (i+1) + "</td>");
				out.println("<td>"+ title + "</td>");
				out.println("<td>");
				out.println("<audio controls='controls' src='" + position + "' ></audio>");
				out.println("</td>");
				out.println("<td>"+ duration + "</td>");
				out.println("<td>");			
				
					out.println("<form name='input' action=" + position + " method='get'>");
						out.println("<div  class='bnr-one'>");
							out.println("<div class='bnr-btn' style='float:right;'>");
								out.println("<input type='submit' value='Addto List'>");
							out.println("</div>");
							out.println("<div class='bnr-btn' style='float:right;'>");
								out.println("<input type='submit' value='Download'>");
							out.println("</div>");
						out.println("</div>");
					out.println("<form>");
				out.println("</td>");
			out.println("<tr>");
		}
	    
	}
}
