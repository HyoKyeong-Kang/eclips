<%@page import="custmer_ex.CustMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 삭제</title>
</head>
<body>
<%
int custID = Integer.parseInt(request.getParameter("custID"));

CustMemberDAO custMemberDAO = new CustMemberDAO();
custMemberDAO.delteCustmer(custID);
%>
<h1>고객 삭제 완료</h1>
<p>고객 정보가 성공적으로 삭제 되었습니다.</p>
<a href="main.jsp">홈으로 돌아가기</a>
</body>
</html>