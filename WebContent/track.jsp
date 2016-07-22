<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="myapp.coreservlets.*" %>
<%@ page import="myapp.model.*" %>
<%@ page import="myapp.modelDAO.*" %>
<%@ page import="myapp.service.*" %>
<%@ page import="myapp.util.*" %>
<!DOCTYPE html>

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
    <script language="JavaScript">

    function openwin() {
     window.open ("./Revise.html", "newwindow", "height=500, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no")
    }

    </script>
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  <%
  String anameoftrack = request.getParameter("anameoftrack");
  if(anameoftrack == null){
	  anameoftrack = "1";
  } %>
 <%@ include file="header.jsp"%>
    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->
      <!-- START THE FEATURETTES -->
      <%
      	session.setAttribute("anameoftrack", Long.valueOf(anameoftrack));
      	request.setAttribute("anameoftrack", Long.valueOf(anameoftrack));
      %>
  <jsp:include page="/loadalbum"></jsp:include>

      <!-- /END THE FEATURETTES -->

      <!-- FOOTER -->
 <%@ include file="footer.jsp"%>

  </body>
</html>
