<%@page import="java.util.ArrayList,org.jdom2.Document ,org.jdom2.Element,org.jdom2.JDOMException,org.jdom2.input.*,org.jdom2.*"%>
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

    <title>Music</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <link href="./css/carousel.css" rel="stylesheet">

    <script src="js/jquery.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/vendor/holder.min.js"></script>

  </head>
<!-- NAVBAR
================================================== -->
  <body>
 <%@ include file="header.jsp"%>




    <!-- Carousel
    ================================================== -->
     <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="./images/music22.jpg" alt="First slide">
        </div>
        <div class="item">
          <img class="second-slide" src="./images/music21.jpg" alt="Second slide">

        </div>
        <div class="item">
          <img class="third-slide" src="./images/music23.jpg">

        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <!-- <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> -->
        <!-- <span class="sr-only"> &lt; </span> -->
        &lsaquo;
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <!-- <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> -->
        <!-- <span class="sr-only">&gt;</span> -->
        &rsaquo;
      </a>

    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->
      <!-- START THE FEATURETTES -->
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
				                for(int i = 0;i < albumsname.size();i++){
	                            	  String name = albumsname.get(i);
	                            	  String review = albumsreview.get(i);
	                            	  String artist = albumsartist.get(i);
	                            	  String genre = albumsgenre.get(i);
	                            	  String thumb;
	                            	  if(albumsthumb.get(i) == null){
	                            		  thumb = "/images/music11.jpg";
	                            	  }else{
	                            	  	thumb = albumsthumb.get(i);
	                            	  	}
	                            	  
			            %>
			            
      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading"><%=artist %> <span class="text-muted">. : &nbsp;<%=genre %></span></h2>
          
          <p class="lead">
          <%=review  %>
          </p>
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
              <% session.setAttribute("track", name); 
            request.setAttribute("track",name); 
            //?albumName=<%=tempalbumName 
            %>
            <%! String tempalbumName = "Animal";%>
            <jsp:include page="CreateTrack"></jsp:include>
            </tbody>
          </table>


        </div>
        <div class="col-md-5">
          <a href="track.jsp?name=<%=name%>"><img class="featurette-image img-responsive center-block" data-src="holder.js/400x400/auto" src=".<%=thumb %>" alt="Generic placeholder image"></a>
        </div>
      </div>

      
<%}
			                          %>

      <!-- /END THE FEATURETTES -->

<hr class="featurette-divider">
      <!-- FOOTER -->
 <%@ include file="footer.jsp"%>
  </body>
</html>
