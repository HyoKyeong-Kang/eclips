<%@page import="custmer_ex.CustMemberDAO"%>
<%@page import="custmer_ex.CustMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 진행창</title>
</head>
<body>
<%
int custID = Integer.parseInt(request.getParameter("custNum"));
String custName = request.getParameter("custName");
String custAdd = request.getParameter("custAddr");
String custPhone = request.getParameter("custTel");
String custEmail = request.getParameter("custEmail");

CustMemberVO custMember = new CustMemberVO(custID ,custName, custAdd,custPhone, custEmail);
CustMemberDAO dao = new CustMemberDAO();
dao. updateCustMember(custMember);

%>
<h2>고객 수정완료</h2>
<p>고객정보가 성공적으로 수정되었습니다.</p>
<a href="main.jsp">홈으로 돌아가기</a>

</body>
</html>