<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
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

<title>${movie.title}</title>
<style type="text/css">
/* body {
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  opacity:0.5;
} */
div.panel-main {
	position: absolute;
	background: rgba(255, 255, 255, 0.7);
	border: 1;
	top: 300px;
	width: 100%;
	border: 1;
	top: 200px;
	height: relative;
	color: black;
}
body{
	background-color:black;
	overflow-x:hidden;
	color: white;
}
#castheading{
	color:white;	
	font-size:xx-large;
	text-align:center;	
}
#castheading a{
	text-align:right;
	font-size:medium;
}
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

.panel{
	background-color: #181818 ;	
}
.panel-heading{
	background-color:grey;
}

</style>
</head>
<!-- style="background-color: rgba(255, 255, 255, 0.7);" -->
<body>
	<ul id="nav">
		<li id="nav-item"><a href="MainController">Home</a></li>
		<li id="nav-item" class="active"><a href="MovieController">Movies</a></li>
		<li id="nav-item"><a href="">TV Shows</a></li>
	</ul>
	<img src="${movie.backdrop_path}" height="500" width="100%">
	<div class="panel-main">
		<div class="container">
			<div class="col-md-3">
				<a href="${movie.poster_path}"><img src="${movie.poster_path}"
					width="200" height="250"></a>
			</div>
			<div class="col-md-9">
				<h1>${movie.title}</h1>
				<p>${movie.overview}</p>
				<c:forEach items="${movie.genres}" var="g">
							|| ${g} ||
						</c:forEach>
				<br /> <br /> <img style="position: relative;"
					src="http://www.free-icons-download.net/images/yellow-star-icon-43372.png"
					width="30" height="30"><b>${movie.vote_average}/10</b> from
				${movie.vote_count} users
			</div>
		</div>
	</div>
	<br />
	<br />
	<br />
	<br />
	<div class="row" style="height:350px">
		<div id="castheading">
			<div class="container">			
				Cast <a href="">Full Cast & Crew </a>
			</div>
		</div>
		<br />
		<c:forEach begin="0" end="5" items="${movieCast}" var="mc">
			<div class="col-md-2">
				<center>
					<img src="${mc.image}" class="img-circle" height="170" width="170"><br />
					<b><a href="PersonDetails?id=${mc.person_id}">${mc.name}</a></b> as
					${mc.character}
				</center>
			</div>
		</c:forEach>
	</div>
	<div class="container">
		<div class="panel">
			<div class="panel panel-heading">
				Movie Details
			</div>
			<div class="panel panel-body">
				Revenue: ${movie.revenue} USD<br />
				Release Date: ${movie.release_date}<br />
				Runtime: ${movie.runtime} minutes <br />	
				Production Companies: 
				<c:forEach items="${movie.productionCompanies}" var="mp" varStatus="status">
					<a href="company/${mp}">${mp}</a> ,	
				</c:forEach>
			</div>
		</div>
		<div class="panel">
			<div class="panel panel-heading">
				Related Videos
			</div>
			<div class="panel panel-body">
				<c:forEach items="${videos}" var="v">
					<iframe width="200" height="170" src="${v.key}" allowfullscreen></iframe>
				</c:forEach>
			</div>
		</div>		
	</div>
	<%-- <div class="col-md-6">
		<div class="panel panel-body">
			Related Videos <br />
			<c:forEach items="${videos}" var="v">
				<iframe width="200" height="170" src="${v.key}" allowfullscreen></iframe>
			</c:forEach>
		</div>
	</div> --%>
</body>
</html>