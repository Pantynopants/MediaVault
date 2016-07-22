<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="coreservlets.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TVshow</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="./css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files 
<link href="css/style.css" rel='stylesheet' type='text/css' />	-->
<link href="./css/ResponsiveStyle.css" rel='stylesheet' type='text/css' />	
<script src="./js/jquery-1.11.1.min.js"></script>
<!--web-fonts-->
 <link href='http://fonts.useso.com/css?family=Jockey+One|Open+Sans:300italic,400italic,600italic,400,600,700' rel='stylesheet' type='text/css'>
 <link href='http://fonts.useso.com/css?family=Audiowide|Open+Sans:300italic,400italic,600italic,700,300,600,400' rel='stylesheet' type='text/css'>
<!--//web-fonts-->

</head>
<body>
	<!--start-header-->
 <%@ include file="header.jsp"%>
<!--albums-->
<!-- pop-up-box --> 
		<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
		<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
		 <script>
				$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
				});
				});
		</script>		

		<!--//pop-up-box -->
		<div class="content-grids">
		    <div class="container">
			<h3 class="tittle">TVshow</h3>
			
			
			<%
			        String realPath = request.getServletContext().getRealPath("/");

					System.out.println(realPath);


					//创建文件的保存目录
					String rootPath = realPath + "\\uploadTV\\";
					System.out.print(rootPath);
					
			              XMLTVShowReader reader = new XMLTVShowReader(rootPath);
			              ArrayList<String> tvshowsname = reader.getTitle();
			              ArrayList<String> tvshowsplot = reader.getPlot();
			              ArrayList<String> tvshowsthumb = reader.getThumb();
			              for(int i = 0; i<tvshowsname.size(); i++){
			            	  String name = tvshowsname.get(i);
			            	  String plot = tvshowsplot.get(i);
			            	  String cover = "";
			            	  if(tvshowsthumb.get(i) == null || tvshowsthumb.get(i).equals("")){
			            		   cover = "TV/TV2.jpg";
			            	  }else{
				            	  if(tvshowsthumb.get(i).startsWith("http")){
				            		   cover = tvshowsthumb.get(i);
				            	  }else{
				            	  	 cover = "TV/"+ tvshowsthumb.get(i);
				            	  }
			            	  }
			        %>
					      
					      <div class="col-lg-4">
						         <a href="http://www.baidu.com">
						             <div class="pic-hover-msg" style=" background: url(<%= cover %>); width:320px;height:200px;">
						             </div>
						          </a>
						          <h3><%= name %>:<%= plot %></h3>
				        	</div>
					<%}
					%>
			<!--
			<div class="col-lg-4">
		         <a href="http://www.baidu.com">
		             <div class="pic-hover-msg" style=" background: url(./images/video2.jpg); width:320px;height:200px;">
		             </div>
		          </a>
		          <h3>Friends</h3>
        	</div>
					
					<div class="content-grid">
						<a class="button" href="songMenu2.html"><img src="images/v2.jpg" title="allbum-name" /></a>
						<h3>Fighting Shadows:Zhang</h3>
						
					</div>
					-->
					<div class="clearfix"> </div>
					<!--start-pagenation-->
					<div class="pagenation">
						<ul>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">Next</a></li>
						</ul>
					</div>
					<div class="clearfix"> </div>
					<!--//End-pagenation-->
				</div>
			</div>
			<div class="clearfix"> </div>
			</div>	
	</div>
 
     <!--footer-->
 <%@ include file="footer.jsp"%>
	<!--start-smoth-scrolling-->
			<script type="text/javascript">
								jQuery(document).ready(function($) {
									$(".scroll").click(function(event){		
										event.preventDefault();
										$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
									});
								});
								</script>
							<!--start-smoth-scrolling-->
						<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>