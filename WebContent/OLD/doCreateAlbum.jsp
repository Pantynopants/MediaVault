<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="coreservlets.*" %>
<%
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
	for(int i=0; i < albumInfo.size(); i++){
		out.println("<div class='content-grid'>");
		out.println("<a class='button' href=" + albumInfo.get(i).get("link") + " >");
		
		out.println("<img src=" + albumInfo.get(i).get("thumb") + " title='allbum-name' />");
		
		out.println("</a>");
		out.println("<h3>" + albumInfo.get(i).get("name") + "</h3>");						
		out.println("</div>");
	}
%>