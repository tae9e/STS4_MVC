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
<title>게시판 목록</title>
</head>
<body>
<script>
	function(){
		alert("로그인 후 글쓰기가 가능합니다.")
	}
</script>

<%-- ${pageContext.request.contextPath }: http://localhost:8090<hr> --%>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">	
			<td>글번호</td>	
			<td>작성자</td>	
			<td>제목</td>	
			<td>작성일</td>		
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
		<a href="${contextPath }/board/articleForm.do">
		<h4 style="text-align:center">글쓰기</h4></a>
</body>
</html>