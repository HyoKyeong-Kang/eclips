<%@page import="custmer_ex.CustMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객수정</title>
</head>
<body>
<h2> 고객 수정</h2>
<form action="update.jsp" method="post">
<!--이전 페이지에서 전달된 고객 정보 가져오기  -->
<% CustMemberVO custMember = (CustMemberVO)session.getAttribute("custMember"); %>
<input type="hidden" name="custNum" value="<%= custMember.getCustNum()%>">
<input type="text" name="custName" value="<%= custMember.getCustName()%>"><br>
<input type="text" name="custAddr" value="<%= custMember.getCustAddr()%>"><br>
<input type="text" name="custTel" value="<%= custMember.getCustTel()%>"><br>
<input type="text" name="custEmail" value="<%= custMember.getCustEmail()%>"><br>
<input type="submit" value="수정">
</form>
 
<a href="main.jsp">홈으로 돌아가기</a>
</body>
</html>