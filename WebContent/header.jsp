
<div class="navbar-wrapper">
<div class="container">

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <!-- <div class="container"> -->
  <div class="navbar-header" style="width:100%;">
      <a class="navbar-brand" href="homepage.jsp">Media Vault</a>



  <div class="header collapse navbar-collapse" id="example-navbar-collapse" style="width:100%;">

    <div id="navbar">
      <ul class="nav navbar-nav">
        <li><a href="mainpage.jsp">Home</a></li>
        <li><a href="music.jsp">Music</a></li>
        <li><a href="display.jsp">Movie</a></li>
        <li><a href="TVshow.jsp">TV Show</a></li>
        <li class="dropdown">
          <a href="upload.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Upload <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="upload.jsp">Create new Album</a></li>
            <!--<li class="active"><a href="upload3.jsp">Creat new TVShow</a></li> -->
            
            <li><a href="upload4.jsp">Upload Music</a></li>
            <li><a href="upload3.jsp">Create new TVShow</a></li>
            <li><a href="upload2.jsp">Upload Episode</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
        <input class="form-control" name="s" id="s" type="search" results="s" class="text" placeholder="Search"/>
        <!-- <input type="search" class="form-control" > -->
        </div>
        <!-- <button type="submit" class="btn btn-default">Submit</button> -->
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="mainpage.jsp">login</a></li>
        <li><a href="mainpage.jsp">signup&nbsp;&nbsp;</a></li>
        <!-- <li><a href="#">Link</a></li> -->
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

<!-- </div>
  </div> -->
  <!-- script-for-menu -->
  <!-- script-for-menu -->
    <script>
      $("span.menu").click(function(){
        $(" ul.navig").slideToggle("slow" , function(){
        });
      });
    </script>

     <script>$('#idState').val('$!{state}')</script>
  <!-- script-for-menu -->