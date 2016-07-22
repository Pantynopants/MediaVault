package myapp.coreservlets;
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



import javax.servlet.http.*;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name="UploadServlet",urlPatterns="/UploadServlet")
@MultipartConfig//锟斤拷识Servlet支锟斤拷锟侥硷拷锟较达拷
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
//        //锟芥储路锟斤拷
//        System.out.println("in get method");
//        String savePath = request.getServletContext().getRealPath("/WEB-INF/uploadFile");
//        System.out.println(savePath);
////        System.out.println(savePath);
//        //锟斤拷取锟较达拷锟斤拷锟侥硷拷锟斤拷锟斤拷
//        Collection<Part> parts = request.getParts();
//        //锟较达拷锟斤拷锟斤拷锟侥硷拷
//        if (parts.size()==1) {
//             //Servlet3.0锟斤拷multipart/form-data锟斤拷POST锟斤拷锟斤拷锟阶帮拷锟絇art锟斤拷通锟斤拷Part锟斤拷锟较达拷锟斤拷锟侥硷拷锟斤拷锟叫诧拷锟斤拷锟斤拷
//            //Part part = parts[0];//锟斤拷锟较达拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟叫伙拷取Part锟斤拷锟斤拷
//            Part part = request.getPart("file");//通锟斤拷锟斤拷file锟截硷拷(<input type="file" name="file">)锟斤拷锟斤拷锟斤拷直锟接伙拷取Part锟斤拷锟斤拷
//            //Servlet3没锟斤拷锟结供直锟接伙拷取锟侥硷拷锟斤拷锟侥凤拷锟斤拷,锟斤拷要锟斤拷锟斤拷锟斤拷头锟叫斤拷锟斤拷锟斤拷锟斤拷
//            //锟斤拷取锟斤拷锟斤拷头锟斤拷锟斤拷锟斤拷头锟侥革拷式锟斤拷form-data; name="file"; filename="snmp4j--api.zip"
//            String header = part.getHeader("content-disposition");
//            //锟斤拷取锟侥硷拷锟斤拷
//            String fileName = getFileName(header);
//            //锟斤拷锟侥硷拷写锟斤拷指锟斤拷路锟斤拷
//            part.write(savePath+File.separator+fileName);
//        }else {
//            //一锟斤拷锟斤拷锟较达拷锟斤拷锟斤拷募锟�
//            for (Part part : parts) {//循锟斤拷锟斤拷锟斤拷锟较达拷锟斤拷锟侥硷拷
//                //锟斤拷取锟斤拷锟斤拷头锟斤拷锟斤拷锟斤拷头锟侥革拷式锟斤拷form-data; name="file"; filename="snmp4j--api.zip"
//                String header = part.getHeader("content-disposition");
//                //锟斤拷取锟侥硷拷锟斤拷
//                String fileName = getFileName(header);
//                //锟斤拷锟侥硷拷写锟斤拷指锟斤拷路锟斤拷
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
		//锟斤拷锟斤拷锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟斤拷纸锟�
		int MAX_SIZE = 102400 * 102400;
		// 锟斤拷锟斤拷锟斤拷路锟斤拷锟侥憋拷锟斤拷锟斤拷锟�
		String rootPath;
		//锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟斤拷
		DataInputStream in = null;
		FileOutputStream fileOut = null;
		//取锟矫客伙拷锟剿碉拷锟斤拷锟斤拷锟街�
		String remoteAddr = request.getRemoteAddr();
		//锟斤拷梅锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
		String serverName = request.getServerName();
		System.out.println("in upload.jsp");
		//取锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷木锟斤拷缘锟街�
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
		String realPath = request.getSession().getServletContext().getRealPath("/");
        rootPath = realPath + "\\uploadAlbum\\";
		System.out.print(rootPath);
		//取锟矫客伙拷锟斤拷锟较达拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		String contentType = request.getContentType();
		try{
			if(contentType.indexOf("multipart/form-data") >= 0){
			//锟斤拷锟斤拷锟较达拷锟斤拷锟斤拷锟斤拷
			in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			if(formDataLength > MAX_SIZE){
				out.println("<P>you can not upload file size over" + MAX_SIZE + "</p>");
				return;
			}
			//锟斤拷锟斤拷锟较达拷锟侥硷拷锟斤拷锟斤拷锟斤拷
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			//锟较达拷锟斤拷锟斤拷锟捷憋拷锟斤拷锟斤拷byte锟斤拷锟斤拷
			while(totalBytesRead < formDataLength){
				byteRead = in.read(dataBytes,totalBytesRead,formDataLength);
				totalBytesRead += byteRead;
			}
			//锟斤拷锟斤拷byte锟斤拷锟介创锟斤拷锟街凤拷锟斤拷
			String file = new String(dataBytes);
			//out.println(file);
			//取锟斤拷锟较达拷锟斤拷锟斤拷锟捷碉拷锟侥硷拷锟斤拷
			String saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0,saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
			int lastIndex = contentType.lastIndexOf("=");
			//取锟斤拷锟斤拷锟捷的分革拷锟街凤拷锟斤拷
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			//锟斤拷锟斤拷锟斤拷锟斤拷路锟斤拷锟斤拷锟侥硷拷锟斤拷
			String fileName = rootPath + saveFile;
			//out.print(fileName);
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n",pos) + 1;
			pos = file.indexOf("\n",pos) + 1;
			pos = file.indexOf("\n",pos) + 1;
			int boundaryLocation = file.indexOf(boundary,pos) - 4;
			//out.println(boundaryLocation);
			//取锟斤拷锟侥硷拷锟斤拷锟捷的匡拷始锟斤拷位锟斤拷
			int startPos = ((file.substring(0,pos)).getBytes()).length;
			//out.println(startPos);
			//取锟斤拷锟侥硷拷锟斤拷锟捷的斤拷锟斤拷锟斤拷位锟斤拷
			int endPos = ((file.substring(0,boundaryLocation)).getBytes()).length;
			//out.println(endPos);
			//锟斤拷锟斤拷锟斤拷锟斤拷募锟斤拷欠锟斤拷锟斤拷
			File checkFile = new File(fileName);
			if(checkFile.exists()){
				out.println("<p>" + saveFile + " file already exist.</p>");
			}
			//锟斤拷锟斤拷锟斤拷锟斤拷募锟斤拷锟侥柯硷拷欠锟斤拷锟斤拷
			File fileDir = new File(rootPath);
			if(!fileDir.exists()){
			fileDir.mkdirs();
			}
			//锟斤拷锟斤拷锟侥硷拷锟斤拷写锟斤拷锟斤拷
			fileOut = new FileOutputStream(fileName);
			//锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟斤拷
			fileOut.write(dataBytes,startPos,(endPos - startPos));
			fileOut.close();
			out.println(saveFile + "锟侥硷拷锟缴癸拷锟斤拷锟斤拷.</p>");
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
				out.println("<p>锟较达拷锟斤拷锟斤拷锟斤拷锟斤拷锟酵诧拷锟斤拷multipart/form-data</p>");
			}
		}catch(Exception ex){
			throw new ServletException(ex.getMessage());
		}
	}
	
	/**
     * 锟斤拷锟斤拷锟斤拷锟斤拷头锟斤拷锟斤拷锟斤拷锟侥硷拷锟斤拷
     * 锟斤拷锟斤拷头锟侥革拷式锟斤拷锟斤拷锟斤拷锟絞oogle锟斤拷锟斤拷锟斤拷拢锟絝orm-data; name="file"; filename="snmp4j--api.zip"
     *                 IE锟斤拷锟斤拷锟斤拷拢锟絝orm-data; name="file"; filename="E:\snmp4j--api.zip"
     * @param header 锟斤拷锟斤拷头
     * @return 锟侥硷拷锟斤拷
     */
    public String getFileName(String header) {
        /**
         * String[] tempArr1 = header.split(";");锟斤拷锟斤拷执锟斤拷锟斤拷之锟斤拷锟节诧拷同锟斤拷锟斤拷锟斤拷锟斤拷拢锟絫empArr1锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
         * 锟斤拷锟斤拷锟斤拷锟絞oogle锟斤拷锟斤拷锟斤拷拢锟絫empArr1={form-data,name="file",filename="snmp4j--api.zip"}
         * IE锟斤拷锟斤拷锟斤拷拢锟絫empArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
         */
        String[] tempArr1 = header.split(";");
        /**
         *锟斤拷锟斤拷锟斤拷锟絞oogle锟斤拷锟斤拷锟斤拷拢锟絫empArr2={filename,"snmp4j--api.zip"}
         *IE锟斤拷锟斤拷锟斤拷拢锟絫empArr2={filename,"E:\snmp4j--api.zip"}
         */
        String[] tempArr2 = tempArr1[2].split("=");
        //锟斤拷取锟侥硷拷锟斤拷锟斤拷锟斤拷锟捷革拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫达拷锟�
        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
        return fileName;
    }
    

}
