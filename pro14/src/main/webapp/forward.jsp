<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward.jsp</title>
</head>
<body>

<jsp:forward page="member2.jsp">
<jsp:param value="서울시 강남구" name="address"/>
</jsp:forward>


</body>
</html>