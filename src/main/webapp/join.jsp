<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>join.jsp</title>
<script language="JavaScript" src="members.js"></script>
</head>
<body>
	<h1>ȸ�������� ���Ͽ� �Ʒ� ������ �ۼ� �� ȸ������ ��ư�� �����ּ���</h1>
	<form action="joinOk.jsp" method="post" name="reg_frm">
		ID : <input type="text" name="id" size="20"><br/>
		Password : <input type="password" name="pw" size="20"><br/>
		Password-Check : <input type="password" name="pw_check" size="20"><br/>
		Name : <input type="text" name="name" size="20"><br/>
		E-Mail : <input type="text" name="e_mail" size="30"><br/>
		Address : <input type="text" name="address" size="60"><br/>
		<input type="button" value="Join" onclick="infoConfirm()">
		<input type="reset" value="Cancel" onclick="javascript:window.location='login.jsp'">
	
	
	</form>
</body>
</html>