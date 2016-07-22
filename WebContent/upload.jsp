<%@page import="java.util.ArrayList,org.jdom2.Document ,org.jdom2.Element,org.jdom2.JDOMException,org.jdom2.input.*,org.jdom2.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="myapp.coreservlets.*" %>
<!DOCTYPE html>

<html>
<head>
<title>Creat New Album</title>
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
<!--start-smoth-scrolling-->
</head>
<body>
 <%@ include file="header.jsp"%>
    <div class="container marketing">
      <br>
      <br>
      <hr class="featurette-divider">

      <form action="UploadAlbum" method="post" class="dropzone dz-clickable" enctype="multipart/form-data">
      Name of Album : <input type="text" name="album-name">
      Artist:<input type="text" name="artist-name"><br>
      Cover:<input type="file" name="album-cover">
      Bio:<input type="text" name="album-introduction">
      Genre of Album :
                             <select id="idState" name="genre" selectedindex="$!{state}">
                               <option value="POP">POP </option>
                               <option value="Classical">Classical </option>
                               <option value="Rap">Rap </option>
                               <option value="Jazz">Jazz </option>
                               <option value="Blues">Blues </option>
                             </select>
        <!-- submit button -->
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

  	 <!-- upload file -->
      <div class="dz-default dz-message">
      <div class="wordposition" style="font-size:3em;">
      Drop Image here to upload</div>
      </div>

      </form>


      <input type="file" multiple="multiple" class="dz-hidden-input" style="visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;">

      <!-- <hr class="featurette-divider"> -->


    </div>
 <%@ include file="footer.jsp"%>

</body>
</html>
