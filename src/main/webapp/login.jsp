<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login.jsp</title>
</head>
<body>
	<form action="loginOk.jsp" method="post">
		ID : <input type="text" name="id" value=""><br/>
		Password : <input type="password" name="pw"><br/>
		<input type="submit" value="Login"><br/>
		���� �������� ������ ���� �Ʒ� ȸ������ ��ư�� ���� ȸ�������� ���ּ���.<br/>
		<input type="button" value="Join" onclick="javascript:window.location='join.jsp'">
		
	
	</form>
</body>
</html>