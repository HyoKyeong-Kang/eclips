<%@page import="custmer_ex.CustMemberVO"%>
<%@page import="java.util.List"%>
<%@page import="custmer_ex.CustMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 관리</title>
</head>
<body>
	<h1>고객관리창</h1>
	<h2>고객 등록</h2>
	<form action="create.jsp" method="post">
		고객이름 : <input type="text" name="custName"> <br> 고객주소 : <input
			type="text" name="custAdd"> <br> 고객번호 : <input
			type="text" name="custPhone"> <br> 고객 이메일 : <input
			type="text" name="custEmail"> <br> <input type="submit"
			value="고객등록">
	</form>

	<h2>고객 목록</h2>
	<%
	CustMemberDAO custMemberDAO = new CustMemberDAO();
	List<CustMemberVO> custMembers = custMemberDAO.getCustMembers();
	%>

	<table>
		<tr>
			<th>고객번호</th>
			<th>고객명</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>수정</th>
			<th>삭제</th>

		</tr>

	<%
	for (CustMemberVO custMember : custMembers) {
	%>
	<tr>
		<td><%=custMember.getCustNum()%></td>
		<td><%=custMember.getCustName()%></td>
		<td><%=custMember.getCustAddr()%></td>
		<td><%=custMember.getCustTel()%></td>
		<td><%=custMember.getCustEmail()%></td>
		<td>
		
		<%
		session.setAttribute("custMember", custMember);
		%>
		<form action="updateForm.jsp" method="post">
		<input type="submit" value="수정">
		</form>
		</td>
		<td>
		<form action="delete.jsp" method="post">
		<input type="hidden" name="custID" value="<%=custMember.getCustNum()%>">
		<input type="submit" value="삭제">
		</form>
		</td>

	</tr>
	<%
	}
	%>
	</table>


</body>
</html>