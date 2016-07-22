<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="coreservlets.*" %>
<!DOCTYPE html>
<!--write by Ada 20145041-->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- <link rel="icon" href="favicon.ico"> -->

    <title>Track</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/style.css" rel='stylesheet' type='text/css' />
    <link href="./css/carousel.css" rel="stylesheet">

    <script src="./js/jquery.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/vendor/holder.min.js"></script>
    <script LANGUAGE="JavaScript"> 

    function openwin() { 
     window.open ("./Revise.html", "newwindow", "height=500, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no") 
    } 
 
    </script> 
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  <%
  String name=request.getParameter("name");
  if(name == null){
  	name = "Animal";
  } %>
 <%@ include file="header.jsp"%>
    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->
      <!-- START THE FEATURETTES -->
  
      <hr class="featurette-divider">
      
      <div class="row featurette">

        <div class="col-md-7 col-md-push-5">
            <div class="changeinfo">
		      	<div  class="bnr-one">
		           <div class="bnr-btn " style="float:right;">
		                  <!-- <form> -->
		                 <input type="submit" value="Revise" onclick="openwin()"> 
		              <!--input type="submit"  value="Chang Infor"-->
		                 </div>
		                 <!-- </form> -->     
		           </div>
           </div>
           <%
					            //String realPath = request.getServletPath();
			            		String realPath = request.getServletContext().getRealPath("/");
		
								System.out.println(realPath);		
								//创建文件的保存目录
								String rootPath = realPath + "\\uploadAlbum\\";
								System.out.print(rootPath);
				                XMLReader reader = new XMLReader(rootPath);
				                ArrayList<String> albumsname = reader.getTitle();
				                ArrayList<String> albumsreview = reader.getReview();
				                ArrayList<String> albumsartist = reader.getArtist();
				                ArrayList<String> albumsgenre = reader.getGenre();
				                ArrayList<String> albumsthumb = reader.getThumb();
				                String review = "";
                          	  String artist = "";
                          	  String genre = "";
                          	  String thumb = "";
				                for(int i = 0;i < albumsname.size();i++){
	                            	  String foundname = albumsname.get(i);
	                            	  if(foundname.equals(name)){
	                            		  review = albumsreview.get(i);
		                            	  artist = albumsartist.get(i);
		                            	  genre = albumsgenre.get(i);
		                            	  
		                            	  if(albumsthumb.get(i) == null){
		                            		  thumb = "/images/music11.jpg";
		                            	  }else{
		                            	  	thumb = albumsthumb.get(i);
		                            	  	}
		                            	  break;
	                            	  }
				                }
				                
	                            	  
			            %>
          <h2 class="featurette-heading"><%=name %> </h2>
          <p class="lead"><%=review %></p>
          <table class="table">
            <thead>
              <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
              </tr>
            </thead>
            <tbody>
            <%
            
            session.setAttribute("track",name); 
            request.setAttribute("track",name); 
            //?albumName=<%=tempalbumName 
            %>
            <% String tempalbumName = name;%>
            <jsp:include page="CreateTrack"></jsp:include>
            
            </tbody>
          </table>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/400x400/auto" src=".<%=thumb %>" alt="Generic placeholder image">
        </div>
      </div>

      
      </div>
      <!-- /END THE FEATURETTES -->

      <!-- FOOTER -->
 <%@ include file="footer.jsp"%>

  </body>
</html>
