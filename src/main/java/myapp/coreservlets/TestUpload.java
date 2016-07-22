package myapp.coreservlets;


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
  // ��������  
  int count = 0;  
  //����һ��SmartUpload��  
  SmartUpload mySmartUpload = new SmartUpload();  
  try {  
        //��ʼ��     
        mySmartUpload.initialize(config, request, response);  
        
       //�ϴ�  
       mySmartUpload.upload(); 
       //su.upload()����������ǰ�棬�����н�su.upload()���ڻ�ȡ�������治�ɹ���
       System.out.println(mySmartUpload.getRequest().getParameter("path"));
       System.out.println(mySmartUpload.getRequest().getParameter("other"));
       for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {  
        com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(i);  
        String fileName = myfile.getFileName();  
        //����  
//        count = mySmartUpload.save("/upload");  
        String realPath = request.getSession().getServletContext().getRealPath("/");
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
  //ͨ�� ����    mySmartUpload.getRequest().getParameter(arg0);�����Ի�ȡ�������ķ�file���͵�����ֵ��  
  out.println("</BODY>");  
  out.println("</HTML>");  
 }  
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  doGet(request, response);  
 }  
} 