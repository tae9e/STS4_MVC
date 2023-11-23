<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
</head>
<body>
${pageContext.request.contextPath }: http://localhost:8090<hr>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<td>아이디</td>	
			<td>비밀번호</td>	
			<td>이름</td>	
			<td>이메일</td>	
			<td>가입일</td>	
			<td>삭제</td>	
		</tr>
		<c:forEach var="member" items="${memberList }">
		<tr align="center" bgcolor="yellow">
			<td>${member.id }</td>	
			<td>${member.pwd }</td>	
			<td>${member.name }</td>	
			<td>${member.email }</td>	
			<td>${member.joinDate }</td>	
			<td><a href="${contextPath }/member/removemember.do?id=${member.id}">삭제</a></td>	
		</tr>
		</c:forEach>
	</table>
		<a href="${contextPath }/member/memberForm.do">
		<h4 style="text-align:center">회원가입</h4></a>
</body>
</html>