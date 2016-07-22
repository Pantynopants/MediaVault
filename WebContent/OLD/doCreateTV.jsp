<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="coreservlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create TV</title>
</head>
<body>
<% 
System.out.println("in CreateAlbum jsp");		
response.setContentType("text/html");
	    //PrintWriter out = response.getWriter();
		String strFileName; //文件名\r
		
		//out.println(new File(".").getAbsolutePath());
		
		//设置待读文件名\r
		String realPath = System.getProperty("user.dir");
		String rootPath = realPath + "\\upload\\";
		strFileName = rootPath + "asas.xml";
		//XMLUtil.readXML(strFileName);
		//out.println(strFileName);
		ArrayList<HashMap<String, String>> albumInfo;
		albumInfo = ReadXML.readXML(strFileName);
		
		//albumInfo.set(0, "songMenu1.html");
		//albumInfo[1] = "images/v1.jpg";
		//albumInfo[2] = "Like an Arrow:Lucy Rose";
//		for(int i=0; i < albumInfo.size(); i++){
//			out.println("<div class='content-grid'>");
//			out.println("<a class='button' href=" + albumInfo.get(i).get("link") + " >");
//			
//			out.println("<img src=" + albumInfo.get(i).get("thumb") + " title='allbum-name' />");
//			
//			out.println("</a>");
//			out.println("<h3>" + albumInfo.get(i).get("name") + "</h3>");						
//			out.println("</div>");
//		}
		
		for(int i=0; i < albumInfo.size(); i++){
			out.println("<div class='col-lg-4'>");
			out.println("<a class='button' href=" + albumInfo.get(i).get("link") + " >");
			
			out.println("<img src=" + albumInfo.get(i).get("thumb") + " title='allbum-name' />");
			
			out.println("</a>");
			out.println("<h3>" + albumInfo.get(i).get("name") + "</h3>");						
			out.println("</div>");
		}
		%>
</body>
</html>