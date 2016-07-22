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
@WebServlet(name="UploadAlbum",urlPatterns="/UploadAlbum")
public class UploadAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	private ServletConfig config;  
	 final public void init(ServletConfig config) throws ServletException {  
	  this.config = config;  
	 } 
    /**
     * @see HttpServlet#HttpServlet()
     * @author leo
     */
    public UploadAlbumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	SmartUpload mySmartUpload = new SmartUpload();
    	mySmartUpload.initialize(config, req, resp);  
    	
        Map<String, String> files = new HashMap<>();
        
        //only upload cover pic in album
        try {
			mySmartUpload.upload();
			for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {
				
				com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(i);
				//add relative file path to map
				files.putAll(SaveFile.savefile(myfile, req.getSession().getServletContext().getRealPath("/")));
				
			}
			
			Album newAlbum = new Album();
			newAlbum.setaName(mySmartUpload.getRequest().getParameter("album-name"));
			newAlbum.setaGenre(mySmartUpload.getRequest().getParameter("genre"));
			//two methods can upload
			String coverAddr;
			if ((coverAddr = mySmartUpload.getRequest().getParameter("album-cover")) != null) {
				newAlbum.setaCover(coverAddr);
			} else {
				newAlbum.setaCover(files.get("Cover"));
			}
			System.err.println(newAlbum.getaCover());
			newAlbum.setAritist(mySmartUpload.getRequest().getParameter("artist-name"));
			newAlbum.setReview(mySmartUpload.getRequest().getParameter("album-introduction"));
			newAlbum.setTracksAddress("track.jsp");
			
			new AlbumDAO().addAlbum(newAlbum);
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			resp.sendRedirect("music.jsp");
		}
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }
    

}
