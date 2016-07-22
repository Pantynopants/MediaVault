package coreservlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.jspsmart.upload.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import com.jspsmart.*;

/**
 * Servlet implementation class addTrack
 */
@WebServlet(name="addTrack",urlPatterns="/addTrack")

public class addTrack extends HttpServlet {
	private ServletConfig config;  
	 final public void init(ServletConfig config) throws ServletException {  
	  this.config = config;  
	 } 
	 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTrack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = 0;  
        String realPath;
        String rootPath;
        
        SmartUpload mySmartUpload = new SmartUpload();  
        try {  
              //初始化     
              mySmartUpload.initialize(config, request, response);  
              
             //上传  
             mySmartUpload.upload(); 
             //su.upload()好象必须放在前面，测试中将su.upload()放在获取参数后面不成功。
             System.out.println(mySmartUpload.getRequest().getParameter("path"));
             System.out.println(mySmartUpload.getRequest().getParameter("other"));
             for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {  
              com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(i);  
              String fileName = myfile.getFileName();  
              //保存  
//              count = mySmartUpload.save("/upload");  
              realPath = request.getServletContext().getRealPath("/");
              rootPath = realPath + "\\Album\\";
              File file = new File(rootPath);  
              if(!file.exists()) {  
            	  file.mkdir();
                  System.out.println("create folder " + file.getPath() + " OK");  
                   
              }  
              
//      		System.out.print(rootPath);
      		count = mySmartUpload.save(rootPath);  
              //count = mySmartUpload.save(null);  
             }  
             System.out.println(count + " file uploaded.");  
        } catch (Exception e) {  
        	 System.out.println("Unable to upload the file.<br>");  
        	 System.out.println("Error : " + e.toString());  
        }
        

        Element album = new Element("album");
		Element track = new Element("track");
		Element position = new Element("position");
		Element tracktitle = new Element("title");
		Element duration = new Element("duration");
		
		SAXBuilder builder = new SAXBuilder();
        String albumname = mySmartUpload.getRequest().getParameter("album-name");
        System.out.println(albumname);
        
        String trackName = mySmartUpload.getRequest().getParameter("fileName");
        System.out.println(trackName);
        if (trackName == null) {
			trackName = "not found";
		}
        
        if (albumname == null) {
        	albumname = "Sugar";
		}
//        String path = "../WebContent/mediaLibrary/info/album/";
        realPath = request.getServletContext().getRealPath("/");
        rootPath = realPath + "\\uploadAlbum\\";
		System.out.print(rootPath);
		
		Document read_doc = null;
		try {
			read_doc = builder.build(new File(rootPath + albumname + ".xml"));
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root = read_doc.getRootElement() ;	
		Element tracks = (Element) root.getChild("tracks") ;	
		List<Element> list = tracks.getChildren("track");
		int numberOfTracks = list.size();
		
       // Attribute id = new Attribute("id","tracknumber");
        String p = "" + (numberOfTracks+1);
        position.setText(p);
        tracktitle.setText(trackName);
        duration.setText("");
        track.addContent(position);
        track.addContent(tracktitle);
        String temp = mySmartUpload.getRequest().getParameter("duration");
        
        if ( temp == null){
        	duration.setText("");
        }else{
        	duration.setText(temp);
        }
        System.out.println(duration);
        track.addContent(duration);
        tracks.addContent(track);
        XMLOutputter out = new XMLOutputter();
        albumname = rootPath + albumname + ".xml";
        saveXML(read_doc,albumname);
        
//	    response.sendRedirect("upload.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void saveXML(Document doc,String file) {
		         // 灏哾oc瀵硅薄杈撳嚭鍒版枃浠�
		          try {
		              // 鍒涘缓xml鏂囦欢杈撳嚭娴�
		              XMLOutputter xmlopt = new XMLOutputter();
		  
		              // 鍒涘缓鏂囦欢杈撳嚭娴�
		              FileWriter writer = new FileWriter(file);
		 
		             // 灏哾oc鍐欏叆鍒版寚瀹氱殑鏂囦欢涓�
		             xmlopt.output(doc, writer);
		             writer.close();
	         } catch (Exception e) {
		             e.printStackTrace();
		     }
     }

}
