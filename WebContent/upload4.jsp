<%@page import="java.util.ArrayList,org.jdom2.Document ,org.jdom2.Element,org.jdom2.JDOMException,org.jdom2.input.*,org.jdom2.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.persistence.*" %>
<%@ page import="myapp.model.*" %>
<%@ page import="myapp.modelDAO.*" %>
<%@ page import="myapp.service.*" %>
<%@ page import="myapp.util.*" %>

<!DOCTYPE html>

<html>
<head>
<title>uplaod a music</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="NEU" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/dropzone.css" rel='stylesheet' type='text/css' />

<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="./css/carousel.css" rel="stylesheet">
<link href="css/upload.css" rel='stylesheet' type='text/css' />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/dropzone.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>

<script type="text/javascript">
      jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
          event.preventDefault();
          $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
      });
    </script>
    <script>$('#idState').val('$!{state}')</script>
<!--start-smoth-scrolling-->
</head>
<body>
<%! EntityManager em = JPAUtil.getEntityManager(); %>

 <%@ include file="header.jsp"%>
    <div class="container marketing">
      <br>
      <br>
      <hr class="featurette-divider">

<%
	response.setContentType("text/html");


	AllResource allResource = em.find(AllResource.class, new Long(1));
	Long aID;
	Album albums = new Album();
	%>

      <form action="UploadTrack" class="dropzone dz-clickable" method="post" enctype="multipart/form-data">
      Name of Music : <input type="text" name="fileName">

      Album : &nbsp;
                             <select name = "album-name" id = "album-name" style="color:#3C3A3A" >
			                          <%
			                        //in music.jsp use this block
			                  		for(int i=1; i <= allResource.getAlbum().size(); i++){
			                  			albums = em.find(Album.class, new Long(i));
			                  			if (albums == null) {
			                  				continue;
			                  			}
										String name = albums.getaName();

			                          %>
			                              <option value="<%=albums.getaID() %>"><%= name %></option>
			                          <%}
			                          %>
			                     </select><br>

       duration : &nbsp;<input type="text" name="duration">
                             </p>
       <div class="creatnew2">
	     <div  class="bnr-one">
	         <div class="bnr-btn " style="float:right;">
	            <!-- <form> -->
	            <input type="submit"value="Submit">
	             <!-- </form> -->
	         </div>
	         <div class="bnr-btn " style="float:right;">
	             <!-- <form> -->
	         <input type="submit" value="Reset">
	            <!-- </form> -->
	         </div>
	    </div>
	  </div>
      		<div class="dz-default dz-message" name="trackName" >
		      <div class="wordposition" style="font-size:3em;">
		      Drop audio files here to upload</div>
	      </div>
      </form>


     <!-- <input type="file" name="trackName" multiple="multiple" class="dz-hidden-input" style="visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;">
 -->
      <!-- <hr class="featurette-divider"> -->


    </div>
<%@ include file="footer.jsp"%>

</body>
</html>
