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
		function fn_articleForm(isLogOn, articleForm, loginForm) {
			if (isLogOn != '' && isLogOn != false) {
				location.href = articleForm;
			} else {
				alert("로그인 후 글쓰기가 가능합니다.");
				location.href = loginForm + '?action=/board/articleForm.do';
			}
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
		<c:choose>
			<c:when test="${articleList == null }">
				<tr align="center" bgcolor="yellow">
					<td colspan="4">등록된 글이 없습니다.</td>
				</tr>
			</c:when>

			<c:when test="${articleList != null }">
				<c:forEach var="article" items="${articleList }"
					varStatus="articleNum">
					<tr align="center" bgcolor="lightgreen">
<!-- 					articleNum.count는 varStatus를 이용해서 글번호 작성.. data 변수와 상관없음 -->
						<td>${articleNum.count }</td>
						<td>${article.id }</td>
						<td>${article.title }</td>
						<td>${article.writeDate }</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a href="javascript:fn_articleForm('${isLogOn}', 
	'${contextPath }/board/articleForm.do', 
	'${contextPath }/member.loginForm.do')">글쓰기</a>
</body>
</html>