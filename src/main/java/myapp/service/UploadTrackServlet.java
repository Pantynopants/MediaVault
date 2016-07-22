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
@WebServlet(name="UploadTrack",urlPatterns="/UploadTrack")
public class UploadTrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	private ServletConfig config;  
	final public void init(ServletConfig config) throws ServletException {  
		this.config = config;  
	} 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.err.println("in UploadTrackServlet");
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
			
			Track newTrack = new Track();
			
			newTrack.setTrackName(mySmartUpload.getRequest().getParameter("fileName"));
			//two methods can upload
			String trackAddr;
			if (newTrack.gettAddress() == null) {
				if ((trackAddr = mySmartUpload.getRequest().getParameter("trackName")) != null) {
					newTrack.settAddress(trackAddr);
				} else {
					newTrack.settAddress(files.get("Address"));
				}
			}		
			System.err.println(newTrack.gettAddress());
			newTrack.settDuration(mySmartUpload.getRequest().getParameter("duration"));
			
			new TrackDAO().addTrack(mySmartUpload.getRequest().getParameter("album-name"), newTrack);
			
		} catch (SmartUploadException e) {

			e.printStackTrace();
		}
        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
