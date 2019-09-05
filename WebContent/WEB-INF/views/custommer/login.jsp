<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오우</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div>
		<h2>로그인</h2>
		<form id="login_form"   action="<%=request.getContextPath()%>/member.do">
			아이디 <input type="text" name="id" /> <br /> 
			비밀번호<input type="text" name="pass" /> <br />
			<input type="hidden" name="action" value="login"/>
			<input type="submit" value="전송" />
		</form>
	</div>
	<script>
	$('#login_form').submit(function(){
		alert('전송');
	});
	</script>
</body>
</html>