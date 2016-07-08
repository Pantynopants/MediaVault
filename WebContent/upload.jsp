<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<!--write by Leo 20144695-->
<html>
<head>
<title>uplaod</title>
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
</head>
<body>

 <div class="navbar-wrapper">
      <div class="container">

  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header" style="width:100%;">
            <a class="navbar-brand" href="homepage.html">Media Vault</a>



        <div class="header collapse navbar-collapse" id="example-navbar-collapse" style="width:100%;">

          <div id="navbar">
            <ul class="nav navbar-nav">
              <li><a href="mainpage.html">Home</a></li>
              <li><a href="music.html">Music</a></li>
              <li><a href="display.html">Movie</a></li>
              <li><a href="TVshow.html">TV Show</a></li>
              <li class="active"><a href="upload.html">UpLoad</a></li>
            </ul>
            <form class="navbar-form navbar-left">
              <div class="form-group">
              <input class="form-control" name="s" id="s" type="search" results="s" class="text" placeholder="Search"/>
              </div>

            </form>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="#">login</a></li>
              <li><a href="#">signup&nbsp;&nbsp;</a></li>

            </ul>
          </div>
        </div>

          <button type="button" class="navbar-toggle" data-toggle="collapse"
             data-target="#example-navbar-collapse">
             <span class="sr-only">switch</span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
          </button>
       </div>

    </nav>
</div>
    </div>
      <div class="clearfix"></div>

    <script>
      $("span.menu").click(function(){
        $(" ul.navig").slideToggle("slow" , function(){
        });
      });
    </script>

    <div class="container marketing">
      <br>
      <br>
      <hr class="featurette-divider">

      <form action="doUpload.jsp" method="post" enctype="multipart/form-data" class="dropzone dz-clickable">
	      <div class="dz-default dz-message">
	      	<span style="font-size:3em;">Drop files here to upload</span>
	      </div>
      </form>


      <input type="file" multiple="multiple" class="dz-hidden-input" style="visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;">

    </div>



    <footer class="footer">
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

