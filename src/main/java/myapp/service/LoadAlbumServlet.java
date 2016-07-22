package myapp.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import myapp.coreservlets.ReadXML;
import myapp.model.Album;
import myapp.model.AllResource;
import myapp.model.Track;
import myapp.util.JPAUtil;
import myapp.service.*;

/**
 * Servlet implementation class CreateAlbum
 */
@WebServlet(name="loadalbum",urlPatterns="/loadalbum")

public class LoadAlbumServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static EntityManager em = JPAUtil.getEntityManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAlbumServlet() {
		// TODO Auto-generated constructor stub
    	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
	    
	    //out.println("in CreateAlbum servlet");
		String strFileName;
		
		//out.println(new File(".").getAbsolutePath());
		
		//String realPath = System.getProperty("user.dir");
		String realPath = request.getSession().getServletContext().getRealPath("/");
//		String rootPath = realPath + "\\uploadAlbum\\";
//		
//		strFileName = rootPath + "asas.xml";
//		System.out.println(strFileName);
		//XMLUtil.readXML(strFileName);
		//out.println(strFileName);
//		ArrayList<HashMap<String, String>> albumInfo;
//		albumInfo = ReadXML.readXML(strFileName);
		
//		LoadAlbum loadAlbum = new LoadAlbum();
//		out.println(loadAlbum.getAlbums(new Long(0)));
    			

    			
		em.getTransaction().begin();
     
		AllResource allResource = em.find(AllResource.class, new Long(1));
		Long aID;
		Album albums = new Album();
		//in track.jsp use this block
		if ((aID = (Long) request.getSession().getAttribute("anameoftrack")) != null) {
			albums = em.find(Album.class, Long.valueOf(aID));
			System.out.println("Id: " + Long.valueOf(aID) + ", name: " + albums.getaName());
			printAlbum(request, response, em, albums);
		}else{
			//in music.jsp use this block	
			System.err.println(allResource.getAlbum().size());
			for(int i=1; i <= allResource.getAlbum().size(); i++){
				albums = em.find(Album.class, new Long(i));
				if (albums == null) {
					continue;
				}
				System.out.println("Id: " + i + ", name: " + albums.getaName());
				printAlbum(request, response, em, albums);
			}
		}
//		out.println(albumsStr);
		
//		out.close();
		em.getTransaction().commit();
            
            
//            if (albums != null && albums.getTracks() != null){
//            	for (int j = 0; j < albums.gettNumber(); j++) {
//            		Track temp = albums.getTracks().get(j);
//                	System.out.println("in " + albums.getaName() + " : " + "id " + temp.gettID() + " " + temp.getTrackName());
//    			}
//            }
            

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void printAlbum(HttpServletRequest request, HttpServletResponse response, EntityManager em, Album albums) throws IOException {
		PrintWriter out = response.getWriter();
		if (albums != null && albums.getaID() != null) {
    		
    		out.println("<hr class='featurette-divider'>"
					+ " <div class='row featurette'> "
					+ "<div class='col-md-7'>");
			
    		out.println("<h2 class='featurette-heading'>"
					+ albums.getAritist()
					+ "<span class='text-muted'>. : &nbsp;"
					+ albums.getaGenre()
					+ "</span></h2>");
    		out.println("<p class='lead'>"
					+ albums.getReview()
					+ "</p>");
    		out.println("<table class='table'>    "
					+ " <thead>             "
					+ " <tr>               "
					+ " <th></th>                "
					+ "<th></th>                "
					+ "<th></th>               "
					+ " <th></th>            "
					+ "  </tr>           "
					+ " </thead>");
    		
			HttpSession album2track = request.getSession();
			album2track.setAttribute("album", albums.getaID());
			request.setAttribute("album", albums.getaID());

			out.println("<tbody>");
//    				+ "              <% session.setAttribute('album', "+ albums.getaName() + "); "
//    				+ "            request.setAttribute('album',"+ albums.getaName() + ");           "
//    						+ "            %>            <%! String tempalbumName = ' "+ albums.getaName() + " ';%>"
//    								+ "   "//<jsp:include>
			LoadTracksServlet loadTrack = new LoadTracksServlet();
			loadTrack.printTrack(request, response, em);
    								out.println("            </tbody>"
    										+ "          </table>");
//    		System.err.println(albums.getaCover());
    		String cover = albums.getaCover().substring(albums.getaCover().lastIndexOf("\\")+1);
    		if (!cover.startsWith("images")) {
				cover = "images/" + cover;
			}
//    		System.out.println();
//    		System.err.println(cover);
			out.println("</div>"
    				+ "        <div class='col-md-5'>"
    						+ "          <a href='track.jsp?anameoftrack="+ albums.getaID() + "'>"
    						+ "<img class='featurette-image img-responsive center-block' data-src='holder.js/400x400/auto' "
//    						+ "src=' " + albums.getaCover() 
    						+ "src='" + cover + "' "
    						+ " ' alt='Generic placeholder image'>"
    								+ "</a>"
    								+ "        </div>"
    								+ "      </div>");
    	}
    	out.flush();
	}
}