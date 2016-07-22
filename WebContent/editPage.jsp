<%@page import="java.util.ArrayList,org.jdom2.Document ,org.jdom2.Element,org.jdom2.JDOMException,org.jdom2.input.*,org.jdom2.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="myapp.coreservlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/display.js"></script>

<!--web-fonts-->
 <link href='http://fonts.useso.com/css?family=Jockey+One|Open+Sans:300italic,400italic,600italic,400,600,700' rel='stylesheet' type='text/css'>
 <link href='http://fonts.useso.com/css?family=Audiowide|Open+Sans:300italic,400italic,600italic,700,300,600,400' rel='stylesheet' type='text/css'>
<!--//web-fonts-->
</head>
<body>

 <div class="show-items">
	<div class="container">
			 <h3 class="tittle">Edit the information of the album</h3>
			
			 <div class="show-header">
				  <div class="show-sec">
						
						<% String albumname = request.getParameter("id"); %>
						<div class="show-item cyc">
							 <img src="AlbumCover/<%=albumname %>.jpg" class="img-responsive" alt="">
						</div>
					   <div class="show-item-info">
					    <a href="editPage.jsp?id=<%=albumname %>"><img width ="20px" height = "20px" src = "images/edit.png"></a>
						<%
						String realPath = request.getSession().getServletContext().getRealPath("/");

						System.out.println(realPath);


						//创建文件的保存目录
						String rootPath = realPath + "\\uploadAlbum\\";
						System.out.print(rootPath);
						
			              XMLReader reader = new XMLReader(rootPath);
			              ArrayList<String> albumsname = reader.getTitle();
			              ArrayList<String> artistname = reader.getArtist();
			              ArrayList<String> genrename = reader.getGenre();
			              ArrayList<String> reviews = reader.getReview();

			              for(int i = 0; i<albumsname.size(); i++){
			            	  if(albumname.equals(albumsname.get(i))){
				            	  String artist = artistname.get(i);
				            	  String genre = genrename.get(i);
				            	  String review = reviews.get(i);
				            	  String cover = "AlbumCover/"+ albumname + ".jpg";
			            	      		              
			            %>
			            <form action = "../writeInfo" method = "post">
			                 <h4><font color = "#553A99">Name:</font><input type = "text" name = "album-name" value = "<%= albumname %>" color = "gray" onclick = "disappeared(this)" ></h4><br>
			                 <h4><font color = "#553A99">Artist:</font><input type = "text" name = "artist-name" value = "<%= artist %>" onclick = "disappeared(this)"></h4><br>
			                 <h4><font color = "#553A99">Genre:</font><input type = "text" name = "genre" value = "<%= genre %>" color = "gray" onclick = "disappeared(this)" ></h4><br>
			                 <h4><font color = "#553A99">Cover:</font><input type = "file" name = "album-cover" accept ="image/gif ,image/jpeg, image/png"></h4>
			                 <h4><font color = "#553A99">Introduction:</font></h4><textarea name = "album-introduction" rows="3" onclick = "disappeared(this)"><%= review %></textarea><br>
                             <input type = "submit" value = "submit" ><input type = "reset" value = "reset">		        
			            </form> 	
			            <%    }
			              }
			            %>	
			            <h5>List:</h5>
						<table class="table">
         				   <thead>
              				 <tr>
                				<th>#</th>
                				<th>Name</th>
                				<th>Play</th>
                				<th>Download</th>
              				</tr>
            			   </thead>
            			   <tbody>
                             <tr>
                                <td>1</td>
                                <td>See you again</td>
                                <td>
                                <audio src="music/Seeyouagain.mp3" controls="controls" ></audio>
                                </td>
                                <td><a href="music/Seeyouagain.mp3"><img width =30px height = 30px src="images/downloadmusic.png"/></a></td>
                             </tr>
                             <tr>
                                <td>2</td>
                                <td>Stay</td>
                                <td>
                                <audio src="music/Stay-MileyCyrus.mp3" controls="controls" ></audio>
                                </td>
                                <td><a href="music/Stay-MileyCyrus.mp3"><img width =30px height = 30px src="images/downloadmusic.png"/></a></td>
                             </tr>
                             
                          </tbody>
                        </table>		
					   </div>			
					   <div class="clearfix"></div>
											
				  </div>
			  </div>
			  
		
		 </div>
		 </div>
</body>
</html>