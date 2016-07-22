package myapp.coreservlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jdom2.*;
import org.jdom2.output.XMLOutputter;

import com.jspsmart.upload.*;
import com.jspsmart.*;
/**
 * Servlet implementation class writeInfo
 */
@WebServlet(name="writeInfo",urlPatterns="/writeInfo")

public class writeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private ServletConfig config;  
	 final public void init(ServletConfig config) throws ServletException {  
	  this.config = config;  
	 } 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public writeInfo() {
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
        String thumbfileName = "";
        try {  
              //初始化     
              mySmartUpload.initialize(config, request, response);  
              
             //上传  
             mySmartUpload.upload(); 
             //su.upload()好象必须放在前面，测试中将su.upload()放在获取参数后面不成功。
             
             for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {  
              com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(i);  
              thumbfileName = myfile.getFileName();  
              System.out.println(thumbfileName);
              //保存  
//              count = mySmartUpload.save("/upload");  
              realPath = request.getSession().getServletContext().getRealPath("/");
              rootPath = realPath + "\\TV\\";
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
		Element title = new Element("title");
		Element artist = new Element("artist");
		Element genre = new Element("genre");
		Element review = new Element("review");
		Element tracks = new Element("tracks");
		Element track = new Element("track");
		Element position = new Element("position");
		Element tracktitle = new Element("tracktitle");
		Element tracknumber = new Element("tracknumber");
		Element duration = new Element("duration");
       // Attribute id = new Attribute("id","tracknumber");
        Document doc = new Document(album);
        title.setText(mySmartUpload.getRequest().getParameter("album-name"));  
        artist.setText(mySmartUpload.getRequest().getParameter("artist-name"));
        genre.setText(mySmartUpload.getRequest().getParameter("genre"));
        review.setText(mySmartUpload.getRequest().getParameter("album-introduction"));
        tracks.setText("");
        album.addContent(title);
        album.addContent(artist);
        album.addContent(genre);
        album.addContent(review);
        album.addContent(tracks);
        XMLOutputter out = new XMLOutputter() ;
        String filename = request.getParameter("album-name");
        
//        String realPath = request.getServletPath();
        realPath = request.getSession().getServletContext().getRealPath("/");
        rootPath = realPath + "\\uploadAlbum\\";
		System.out.print(rootPath);
		
        filename = rootPath + filename + ".xml";
        File file = new File(filename);
        try {
            if (file.createNewFile()){
        		out.output(doc,new FileOutputStream(file)) ;
                System.out.println("create file " + filename + " successful");  
            } else {
                System.out.println("create file " + filename + " successful");  
            }  
        } catch (IOException e) {
            e.printStackTrace();  
            System.out.println("create file " + filename + " unsuccessful" + e.getMessage());  
        }  

	    //response.sendRedirect("/album.jsp");
        //response.sendRedirect("/NEU/album.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

		
}
