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
@WebServlet(name="CreateTrack",urlPatterns="/CreateTrack")

public class CreateTrack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTrack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in create track");
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    //out.println("in CreateAlbum servlet");
		String strFileName; //文件名\r
		
		//out.println(new File(".").getAbsolutePath());
		
		//设置待读文件名\r
		//String realPath = System.getProperty("user.dir");
		String realPath = request.getServletContext().getRealPath("/");
		String rootPath = realPath + "\\uploadAlbum\\";
//		strFileName = request.getParameter("albumName");
		strFileName = (String) request.getSession().getAttribute("track");
				
		strFileName = rootPath + strFileName + ".xml";
		
		System.out.println(strFileName);
		//XMLUtil.readXML(strFileName);
		//out.println(strFileName);
		ArrayList<HashMap<String, String>> albumInfo;
		albumInfo = XMLReaderTrack.readXML(strFileName);
		
		
		for(int i=0; i < albumInfo.size(); i++){
			String title = albumInfo.get(i).get("title");
			String position = albumInfo.get(i).get("position");
			String duration = albumInfo.get(i).get("duration");
			out.println("<tr>");
				out.println("<td>" + i + "</td>");
				out.println("<td>"+ title + "</td>");
				out.println("<td>");
				out.println("<audio src=" + position + " controls='controls'  ></audio>");
				out.println("</td>");
				out.println("<td>"+ duration + "</td>");
				out.println("<td>");			
				
					out.println("<form name='input' action=" + position + " method='get'>");
						out.println("<div  class='bnr-one'>");
							out.println("<div class='bnr-btn' style='float:right;'>");
								out.println("<input type='submit' value='Addto List'>");
							out.println("</div>");
							out.println("<div class='bnr-btn' style='float:right;'>");
								out.println("<input type='submit' value='Download'>");
							out.println("</div>");
						out.println("</div>");
					out.println("<form>");
				out.println("</td>");
			out.println("<tr>");
//			out.println("<img src=" + albumInfo.get(i).get("thumb") + " title='allbum-name' />");
//			
//			out.println("</a>");
//			out.println("<h3>" + albumInfo.get(i).get("name") + "</h3>");						
//			out.println("</div>");
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
