<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 회원정보를 저장할 빈 생성(MemberBean의 객체 생성) -->
<jsp:useBean id="m" class="sec01.ex01.MemberBean"></jsp:useBean>
<!-- name="useBean 설정한 id값(사용할 객체의 참조변수명)" property="속성명(멤버변수명)" -->
<!-- 전송된 회원 정보를 빈의 속성에 설정(setter) -->
<jsp:setProperty property="*" name="m" />

<!-- ArrayList 객체생성 - 참조변수명 : membersList -->
<jsp:useBean id="membersList" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="membersMap" class="java.util.HashMap"></jsp:useBean>

<%
membersMap.put("id", "park");
membersMap.put("pwd", "4321");
membersMap.put("name", "박지성");
membersMap.put("email", "park2@test.com");

// 새로운 회원 정보를 저장하는 MemberBean 객체 생성 - ArrayList에 저장
MemberBean m2 = new MemberBean("Son", "1234", "손흥민", "son@test.com");
membersList.add(m);
membersList.add(m2);
membersMap.put("membersList", membersList);
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ol>
		<li>${membersMap.id}</li>
		<li>${membersMap.pwd}</li>
		<li>${membersMap.name}</li>
		<li>${membersMap.email}</li>

	</ol>

1. HashMap에 저장된 ArrayList에 .(마침표)를 이용해 접근
2. 다시 각각의 속성에 마침표를 이용해 접근

	<ol>
		<li>${membersList[0].id}</li>
		<li>${membersList[0].pwd}</li>
		<li>${membersList[0].name}</li>
		<li>${membersList[0].email}</li>
	</ol>
	<ol>
		<li>${membersList[1].id}</li>
		<li>${membersList[1].pwd}</li>
		<li>${membersList[1].name}</li>
		<li>${membersList[1].email}</li>
	</ol>

</body>
</html>