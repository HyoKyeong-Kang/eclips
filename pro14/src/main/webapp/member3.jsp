<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 회원정보를 저장할 빈 생성(MemberBean의 객체 생성) -->
<jsp:useBean id="m" class="sec01.ex01.MemberBean"></jsp:useBean>
<!-- name="useBean 설정한 id값(사용할 객체의 참조변수명)" property="속성명(멤버변수명)" -->
<!-- 전송된 회원 정보를 빈의 속성에 설정(setter) -->
<jsp:setProperty property="*" name="m"/>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<li>표현식 사용</li>
<li><%=m.getId() %></li>
<li><%=m.getPwd() %></li>
<li><%=m.getName() %></li>
<li><%=m.getEmail() %></li>
</ul>

<ol>
<li>빈 id와 속성이름으로 접근해 회원 정보 출력</li>
<li>${m.id}</li>
<li>${m.pwd}</li>
<li>${m.name}</li>
<li>${m.email}</li>
</ol>

</body>
</html>