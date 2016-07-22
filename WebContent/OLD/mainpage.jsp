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

    <title>Mainpage</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
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
          <img class="first-slide" src="./images/news2.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Most hot chinese singer !.</h1>
              <p>He is the best comedian among singers,and sing best between comedian.</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="./images/news4.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Captian America.</h1>
              <p>Civil War ? What happend between them?</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="./images/news5.jpg">
          <div class="container">
            <div class="carousel-caption">
              <!--h1>One more for good measure.</h1-->
              <p>Show you how to solve a case without going out.</p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <!-- <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">&lt;</span> -->
        &lsaquo;
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <!-- <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">&gt;</span> -->
        &rsaquo;
      </a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->
 <div class="outter">
    <div style="margin-left:100px; font-size:2em;width=100px;">Top Three of Music</div>
      <p>
       <a class="btn btn-default" href="music.html" role="button" style="float:right;margin-right:100px;">More Music &raquo;</a>
       </p>
    <hr/>


    <div class="Top Music">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
        <a href="http://www.baidu.com">
          <img class="img-circle music-pic1" src="./images/music2.jpg">
        </div><!-- /.col-lg-4 -->
       </a>

        <div class="col-lg-4">
        <a href="http://www.baidu.com">
          <img class="img-circle" src="./images/music1.jpg">
         </a>

        </div><!-- /.col-lg-4 -->

        <div class="col-lg-4">
        <a href="http://www.baidu.com">
          <img class="img-circle" src="./images/music3.jpg">
          </a>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->
      </div>

    <div style="margin-left:100px; font-size:2em;width=100px;">Top Three of Movie</div>
    <p><a class="btn btn-default" href="music.html" role="button" style="float:right;margin-right:100px;">More Movie &raquo;</a></p>
    <hr/>


<div class="Top video">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
        <a href="http://www.baidu.com">
           <img class="img-rectangle" src="./images/movie1.jpg">
         </a>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
         <a href="http://www.baidu.com">
          <img class="img-rectangle" src="./images/movie2.png">
          </a>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
        <a href="http://www.baidu.com">
          <img class="img-rectangle" src="./images/movie3.jpg">
         </a>
        </div><!-- /.col-lg-4 -->

      </div><!-- /.row -->



      <!-- /END THE FEATURETTES -->

    </div><!-- /.container -->
 <div style="margin-left:100px; font-size:2em;width=100px;">Top Three of TV Show</div>
      <p><a class="btn btn-default" href="TVShow.html" role="button" style="float:right;margin-right:100px">More TV Show &raquo;</a></p>
    <hr/>


    <div class="Top Video">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
        <a href="http://www.baidu.com">
          <img class="img-rectangle" src="./images/TV1.jpg" width="320" height="200">
        </a>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
        <a href="http://www.baidu.com">
          <img class="img-rectangle" src="./images/TV2.jpg" width="320" height="200">
          </a>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
        <a href="http://www.baidu.com">
          <img class="img-rectangle" src="./images/TV3.jpg" width="320" height="200">
        </a>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->
      </div>
      </div>
      <!-- end outter -->


 <%@ include file="footer.jsp"%>

  </body>
</html>
