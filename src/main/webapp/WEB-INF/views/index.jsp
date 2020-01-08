<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	.header {
		background-color: #222;
	}
	.header .nav a {
		color: #fff;
	}
	.flex-column {
		font-size: 32px;
	}
	
	.flex-column a{
		font-size: 24px;
		color: #444;
		text-align: center;
		border-top-left-radius: 4px;
	    border-top-right-radius: 4px;
	    border-bottom-right-radius: 4px;
	    border-bottom-left-radius: 4px;
	}
	
	
	.col-2 .nav-item .active{
		font-size: 24px;
		color: #fff;
		background-color: #ed4040;
		
	}
	
	.col-2 h2{
		font-weight: 500;
		text-align: center;
	}
	
	.col-3 .media {
		margin-bottom: 3px;
	}
	
	.right div {
		color: #222;
		font-weight: 700;
		font-size: 24px;
		margin-bottom: 1rem;
	}
	
	
</style>
</head>
<body>
<div class="header">
<ul class="nav">
   <li class="nav-item" style="margin-left: 12px;">
	    <a class="navbar-brand" href="#">
	    <img src="https://v4.bootcss.com/docs/4.3/assets/brand/bootstrap-solid.svg" width="30" height="30" alt="">
	  </a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="/">首页</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">个人中心</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">登录</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">退出</a>
  </li>
</ul>
</div>

<div class="container-fluid" style="margin-top: 6px;">
  <div class="row offset-1">
	  <div class="col-2">
	  	<h2>1710F</h2>
	  	<ul class="nav flex-column">
		  <li class="nav-item ">
		    <a class="nav-link" href="#">热点</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link active" href="#">科技</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="#">旅游</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
		  </li>
		</ul>
	  	
	  </div>
	  
	  <div class="col-6">
	  	<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="http://p9.pstatp.com/large/pgc-image/914f1f579d2941fb958d1f21eaba570d" height="386px;" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="http://p1.pstatp.com/large/pgc-image/4ab237b9682f4c0286da5c5e6823dc87" height="386px;" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="http://p9.pstatp.com/large/pgc-image/914f1f579d2941fb958d1f21eaba570d" height="386px;" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
	  	
	  	<ul class="nav nav-tabs">
		  <li class="nav-item">
		    <a class="nav-link active" href="#">全部</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="#">科技</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="#">文化</a>
		  </li>
		</ul>
	  	
	  	
	  </div>
	  
	  <div class="col-3">
	    <div class="right">
		  	<div>最新文章</div>
		  	<ul class="list-unstyled">
			  <li class="media">
			    <img src="http://p1.pstatp.com/large/pgc-image/4ab237b9682f4c0286da5c5e6823dc87" style="height: 72px;width: 72px;" class="mr-3" alt="...">
			    <div class="media-body">
			      <h5 class="mt-0 mb-1">电子眼全面升级，新增5项功能！</h5>
			    </div>
			  </li>
			  <li class="media">
			    <img src="http://p1.pstatp.com/large/pgc-image/4ab237b9682f4c0286da5c5e6823dc87" style="height: 72px;width: 72px;" class="mr-3" alt="...">
			    <div class="media-body">
			      <h5 class="mt-0 mb-1">电子眼全面升级，新增5项功能！</h5>
			    </div>
			  </li>
			  <li class="media">
			    <img src="http://p1.pstatp.com/large/pgc-image/4ab237b9682f4c0286da5c5e6823dc87" style="height: 72px;width: 72px;" class="mr-3" alt="...">
			    <div class="media-body">
			      <h5 class="mt-0 mb-1">电子眼全面升级，新增5项功能！</h5>
			    </div>
			  </li>
			</ul>
	  	</div>
	    <div class="right">
		  	<div>最热文章</div>
		  	<ul class="list-unstyled">
			  <li class="media">
			    <img src="http://p1.pstatp.com/large/pgc-image/4ab237b9682f4c0286da5c5e6823dc87" style="height: 72px;width: 72px;" class="mr-3" alt="...">
			    <div class="media-body">
			      <h5 class="mt-0 mb-1">电子眼全面升级，新增5项功能！</h5>
			    </div>
			  </li>
			  <li class="media">
			    <img src="http://p1.pstatp.com/large/pgc-image/4ab237b9682f4c0286da5c5e6823dc87" style="height: 72px;width: 72px;" class="mr-3" alt="...">
			    <div class="media-body">
			      <h5 class="mt-0 mb-1">电子眼全面升级，新增5项功能！</h5>
			    </div>
			  </li>
			  <li class="media">
			    <img src="http://p1.pstatp.com/large/pgc-image/4ab237b9682f4c0286da5c5e6823dc87" style="height: 72px;width: 72px;" class="mr-3" alt="...">
			    <div class="media-body">
			      <h5 class="mt-0 mb-1">电子眼全面升级，新增5项功能！</h5>
			    </div>
			  </li>
			</ul>
	  	</div>
	  </div>
  	
  </div>
</div>
<script src="/public/js/jquery.min.1.12.4.js"></script>
<script src="/public/js/bootstrap.min.js"></script>
</body>
</html>