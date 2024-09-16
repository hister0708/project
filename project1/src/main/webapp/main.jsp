<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>CGV</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<header>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="main.jsp"><img src="CGV.png"
				alt="로고" style="width: 100px; height: auto;"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown">상영중인 영화</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="sub.jsp">범죄도시1</a></li>
							<li><a class="dropdown-item" href="sub2.jsp">범죄도시2</a></li>
							<li><a class="dropdown-item" href="sub3.jsp">범죄도시3</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
</header>
<style>
.container-fluid {
	white-space: nowrap;
}

.container-fluid.p-0 {
	padding: 0 !important;
}
.navbar-nav .dropdown-menu {
    position: absolute;
}

.container {
	width: 100%; /* 컨테이너의 너비를 설정합니다. */
	max-width: 1400px; /* 컨테이너의 최대 너비를 제한합니다. */
	margin: 0 auto; /* 가운데 정렬을 위해 좌우 여백을 자동으로 설정합니다. */
}

#screenleft, #screencenter, #screenright {
	height: 100%; /* 각 화면 요소의 높이를 100%로 설정합니다. */
}

.image-container {
	overflow: hidden; /* 이미지가 컨테이너를 넘어가는 경우를 숨깁니다. */
}

.carousel-inner img {
	width: 100%; /* 이미지가 부모 요소에 가득 차도록 설정합니다. */
	height: auto; /* 가로 비율에 맞게 높이를 자동 조정합니다. */
}

.button-container {
	display: flex;
	flex-direction: column;
	margin-top: 0;
}

.horizontal-buttons {
	display: flex;
	flex-direction: row;
}

.navbar {
	background: linear-gradient(to right, #ff9900, #ff0000);
}

/* 좌우 여백 조정을 위한 스타일 */
#screenleft {
	padding-right: 15px;
}

#screencenter {
	padding-left: 15px;
	padding-right: 15px;
}

#screenright {
	padding-left: 15px;
}
</style>

<body>
	<div class="container-fluid mt-3">
		<div class="container">
			<div class="row align-items-stretch">
				<!-- screenleft -->
				<div id="screenleft" class="col-md-5 pr-0">
					<div class="image-container">
						<div id="demo" class="carousel slide" data-bs-ride="carousel">
							<!-- Indicators/dots -->
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#demo"
									data-bs-slide-to="0" class="active"></button>
								<button type="button" data-bs-target="#demo"
									data-bs-slide-to="1"></button>
								<button type="button" data-bs-target="#demo"
									data-bs-slide-to="2"></button>
							</div>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<a href="sub.jsp"><img src="범죄도시.jpg" alt="1"></a>
								</div>
								<div class="carousel-item">
									<a href="sub2.jsp"><img src="범죄도시2.jpg" alt="2"></a>
								</div>
								<div class="carousel-item">
									<a href="sub3.jsp"><img src="범죄도시3.jpg" alt="3"></a>
								</div>
							</div>
							<!-- Slide buttons -->
							<a class="carousel-control-prev" href="#demo"
								data-bs-slide="prev">
						<span
								class="carousel-control-prev-icon"></span></a> <a
								class="carousel-control-next" href="#demo" data-bs-slide="next"><span
								class="carousel-control-next-icon"></span></a>
						</div>
					</div>
				</div>
				<!-- screencenter -->
				<div id="screencenter" class="col-md-4 px-0">
					<div
						style="display: flex; justify-content: center; align-items: center; height: 100%;">
						<img src="영화.png" style="width: 100%; height: auto;">
					</div>
				</div>
				<!-- screenright -->
				<div id="screenright" class="col-md-3 pl-0">
					<div
						style="display: flex; justify-content: flex-end; align-items: center; height: 150px; overflow: hidden;">
						<div id="screenright" class="col-md-3 pl-0"
							style="display: flex; justify-content: flex-end; align-items: center; width: 300px;">
							<iframe id="infoFrame" src="info.jsp"
								style="width: 140%; height: 100%; border: none; overflow: hidden;"
								onload="resizeIframe(this)"></iframe>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		function resizeIframe(iframe) {
			iframe.style.height = iframe.contentWindow.document.documentElement.scrollHeight
					+ 'px';
		}
	</script>
</body>


</html>
