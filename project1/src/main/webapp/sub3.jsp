<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Accordion - Default functionality</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://code.jquery.com/ui/1.13.3/jquery-ui.js"></script>
<style>
.submit-button {
	position: absolute;
	top: 140px;
	right: 100px;
	width: 150px;
	height: 50px;
}

h3 {
	text-align: center;
}

form {
	text-align: center;
}

div {
	text-align: center;
}

.navbar {
	background: linear-gradient(to right, #ff9900, #ff0000);
}

div2 {
	position: absolute;
	top: 140px;
	left: 100px;
	width: 150px;
	height: 50px;
}

#info {
	background-color: #ccc;
	border-radius: 10px;
	padding-left: 20px;
	padding-right: 20px;
	padding-top: 15px;
	width: 290px;
	height: 80px;
	text-align: center;
}

</style>

</head>

<header>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="main.jsp"> <img src="CGV.png"
			alt="로고" style="width: 100px; height: auto;">
		</a>

	</nav>
</header>

<body>
	<%
	String ID = (String) session.getAttribute("userID");
	%>
	<div2>
	<p id="info">
		사용자 ID :
		<%=ID%>
		님<br> 선택하신 영화는 아래와 같습니다.
	</p>
	<img src="범죄도시3.jpg" alt="범죄도시" width="300" height="auto" /> </div2>
	<h3>좌석을 선택하시오</h3>
	<form method=get action="CT3Process">
		A열 <br> <input type="radio" name="seat" value="A1"> 1번 좌석
		<input type="radio" name="seat" value="A2"> 2번 좌석 <input
			type="radio" name="seat" value="A3"> 3번 좌석 <input
			type="radio" name="seat" value="A4"> 4번 좌석 <input
			type="radio" name="seat" value="A5"> 5번 좌석 <input
			type="radio" name="seat" value="A6"> 6번 좌석 <input
			type="radio" name="seat" value="A7"> 7번 좌석 <input
			type="radio" name="seat" value="A8"> 8번 좌석 <input
			type="radio" name="seat" value="A9"> 9번 좌석 <input
			type="radio" name="seat" value="A10"> 10번 좌석 <br>
		B열 <br>
		<input type="radio" name="seat" value="B1"> 1번 좌석 <input
			type="radio" name="seat" value="B2"> 2번 좌석 <input
			type="radio" name="seat" value="B3"> 3번 좌석 <input
			type="radio" name="seat" value="B4"> 4번 좌석 <input
			type="radio" name="seat" value="B5"> 5번 좌석 <input
			type="radio" name="seat" value="B6"> 6번 좌석 <input
			type="radio" name="seat" value="B7"> 7번 좌석 <input
			type="radio" name="seat" value="B8"> 8번 좌석 <input
			type="radio" name="seat" value="B9"> 9번 좌석 <input
			type="radio" name="seat" value="B10"> 10번 좌석 <br>
		C열 <br>
		<input type="radio" name="seat" value="C1"> 1번 좌석 <input
			type="radio" name="seat" value="C2"> 2번 좌석 <input
			type="radio" name="seat" value="C3"> 3번 좌석 <input
			type="radio" name="seat" value="C4"> 4번 좌석 <input
			type="radio" name="seat" value="C5"> 5번 좌석 <input
			type="radio" name="seat" value="C6"> 6번 좌석 <input
			type="radio" name="seat" value="C7"> 7번 좌석 <input
			type="radio" name="seat" value="C8"> 8번 좌석 <input
			type="radio" name="seat" value="C9"> 9번 좌석 <input
			type="radio" name="seat" value="C10"> 10번 좌석 <br>
		D열 <br>
		<input type="radio" name="seat" value="D1"> 1번 좌석 <input
			type="radio" name="seat" value="D2"> 2번 좌석 <input
			type="radio" name="seat" value="D3"> 3번 좌석 <input
			type="radio" name="seat" value="D4"> 4번 좌석 <input
			type="radio" name="seat" value="D5"> 5번 좌석 <input
			type="radio" name="seat" value="D6"> 6번 좌석 <input
			type="radio" name="seat" value="D7"> 7번 좌석 <input
			type="radio" name="seat" value="D8"> 8번 좌석 <input
			type="radio" name="seat" value="D9"> 9번 좌석 <input
			type="radio" name="seat" value="D10"> 10번 좌석 <br>
		E열 <br>
		<input type="radio" name="seat" value="E1"> 1번 좌석 <input
			type="radio" name="seat" value="E2"> 2번 좌석 <input
			type="radio" name="seat" value="E3"> 3번 좌석 <input
			type="radio" name="seat" value="E4"> 4번 좌석 <input
			type="radio" name="seat" value="E5"> 5번 좌석 <input
			type="radio" name="seat" value="E6"> 6번 좌석 <input
			type="radio" name="seat" value="E7"> 7번 좌석 <input
			type="radio" name="seat" value="E8"> 8번 좌석 <input
			type="radio" name="seat" value="E9"> 9번 좌석 <input
			type="radio" name="seat" value="E10"> 10번 좌석 <br>
		<input
			type="submit" value="결제하기" class="submit-button"
			onclick="setActions()"> <input type="hidden" value=""
			id="action" name="action"> <input type="hidden" value=""
			id="action_select" name="action_select">
	</form>

	<div>
		<img src="SP.gif" alt="좌석 배치">
	</div>
	<script>
		function setActions() {
			document.getElementById("action").value = "update";
			document.getElementById("action_select").value = "select";
		}
	</script>

</body>
</html>