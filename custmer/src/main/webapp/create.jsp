<%@page import="custmer_ex.CustMemberDAO"%>
<%@page import="custmer_ex.CustMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 등록</title>
</head>
<body>
<%
//폼으로부터 입력된 고객정보 가져오기
String custName= request.getParameter("custName");
String custAdd= request.getParameter("custAdd");
String custPhone= request.getParameter("custPhone");
String custEmail= request.getParameter("custEmail");

//고객 정보 생성
CustMemberVO custMember = new CustMemberVO();
custMember.setCustName(custName);
custMember.setCustAddr(custAdd);
custMember.setCustTel(custPhone);
custMember.setCustEmail(custEmail);

CustMemberDAO custMemberDAO =new  CustMemberDAO();
custMemberDAO.createCustMember(custMember);


%>
<h2>고객 등록완료</h2>
<p>고객이 성공적으로 등록되었습니다.</p>

</body>
</html>