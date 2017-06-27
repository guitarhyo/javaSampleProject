<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="../common/header.jsp" %>

<script type="text/javascript">
window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer",
	{
		title:{
			text: "월별 최대가 및 최저가",
		},
		exportEnabled: true,
		axisY: {
			includeZero:false,
			prefix: "￦",
			title: "가격 (원)",
		},     
		axisX: {
			interval:1,
			intervalType: "month",
			valueFormatString: "MMM",
			title: "January 2013 - December 2013",
		},
		data: [
		{
			type: "rangeColumn",
			bevelEnabled: true,
			dataPoints: [   // Y: [Low, High]
				{x: new Date(2013,00,01), y:[1100, 1150]},
				{x: new Date(2013,01,01), y:[1110, 1180]},
				{x: new Date(2013,02,01), y:[1070, 1110]},
				{x: new Date(2013,03,01), y:[970, 1110]},
				{x: new Date(2013,04,01), y:[990, 1050]},
				{x: new Date(2013,05,01), y:[1000, 1060]},
				{x: new Date(2013,06,01), y:[1030, 1090]},
				{x: new Date(2013,07,01), y:[1060, 1160]},
				{x: new Date(2013,08,01), y:[1060, 1160]},
				{x: new Date(2013,09,01), y:[1060, 1110]},
				{x: new Date(2013,10,01), y:[1030, 1110]},
				{x: new Date(2013,11,01), y:[1080, 1120]} 	
			]
		}
		]
	});
	chart.render();


};

$(document).ready(function(){
	$("#searchWord").keydown(function(e){   
    		if($("#searchWord").val() == ""){
    			return;
    		}
            if(e.keyCode == 13){   
            	
            	$(".navbar-form").attr("action", '/prod/search').submit();
            	
            	
            }
        
    });	
	
	$("#btn_search").click(function(e){   
		
		if($("#searchWord").val() == ""){
			return;
		}
		$(".navbar-form").attr("action", '/prod/search').submit();
	   });	
    
});	
	 
</script>
  <body>
    <div class="jumbotron">
      <div class="container">
        <h1>the best Price for you</h1>
        <p>상품의 최저가를 알려드립니다. </p>
        <form class="navbar-form navbar-right" style="alian:center;">
	        <div class="form-group">
	              <input type="text"  id="searchWord" name="searchWord"  value="${searchWord }" placeholder="search" class="form-control" style="width:500px; height:50px"> 
	              <button class="btn btn-success"  id="btn_search">search</button>
	        </div>
        </form>
      </div>
    </div>

  <div class="container">
  
     <div class="container">
      <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-9">
          <div class="jumbotron">
        <div class="row placeholders">
            <div class="col-xs-6 col-sm-6 placeholder">
              <img src="${product.image_url }" width="300" height="218" style="border: solid 1px black;"  /> 
              
            </div>
            <div class="col-xs-6 col-sm-6 placeholder">

              <h3>${product.title }</h3>
              <h2><strong >${product.price_min }원</strong></h2>
              <span class="text-muted">${product.maker }</span>
              <span class="text-primary">${product.shoppingmall }</span>
              
            </div>
           
          </div>

          </div>
          </div>
          
      <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
          <div class="list-group">
            <a href="#" class="list-group-item active">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
           
          </div>
        </div>
        
		</div>

       </div>
          
   <div id="chartContainer" style="height: 300px; width: 100%;"></div>
           
   <div class="container">
		<div class="row row-offcanvas row-offcanvas-right"> 
          <div class="row">
            <div class="col-xs-6 col-lg-4">
              <h2>${product.price_min }원</h2>
              <p>${product.title }</p>
              <p><img src="${product.image_url }" width="300" height="218" style="vertical-align:top; border: solid 1px black;"  /></p>
              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-xs-6 col-lg-4">
              <h2>${product.price_min }원</h2>
              <p>${product.title }</p>
              <p><img src="${product.image_url }" width="300" height="218" style="vertical-align:top; border: solid 1px black;"  /></p>
              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>            
            <div class="col-xs-6 col-lg-4">
              <h2>${product.price_min }원</h2>
              <p>${product.title }</p>
              <p><img src="${product.image_url }" width="300" height="218" style="vertical-align:top; border: solid 1px black;"  /></p>
              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->
	</div>
</div>

<div>
      <footer>
        <p>&copy; JAVAtheater 2016</p>
      </footer>
</div> 


    
  </body>
</html>
