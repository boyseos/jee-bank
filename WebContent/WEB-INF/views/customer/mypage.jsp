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
	<form id="loginpage" action="<%=request.getContextPath()%>/customer.do">
		비번변경 (구비번,신비번)<input type="text" name="changepass" /> <br/>			
		회원탈퇴 (pass)<input type="text" name="deletemember" /> <br/>
		<input type="hidden" name="id" value="${customer.id}" />
		<input type="hidden" name="action" value="loginpage" />
		<input type="submit" value="멤버정보변경" />
	</form>
	<form id="accountpage" action="<%=request.getContextPath()%>/account.do">
		통장개설<input type="number" name="crateaccount" />
		입금<input type="number" name="depositMoney" />
		출금<input type="number" name="withdrawMoney" />		
		<input type="hidden" name="action" value="accountpage" />
		<input type="submit" value = "개설"/>
	</form>
	<script>
	$('#loginpage').submit(function(){
		
	});
	</script>
</body>
</html>