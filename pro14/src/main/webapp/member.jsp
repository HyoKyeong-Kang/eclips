<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%
//     memberForm.jsp 에서 전송된 회원 정보를 가져온다. request 객체에 input name(속성 값)=사용자 입력값
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
       
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 출력창</title>
</head>
<body>
<ul>
	<li><%=id %></li>
	<li><%=pwd %></li>
	<li><%=name %></li>
	<li><%=email %></li>
</ul>

<ol>
<li>${param.id}</li>
<li>${param.pwd}</li>
<li>${param.name}</li>
<li>${param.email}</li>
</ol>



</body>
</html>