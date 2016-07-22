package coreservlets;

import java.io.*;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import javax.servlet.http.*;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name="UploadServlet",urlPatterns="/UploadServlet")
@MultipartConfig//标识Servlet支持文件上传
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
//		request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        //存储路径
//        System.out.println("in get method");
//        String savePath = request.getServletContext().getRealPath("/WEB-INF/uploadFile");
//        System.out.println(savePath);
////        System.out.println(savePath);
//        //获取上传的文件集合
//        Collection<Part> parts = request.getParts();
//        //上传单个文件
//        if (parts.size()==1) {
//             //Servlet3.0将multipart/form-data的POST请求封装成Part，通过Part对上传的文件进行操作。
//            //Part part = parts[0];//从上传的文件集合中获取Part对象
//            Part part = request.getPart("file");//通过表单file控件(<input type="file" name="file">)的名字直接获取Part对象
//            //Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
//            //获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
//            String header = part.getHeader("content-disposition");
//            //获取文件名
//            String fileName = getFileName(header);
//            //把文件写到指定路径
//            part.write(savePath+File.separator+fileName);
//        }else {
//            //一次性上传多个文件
//            for (Part part : parts) {//循环处理上传的文件
//                //获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
//                String header = part.getHeader("content-disposition");
//                //获取文件名
//                String fileName = getFileName(header);
//                //把文件写到指定路径
//                part.write(savePath+File.separator+fileName);
//            }
//        }
//        PrintWriter out = response.getWriter();
//        out.println("upload successful");
//        out.flush();
//        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in upload servlet");
		System.out.println("in post method");
		PrintWriter out = response.getWriter();
		//定义上载文件的最大字节
		int MAX_SIZE = 102400 * 102400;
		// 创建根路径的保存变量
		String rootPath;
		//声明文件读入类
		DataInputStream in = null;
		FileOutputStream fileOut = null;
		//取得客户端的网络地址
		String remoteAddr = request.getRemoteAddr();
		//获得服务器的名字
		String serverName = request.getServerName();
		System.out.println("in upload.jsp");
		//取得互联网程序的绝对地址
		//String realPath = request.getRealPath(serverName);
		//realPath = realPath.substring(0,realPath.lastIndexOf("\\"));
		//String realPath = application.getRealPath("/");
		//String realPath = application.getRealPath(request.getRequestURI());
		/*
		String realPath = request.getContextPath();
		if(realPath == null && realPath.equals("") && realPath.equals(" ")){
			realPath = ".";
		}else{
			realPath = realPath.substring(0,realPath.lastIndexOf("\\"));
		}
		//String realPath = application.getRealPath("WebContent");

		//String realPath = ".";
		*/
		String realPath = request.getServletContext().getRealPath("/");
        rootPath = realPath + "\\uploadAlbum\\";
		System.out.print(rootPath);
		//取得客户端上传的数据类型
		String contentType = request.getContentType();
		try{
			if(contentType.indexOf("multipart/form-data") >= 0){
			//读入上传的数据
			in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			if(formDataLength > MAX_SIZE){
				out.println("<P>you can not upload file size over" + MAX_SIZE + "</p>");
				return;
			}
			//保存上传文件的数据
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			//上传的数据保存在byte数组
			while(totalBytesRead < formDataLength){
				byteRead = in.read(dataBytes,totalBytesRead,formDataLength);
				totalBytesRead += byteRead;
			}
			//根据byte数组创建字符串
			String file = new String(dataBytes);
			//out.println(file);
			//取得上传的数据的文件名
			String saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0,saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
			int lastIndex = contentType.lastIndexOf("=");
			//取得数据的分隔字符串
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			//创建保存路径的文件名
			String fileName = rootPath + saveFile;
			//out.print(fileName);
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n",pos) + 1;
			pos = file.indexOf("\n",pos) + 1;
			pos = file.indexOf("\n",pos) + 1;
			int boundaryLocation = file.indexOf(boundary,pos) - 4;
			//out.println(boundaryLocation);
			//取得文件数据的开始的位置
			int startPos = ((file.substring(0,pos)).getBytes()).length;
			//out.println(startPos);
			//取得文件数据的结束的位置
			int endPos = ((file.substring(0,boundaryLocation)).getBytes()).length;
			//out.println(endPos);
			//检查上载文件是否存在
			File checkFile = new File(fileName);
			if(checkFile.exists()){
				out.println("<p>" + saveFile + " file already exist.</p>");
			}
			//检查上载文件的目录是否存在
			File fileDir = new File(rootPath);
			if(!fileDir.exists()){
			fileDir.mkdirs();
			}
			//创建文件的写出类
			fileOut = new FileOutputStream(fileName);
			//保存文件的数据
			fileOut.write(dataBytes,startPos,(endPos - startPos));
			fileOut.close();
			out.println(saveFile + "文件成功上载.</p>");
			out.println(fileDir.getAbsolutePath());
			/*
			String filePath = "http://" + request.getServerName() 
				+ ":" + request.getServerPort() 
				+ request.getContextPath()
				+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
			
			out.println("download "+"<a href= \" " + filePath + " \" >" + saveFile + "</a>");
			*/
			}else{
				String content = request.getContentType();
				out.println("<p>上传的数据类型不是multipart/form-data</p>");
			}
		}catch(Exception ex){
			throw new ServletException(ex.getMessage());
		}
	}
	
	/**
     * 根据请求头解析出文件名
     * 请求头的格式：火狐和google浏览器下：form-data; name="file"; filename="snmp4j--api.zip"
     *                 IE浏览器下：form-data; name="file"; filename="E:\snmp4j--api.zip"
     * @param header 请求头
     * @return 文件名
     */
    public String getFileName(String header) {
        /**
         * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
         * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
         * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
         */
        String[] tempArr1 = header.split(";");
        /**
         *火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
         *IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
         */
        String[] tempArr2 = tempArr1[2].split("=");
        //获取文件名，兼容各种浏览器的写法
        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
        return fileName;
    }
    

}
