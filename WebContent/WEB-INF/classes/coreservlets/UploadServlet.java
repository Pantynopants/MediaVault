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
@MultipartConfig//��ʶServlet֧���ļ��ϴ�
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
//        //�洢·��
//        System.out.println("in get method");
//        String savePath = request.getServletContext().getRealPath("/WEB-INF/uploadFile");
//        System.out.println(savePath);
////        System.out.println(savePath);
//        //��ȡ�ϴ����ļ�����
//        Collection<Part> parts = request.getParts();
//        //�ϴ������ļ�
//        if (parts.size()==1) {
//             //Servlet3.0��multipart/form-data��POST�����װ��Part��ͨ��Part���ϴ����ļ����в�����
//            //Part part = parts[0];//���ϴ����ļ������л�ȡPart����
//            Part part = request.getPart("file");//ͨ����file�ؼ�(<input type="file" name="file">)������ֱ�ӻ�ȡPart����
//            //Servlet3û���ṩֱ�ӻ�ȡ�ļ����ķ���,��Ҫ������ͷ�н�������
//            //��ȡ����ͷ������ͷ�ĸ�ʽ��form-data; name="file"; filename="snmp4j--api.zip"
//            String header = part.getHeader("content-disposition");
//            //��ȡ�ļ���
//            String fileName = getFileName(header);
//            //���ļ�д��ָ��·��
//            part.write(savePath+File.separator+fileName);
//        }else {
//            //һ�����ϴ�����ļ�
//            for (Part part : parts) {//ѭ�������ϴ����ļ�
//                //��ȡ����ͷ������ͷ�ĸ�ʽ��form-data; name="file"; filename="snmp4j--api.zip"
//                String header = part.getHeader("content-disposition");
//                //��ȡ�ļ���
//                String fileName = getFileName(header);
//                //���ļ�д��ָ��·��
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
		//���������ļ�������ֽ�
		int MAX_SIZE = 102400 * 102400;
		// ������·���ı������
		String rootPath;
		//�����ļ�������
		DataInputStream in = null;
		FileOutputStream fileOut = null;
		//ȡ�ÿͻ��˵������ַ
		String remoteAddr = request.getRemoteAddr();
		//��÷�����������
		String serverName = request.getServerName();
		System.out.println("in upload.jsp");
		//ȡ�û���������ľ��Ե�ַ
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
		//ȡ�ÿͻ����ϴ�����������
		String contentType = request.getContentType();
		try{
			if(contentType.indexOf("multipart/form-data") >= 0){
			//�����ϴ�������
			in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			if(formDataLength > MAX_SIZE){
				out.println("<P>you can not upload file size over" + MAX_SIZE + "</p>");
				return;
			}
			//�����ϴ��ļ�������
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			//�ϴ������ݱ�����byte����
			while(totalBytesRead < formDataLength){
				byteRead = in.read(dataBytes,totalBytesRead,formDataLength);
				totalBytesRead += byteRead;
			}
			//����byte���鴴���ַ���
			String file = new String(dataBytes);
			//out.println(file);
			//ȡ���ϴ������ݵ��ļ���
			String saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0,saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
			int lastIndex = contentType.lastIndexOf("=");
			//ȡ�����ݵķָ��ַ���
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			//��������·�����ļ���
			String fileName = rootPath + saveFile;
			//out.print(fileName);
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n",pos) + 1;
			pos = file.indexOf("\n",pos) + 1;
			pos = file.indexOf("\n",pos) + 1;
			int boundaryLocation = file.indexOf(boundary,pos) - 4;
			//out.println(boundaryLocation);
			//ȡ���ļ����ݵĿ�ʼ��λ��
			int startPos = ((file.substring(0,pos)).getBytes()).length;
			//out.println(startPos);
			//ȡ���ļ����ݵĽ�����λ��
			int endPos = ((file.substring(0,boundaryLocation)).getBytes()).length;
			//out.println(endPos);
			//��������ļ��Ƿ����
			File checkFile = new File(fileName);
			if(checkFile.exists()){
				out.println("<p>" + saveFile + " file already exist.</p>");
			}
			//��������ļ���Ŀ¼�Ƿ����
			File fileDir = new File(rootPath);
			if(!fileDir.exists()){
			fileDir.mkdirs();
			}
			//�����ļ���д����
			fileOut = new FileOutputStream(fileName);
			//�����ļ�������
			fileOut.write(dataBytes,startPos,(endPos - startPos));
			fileOut.close();
			out.println(saveFile + "�ļ��ɹ�����.</p>");
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
				out.println("<p>�ϴ����������Ͳ���multipart/form-data</p>");
			}
		}catch(Exception ex){
			throw new ServletException(ex.getMessage());
		}
	}
	
	/**
     * ��������ͷ�������ļ���
     * ����ͷ�ĸ�ʽ�������google������£�form-data; name="file"; filename="snmp4j--api.zip"
     *                 IE������£�form-data; name="file"; filename="E:\snmp4j--api.zip"
     * @param header ����ͷ
     * @return �ļ���
     */
    public String getFileName(String header) {
        /**
         * String[] tempArr1 = header.split(";");����ִ����֮���ڲ�ͬ��������£�tempArr1���������������������
         * �������google������£�tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
         * IE������£�tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
         */
        String[] tempArr1 = header.split(";");
        /**
         *�������google������£�tempArr2={filename,"snmp4j--api.zip"}
         *IE������£�tempArr2={filename,"E:\snmp4j--api.zip"}
         */
        String[] tempArr2 = tempArr1[2].split("=");
        //��ȡ�ļ��������ݸ����������д��
        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
        return fileName;
    }
    

}
