<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-00scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>The Lowest price</title>

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">The Lowest Price</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>the best Price for you</h1>
        <p>상품의 최저가를 알려드립니다. 언제나 최저가가 갱신되면 당신에게 알려드립니다</p>
        <form class="navbar-form navbar-right" style="alian:center;">
	        <div class="form-group">
	              <input type="text" placeholder="search" class="form-control" style="width:500px; height:50px"> 
	<!--               <a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a> -->
	              <button type="text" class="btn btn-success">search</button>
	        </div>
        </form>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
<!--       <div class="row"> -->
<!--         <div class="col-md-4"> -->
<!--           <h2>Heading</h2> -->
<!--           <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p> -->
<!--           <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
<!--         </div> -->
<!--         <div class="col-md-4"> -->
<!--           <h2>Heading</h2> -->
<!--           <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p> -->
<!--           <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
<!--        </div> -->
<!--         <div class="col-md-4"> -->
<!--           <h2>Heading</h2> -->
<!--           <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p> -->
<!--           <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
<!--         </div> -->
      </div>
       <div class="container">
            <input type="text"  id="searchWord" placeholder="검색" value="${searchWord }">
            <a href="#" class="btn_search"><span>검색</span></a>
            <a href="#"><img src="/resources/images/ico_del.png" alt="삭제"></a>
        </div>
        <div class="container">

						<div style="margin:30px 0 0 0;padding:0;text-align:left;">
						<div >
						<img src="${product.image_url }" width="300" height="218" style="vertical-align:top"  />
						</div>
						<div >${product.title }
						
						
						</div>
						<div ><strong>${product.price_min }원</strong></div>
						</div>
					
        </div>
        
        
       
<div>${product }</div>

<div id="chartContainer" style="height: 300px; width: 100%;"></div>
      <hr>

      <footer>
        <p>&copy; JAVAtheater 2016</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
