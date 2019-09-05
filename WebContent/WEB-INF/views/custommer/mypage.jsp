<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
로그인페이지
	<h2>${customer.name} 로그인페이지</h2> <br />
	<h3>아이디	${customer.id}</h3> <br />
	<h4>비번		${customer.pass}</h4> <br />
	<h4>민번		${customer.ssn}</h4> <br />
	<h4>신용도	${customer.credit}</h4> <br />
	<form id="loginpage" action="action="<%=request.getContextPath()%>/member.do">
		<input type="text" name="" />
		<input type="text" name="" />
		<input type="submit" name="" />
	</form>
	<form id="accountpage" action="action="<%=request.getContextPath()%>/account.do">
	
	</form>
	<script>
	</script>
</body>
</html>