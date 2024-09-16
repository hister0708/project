<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.*,java.util.*, java.sql.*, ct.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>movie reservation 결제페이지</title>


<style>
body {
	font-family: sans-serif;
	flex-direction: column;
	text-align: center;
	justify-content: center;
}

.title {
	color: red;
	text-align: center;
	margin-top: 30px;
}

.navbar {
	background: linear-gradient(to right, #ff9900, #ff0000);
}

.navbar-brand img {
	display: block;
	margin-left: 0;
	align: left;
}

.main {
	position: fixed;
	bottom: 50px;
	left: 50%;
	display: flex;
	justify-content: center;
	width: 50%
}

#main-button {
	position: fixed;
	bottom: 20px;
	padding: 10px 20px;
	text-align: center;
	left: 50%;
	transform: translateX(-50%);
	font-size: 25px;
	border: none;
	background-color: #ff0000;
	color: white;
	cursor: pointer;
	border-radius: 20px;
}

table, td, th {
	border: 2px solid black;
	border-collapse: collapse;
	border-radius: 10px;
}

table {
	width: 370px;
	height: 50px;
	background-color: #f7f3de;
	margin: auto;
	border-radius: 10px;
	border-style: hidden;
	box-shadow: 0 0 0 2px #000;
}

th, td {
	text-align: center;
	padding: 5px;
	border-radius: 10px;
}
</style>
</head>

<body>
	<header>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="main.jsp"> <img src="CGV.png"
			alt="로고" style="width: 100px; height: auto;">
		</a>
	</nav>
</header>

	<div class="title red">
		<h1>결제정보</h1>
	</div>
	<h2>예매가 완료되었습니다.</h2>

	<button id="main-button">
		<div class="bottom fixed box">
			메인으로<br>돌아가기
		</div>
	</button>

	<script>
		document.getElementById("main-button").onclick = function() {
			window.location.href = "main.jsp";
		};
	</script>
	</div>
	<%
	ArrayList<CTDTO> vec = new ArrayList<CTDTO>();
	vec = (ArrayList<CTDTO>) request.getAttribute("data1");
	%>
	<%
	Iterator iterator = vec.iterator();
	while (iterator.hasNext()) {
		CTDTO dto = (CTDTO) iterator.next();
	%>
	<table>
		<tr>
			<th colspan="2">예매정보</th>
		</tr>
		<tr>
			<th colspan="2"><img src="범죄도시.jpg" alt="로고"
				style="width: 280px; height: auto;"></th>
		</tr>
		<tr>
			<td>영화명</td>
			<td><%=dto.getMovie()%></td>
		</tr>
		<tr>
			<td>극장, 상영관</td>
			<td>대전 터미널</td>
		</tr>
		<tr>
			<td>관람인원</td>
			<td>성인 1명</td>
		</tr>
		<tr>
			<td>좌석</td>
			<td><%=dto.getSeat()%></td>
			<%
			}
			%>
		
	</table>
	<br>



	<script src="script.js">
		
	</script>

</body>
</html>