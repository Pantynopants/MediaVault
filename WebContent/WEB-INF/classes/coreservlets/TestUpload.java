package coreservlets;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import com.jspsmart.upload.*;  
import com.jspsmart.*;

@WebServlet(name="TestUpload",urlPatterns="/TestUpload")

public class TestUpload extends HttpServlet {  
 private ServletConfig config;  
 final public void init(ServletConfig config) throws ServletException {  
  this.config = config;  
 }  
   
 protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {  
  PrintWriter out = response.getWriter();  
  out.println("<HTML>");  
  out.println("<BODY BGCOLOR='white'>");  
  out.println("<H1>jspSmartUpload : Servlet Sample</H1>");  
  out.println("<HR>");  
  // 变量定义  
  int count = 0;  
  //创建一个SmartUpload类  
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
//        count = mySmartUpload.save("/upload");  
        String realPath = request.getServletContext().getRealPath("/");
        String rootPath = realPath + "\\uploadAlbum\\";
		System.out.print(rootPath);
		count = mySmartUpload.save(rootPath);  
        //count = mySmartUpload.save(null);  
       }  
       out.println(count + " file uploaded.");  
  } catch (Exception e) {  
       out.println("Unable to upload the file.<br>");  
       out.println("Error : " + e.toString());  
  }  
  //通过 方法    mySmartUpload.getRequest().getParameter(arg0);还可以获取传过来的非file类型的其他值。  
  out.println("</BODY>");  
  out.println("</HTML>");  
 }  
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  doGet(request, response);  
 }  
} 