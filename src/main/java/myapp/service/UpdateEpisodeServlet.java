package myapp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.*;
import com.jspsmart.*;

import myapp.coreservlets.*;
import myapp.model.*;
import myapp.modelDAO.*;
import myapp.util.*;
import myapp.service.*;
/**
 * Servlet implementation class writeInfo
 */
@WebServlet(name="UpdateEpisodeServlet",urlPatterns="/UpdateEpisodeServlet")
public class UpdateEpisodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	private ServletConfig config;  
	final public void init(ServletConfig config) throws ServletException {
		this.config = config;  
	} 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		System.err.println("in UpdateEpisodeServlet");
		SmartUpload mySmartUpload = new SmartUpload();
    	mySmartUpload.initialize(config, req, resp);  
    	
        Map<String, String> files = new HashMap<>();
        
        //only upload cover pic in album

			
			String eIDstr = (String) req.getSession().getAttribute("eID");
//			String eIDstr = req.getParameter("eID");
			Long eID = Long.valueOf(eIDstr);
			Episode newEpisode = manager.find(Episode.class, eID);
			
			if (newEpisode == null) {
				newEpisode = new Episode();
			}
			
			newEpisode.seteName(mySmartUpload.getRequest().getParameter("Ename"));
			newEpisode.setLength(mySmartUpload.getRequest().getParameter("Duration"));
			newEpisode.setSeanson(mySmartUpload.getRequest().getParameter("Sname"));
			
			//two methods can upload
			String tvCoverAddr;
			String episodeAddr;
			if (newEpisode.getThumbnailAddress() == null) {
				if ((tvCoverAddr = mySmartUpload.getRequest().getParameter("tvName")) != null) {
					newEpisode.setThumbnailAddress(tvCoverAddr);
				} else {
					newEpisode.setThumbnailAddress(files.get("Cover"));
				}
				
				if ((episodeAddr = mySmartUpload.getRequest().getParameter("tvName")) != null) {
					newEpisode.seteAddress(episodeAddr);
				} else {
					newEpisode.seteAddress(files.get("Address"));
				}
				
			}		
			System.err.println(newEpisode.getThumbnailAddress());
	
			System.err.println(newEpisode.geteAddress());
			String tvID = mySmartUpload.getRequest().getParameter("TVname");
			if (tvID == null) {
				tvID = "1";
			}
			new EpisodeDAO().saveOrUpdateEpisode(tvID, eID, newEpisode);	
			
			System.out.println();
			System.out.println(newEpisode.geteAddress());
			resp.sendRedirect("TVshow.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
