<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Accordion - Default functionality</title>

<style>
a {
	display: block;
	margin: 0 auto; /* 수평 가운데 정렬 */
}

#loginbutton {
	width: 60px;
	height: 60px;
}

#info {
	background-color: #ccc;
	border-radius: 10px;
	padding: 20px;
	width: 250px;
	height: 70px;
}
</style>
</head>
<body>
	<%
		String IDsession = (String)session.getAttribute("userID");
		
		if(IDsession == null){
	%>
	<form method="get" action="SearchProcess">
		<div id="info">
			<table>
				<tr>
					<th>ID</th>
					<!-- 아이디 칼럼, 로그인 칼럼  로그인 칼럼에서 행 2개를 합침-->
					<td><input type="text" name="id" size="10"></td>
					<td rowspan="2" valign="bottom"><input id="loginbutton"
						type="submit" value="로그인"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" size="10"></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="hidden"
						id="action" name="action" value="login"></td>
				</tr>
			</table>
		</div>
	</form>
	<table style="margin-left: 10px;">
		<tr>
			<td><a href="join.html" style="color: ffffff;" target="_blank">회원가입</a></td>
			<td><a href="searchID.html" style="color: ffffff;" target="_blank">아이디찾기</a></td>
			<td><a href="searchPwd.html" style="color: ffffff;" target="_blank">비밀번호찾기</a></td>
		</tr>
	</table>
	<%
		}else{
			String nextPage = "login.jsp";
		
	%>
	<script type="text/javascript">
		window.location.href = "<%= nextPage %>";
	</script>
	<%
		}
	%>
</body>
</html>