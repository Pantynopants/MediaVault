package coreservlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.*;
import org.jdom2.output.XMLOutputter;

import com.jspsmart.upload.*;
import com.jspsmart.*;

@WebServlet(name="writeTVshowInfo",urlPatterns="/writeTVshowInfo")
public class writeTVshowInfo extends HttpServlet {
	private ServletConfig config;  
	 final public void init(ServletConfig config) throws ServletException {  
	  this.config = config;  
	 } 
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public writeTVshowInfo() {
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
              realPath = request.getServletContext().getRealPath("/");
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
        
        
	    Element tvshow = new Element("tvshow");
		Element title = new Element("title");
		Element plot = new Element("plot");
		Element runtime = new Element("runtime");
		Element genre = new Element("genre");
		Element studio = new Element("studio");
		Element thumb = new Element("thumb");
       // Attribute id = new Attribute("id","tracknumber");
        Document doc = new Document(tvshow);
        title.setText(mySmartUpload.getRequest().getParameter("tvshow-name"));  
        studio.setText(mySmartUpload.getRequest().getParameter("studio-name"));
        genre.setText(mySmartUpload.getRequest().getParameter("tvshow-genre"));
        plot.setText(mySmartUpload.getRequest().getParameter("tvshow-introduction"));
        runtime.setText(mySmartUpload.getRequest().getParameter("length"));
        thumb.setText(thumbfileName);
        
        tvshow.addContent(title);
        tvshow.addContent(plot);
        tvshow.addContent(runtime);
        tvshow.addContent(genre);  
        tvshow.addContent(studio);
        tvshow.addContent(thumb);
        XMLOutputter out = new XMLOutputter() ;
        String path = request.getContextPath();
        //String rootpath = request.getSession().getServletContext().getRealPath("") ;  
        //System.out.println(rootpath);
        String filename = mySmartUpload.getRequest().getParameter("tvshow-name");
//        
        realPath = request.getServletContext().getRealPath("/");
        rootPath = realPath + "\\uploadTV\\";
		System.out.print(rootPath);
		filename = rootPath + filename + ".xml";
		
        File file = new File(filename);
        try {  
            if (file.createNewFile()) {  
        		out.output(doc,new FileOutputStream(file)) ;
                System.out.println("create file " + filename + " successful");  
            } else {  
                System.out.println("create file " + filename + " successful");  
            }  
        } catch (IOException e) {
            e.printStackTrace();  
            System.out.println("create file " + filename + " unsuccessful" + e.getMessage());  
        }  
        File nullfile = new File("null.xml");
        if (file.isFile()) {  // 为文件时调用删除文件方法  
        	nullfile.delete();
        }
//	    response.sendRedirect("TVShow.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

		
}
