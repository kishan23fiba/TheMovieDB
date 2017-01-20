<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css"
	integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js"
	integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK"
	crossorigin="anonymous"></script>
<!-- CSS Script beginning-->
<style>
#nav {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: black;
	position: fixed;
	top: 0;
	width: 100%;
	z-index: 10;
}

#nav-item {
	float: left;
}

#nav-item a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

#nav-item a:hover:not(.active){
color:white;
background-color:#111;
}
.active {
	color: white;
	background-color: #9C9C9C;
}

#popularimg {
	width: 100%;
	height: 605px;
}

#img-popular{
	height:300px;
	width:200px;
}
body{
	background-color: #0F0F0F;
	overflow-x:hidden;
	font: 15px arial, sans-serif;
}
.container{
	color:white;
}
#popular-ul{
	display:block;
	overflow-x:auto;
	overflow-y:hidden;
	white-space: nowrap;
	list-style: none;
    padding: 0;
    margin: 0;
}
#popular-li{
	display: inline-block;
	z-index: 1;
	-webkit-transition: -webkit-transform 0.5s ease;
	-moz-transition: -moz-transform 0.5s ease;
	transition: transform 0.5s ease;	
}

#popular-li:hover{
	-webkit-transform: scale(1.25);
	-moz-transform: scale(1.25);
	-o-transform: scale(1.25);
	transform: scale(1.25);
}
#custom-search-input{    
    border: solid 1px #E4E4E4;
    border-radius: 6px;
    background-color: #fff;
    
    
}

#custom-search-input input{
    border: 0;
    box-shadow: none;
    
}

#custom-search-input button{
    margin: 2px 0 0 0;
    background: none;
    box-shadow: none;
    border: 0;
    color: #666666;        
    border-left: solid 1px #ccc;
}

#custom-search-input button:hover{
    border: 0;
    box-shadow: none;
    border-left: solid 1px #ccc;
}

#custom-search-input .glyphicon-search{
    font-size: 23px;
}

#search-movies{
	width:100%;
	height:150px;	
}

.heading{
	background-color:#1A1A1A;
	width:100%;	
}
</style>
<!-- CSS Script end-->
</head>

<body>

	<!-- Navigation bar beginning-->

	<ul id="nav">
		<li id="nav-item"><a href="MainController">Home</a></li>
		<li id="nav-item" class="active"><a href="MovieController">Movies</a></li>
		<li id="nav-item"><a href="">TV Shows</a></li>
	</ul>

	<!-- Navigation bar beginning-->
	<br />
	<br />
	<!-- image slide show beginning -->
	<div class="row">
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators"></ol>
			<!-- Wrapper for slides -->
			<div class="carousel-inner"></div>
			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	<!-- image slide show ending -->
	<!-- form -->
	<br /><br /><br /><br /><br />
	<div id="search-movies">
		<form>
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div id="custom-search-input">
					<div class="input-group col-md-12">
						<input type="text" class="form-control input-lg"
							placeholder="Search for Movies" /> <span class="input-group-btn">
							<button class="btn btn-info btn-lg" type="button">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</span>
					</div>
				</div>

			</div>
			<div class="col-md-2"></div>
		</form>
	</div>
	<!-- form -->
	<div class="heading">
		<div class="container">
			<h1>Popular Movies</h1>		
		</div>
	</div>
	<ul id="popular-ul">
		<c:forEach items="${upcomingMovies}" var="u">
			<li id="popular-li"><a href="MovieDetails?id=${u.id}"><img style="width:200px;height:300px;" id="#popular-img" src="${u.image}"></a></li>
		</c:forEach>
	</ul>
	<div class="heading">
		<div class="container">
			<h1>Comedy Movies</h1>
		</div>
	</div>


	<script>
		$(document).ready(function() {
							var length = 0;
							var image = [];
							var id = [];
							<c:forEach items="${discover}" var="d">
							image[length] = '${d.image}';
							id[length] = '${d.id}';
							length++;
							</c:forEach>
							for (var i = 0; i < length; i++) {
								$(
										'<div class="item"><a href="MovieDetails?id='
												+ id[i]
												+ '"><img id="popularimg" src="'+image[i]+'"></a><div class="carousel-caption"></div>   </div>')
										.appendTo('.carousel-inner');
								$(
										'<li data-target="#carousel-example-generic" data-slide-to="'+i+'"></li>')
										.appendTo('.carousel-indicators')
							}
							$('.item').first().addClass('active');
							$('.carousel-indicators > li').first().addClass(
									'active');
							$('#carousel-example-generic').carousel();
						});
		
		
	</script>
</body>
</html>