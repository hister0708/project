<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.*, java.util.*, java.sql.*, com.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a {
	display: block;
	margin: 0 auto;
}

#info {
	background-color: #ccc;
	border-radius: 10px;
	padding: 10px;
	width: 250px;
	height: 70px;
}
</style>
</head>
<body>
	<%
	session = request.getSession();
	String userID = (String) session.getAttribute("userID");
	%>
	<div id = "info">
	<div>
		<p style = "padding-left: 30px;">
			환영합니다,
			<%=userID%>님
		</p>
	</div>
	<form method="get" name="exit" action="SearchProcess">
		<input type="submit" name="logout" value="로그아웃" style = "margin-left: 140px;" /> <input
			type="hidden" id="action" name="action" value="logout">
	</form>
	<table>
		<tr style = "padding-left: 30px;">
			<td><a href="updateAccount.html" style="color: ffffff;" target="_blank">회원정보수정</a></td>
			<td><a href="derectingAccount.html" style="color: ffffff;" target="_blank">회원탈퇴</a></td>
		</tr>
	</table>
</div>

</body>
</html>