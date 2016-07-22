<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="coreservlets.*" %>
<!DOCTYPE html>
<!--write by Leo 20144695-->
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="NEU" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="./css/carousel.css" rel="stylesheet">

<script src="js/jquery.min.js"></script>
<!---- start-smoth-scrolling---->
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
	<!-- script-for-menu -->
	<!--start-banner-->
	<div class="banner">
		<div class="container banner-text">
            <!-- <div class="row" > -->
                <div class="col-md-8" >
                    <h1>welcome</h1>
                    <p> Here,you will then be able to browse or search for media that you want and select to either
access it for immediate use or download it to a device to be used later, and potentially off-line</p>
                </div>
    			<div class="col-md-4 banner-top">
    				<h1>log in</h1>
    				<div class="banner-bottom">
                  <form name="input" action="mainpage.html" method="get">
            					<div class="bnr-one">
            						<div class="bnr-right">
            							<input class="form-control" name="s" id="s" type="email" results="s" class="text" placeholder="ID or email"/>
            						</div>
            						<div class="clearfix"></div>
            					</div>
            					<div class="bnr-one">
            						<div class="bnr-right">
            							<!-- <input placeholder="Date" class="date" id="datepicker1" type="text" value="" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '';}" required=> -->
            							<input class="form-control" name="s" id="s" type="password" results="s" class="text" placeholder="Password"/>
            						</div>
            						<div class="clearfix"></div>
            					</div>

                        <div  class="bnr-one">
                            <div class="bnr-btn " style="margin-left:0;">
                                <!-- <form> -->
                                    <input type="submit" style="float:left;" value="register">
                                <!-- </form> -->
                            </div>
                            <div class="bnr-btn " style="float:right;margin-left:0;">
                                <!-- <form> -->
                                    <input type="submit" style="float:right;" action="" value="log in">
                                <!-- </form> -->
                            </div>
                        </div>
                  </form>
    				</div>
    			</div>


            <!-- </div> -->
		</div>
	</div>

 <%@ include file="footer.jsp"%>
	<!--end-banner-->
	<!---start-date-piker---->
		<link rel="stylesheet" href="css/jquery-ui.css" />
		<script src="js/jquery-ui.js"></script>
			<script>
				$(function() {
				$( "#datepicker,#datepicker1" ).datepicker();
				});
			</script>
	<!---/End-date-piker---->

</body>
</html>
