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

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="gh-buttons.css">

    <!-- prettyify -->
    <link rel="stylesheet" href="prettify.css">
    <script src="prettify.js"></script>
    <title>Display</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->

    <link href="./css/style.css" rel='stylesheet' type='text/css' />
    <link href="./css/carousel.css" rel="stylesheet">

    <script src="./js/jquery.min.js"></script>
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>

<script LANGUAGE="JavaScript">
<!--
    function openwin() {
     window.open ("./Revise2.html", "newwindow", "height=500, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no")
    }
//-->
    </script>
  </head>
<!-- NAVBAR
================================================== -->
<body>
<%! EntityManager em = JPAUtil.getEntityManager(); %>
<%
  String tvID=request.getParameter("tvID");
  if(tvID == null){
	  tvID = "1";
  }
  String episodeID=request.getParameter("episodeID");
  if(episodeID == null){
	  episodeID = "1";
  }
  String episodePageID = episodeID;
  %>

 <%@ include file="header.jsp"%>
 <%
	response.setContentType("text/html");
	em.getTransaction().begin();

	TVshow tvshow = new TVshow();
	tvshow = em.find(TVshow.class, Long.valueOf(tvID));
	String title = "";
	String season = "1";
    String episode = "1";
    String duration = "";
    String thumb = "";
    String episodeAddr = "";
    int display = 0;
	if(tvshow.getEpisode().size() == 0){
		episodeAddr = "http://123.206.9.230/NEU/video/example.mp4";
	}else{
		display = Integer.parseInt(episodeID) - 1;//==0 in default
		//default to display the first episode
		Episode displayEpisode = tvshow.getEpisode().get(display);
		if(displayEpisode != null){
			episodeAddr = displayEpisode.geteAddress();
			title = displayEpisode.geteName();
			duration = displayEpisode.getLength();
			season = displayEpisode.getSeanson();
			thumb = displayEpisode.getThumbnailAddress();
			episode = episodeID;
		}

	}

	if(episodeAddr.startsWith("\\")){
		episodeAddr = episodeAddr.substring(episodeAddr.lastIndexOf("\\") + 1);
		episodeAddr = "video/" + episodeAddr;
	}

%>
      <div class="row display-mainbody">
          <div class="col-lg-8">
            <!-- <div class="display"> -->
                <video src=<%=episodeAddr %> controls="controls" >Your browser does not support the video tag.
               </video>
            <!-- </div> -->
          </div>

         <div class="col-lg-4">

                 <div class="list-group">
                 <li class="list-group-item">
                 Name: <%=title %><br>
                 Time: <%=duration %><br>
                 Season: <%=season %><br>
                 Episode: <%=episode %><br>
                 </li>
                <br>
                <br>
<%
	int episodeNum =  tvshow.geteNumber();
	if(display+1 < episodeNum && tvshow.getEpisode().get(display+1) != null){
		Long eID = tvshow.getEpisode().get(display+1).geteID();
		episodeID = String.valueOf(eID);
	}
%>
                   <a href="display.jsp?tvID=<%=tvID %>&episodeID=<%=episodeID %>" class="list-group-item">
                  <div><img class="img-rectangle" src="<%=thumb %>" width="70" height="70">second episode
                  </div>
                   </a>
                   <a href="./display2.html" class="list-group-item">
                   <div><img class="img-rectangle" src="./images/news2.jpg" width="70" height="70">third episode
                   </div>
                   </a>
             </div>


                        <div  class="bnr-one">
                         <form name="input" action=<%=episodeAddr %> method="get">
                            <div class="bnr-btn " style="width:33%;float:left;">
                                <!-- <form> -->
                                    <input type="submit" style="width:100%;float:left;" value="&nbsp;&nbsp;Share&nbsp;&nbsp;">
                                <!-- </form> -->
                            </div>
                            <div class="bnr-btn " style="width:33%;float:left;">
                                <!-- <form> -->
                                    <input type="submit" style="width:100%;float:left;" action="" value="&nbsp;&nbsp;Download&nbsp;&nbsp;">
                                <!-- </form> -->
                            </div>
                             </form>
                             <%
                             session.setAttribute("eID", episodePageID);
                 			request.setAttribute("eID", episodePageID);
                             %>
                             <form name="input" action="Revise.jsp" method="get">
                           <div class="bnr-btn " style="width:33%;float:left;">
                                    <!-- <form> -->
                                     <input type="submit"  style="width:80%;float:right;" value="&nbsp;&nbsp;Revise&nbsp;&nbsp;" >
                                    <!--input type="submit"  value="Chang Infor"-->
                           </div>
                            </form>
                                   <!-- </form> -->
           </div>


        </div>

      </div>
<% em.getTransaction().commit(); %>
     <footer class="footer" style="position: absolute;">
      <div class="container">
        <div class="col-md-4" style="color:white;text-align: center;">
          <p style="font-size:1.5em;">CONTACT</p><br>
          <address>
            Written by <a href="mailto:webmaster@example.com">Leo &amp; Ada</a>.<br>
            NEU,
            CHINA
          </address>
        </div>
        <div class="col-md-4" style="color:white;text-align: center;" >
          <p style="font-size:1.5em;">RESOURCES</p>
          <br>
          <ul>
                <a href="http://www.github.com" style="text-align: center;" >github</a>
                <br>
                <a href="http://www.w3school.com.cn" style=" text-align: center;" >W3School</a>
          </ul>
        </div>
        <div class="col-md-4" style="color:white;text-align: center;" >
          <p style="font-size:1.5em;">LINK</p><br>
          <ul>
                <a href="http://www.bilibili.com" style="text-align: center;" >bilibili</a>
                <br>
                <a href="http://www.acfun.tv" style="text-align: center;" >acfun</a>
          </ul>
        </div>
      </div>
    </footer>

  </body>
</html>
