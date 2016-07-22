package coreservlets;

import java.io.*;
import java.io.PrintWriter;
import java.util.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coreservlets.*;
/**
 * Servlet implementation class CreateAlbum
 */
@WebServlet(name="CreateAlbum",urlPatterns="/CreateAlbum")

public class CreateAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAlbum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    //out.println("in CreateAlbum servlet");
		String strFileName; //文件名\r
		
		//out.println(new File(".").getAbsolutePath());
		
		//设置待读文件名\r
		//String realPath = System.getProperty("user.dir");
		String realPath = request.getServletContext().getRealPath("/");
		String rootPath = realPath + "\\uploadAlbum\\";
		strFileName = rootPath + "asas.xml";
		System.out.println(strFileName);
		//XMLUtil.readXML(strFileName);
		//out.println(strFileName);
		ArrayList<HashMap<String, String>> albumInfo;
		albumInfo = ReadXML.readXML(strFileName);

		
		for(int i=0; i < albumInfo.size(); i++){
			out.println("<div class='col-lg-4'>");
			out.println("<a class='button' href=" + albumInfo.get(i).get("link") + " >");
			
			out.println("<img src=" + albumInfo.get(i).get("thumb") + " title='allbum-name' />");
			
			out.println("</a>");
			out.println("<h3>" + albumInfo.get(i).get("name") + "</h3>");						
			out.println("</div>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
