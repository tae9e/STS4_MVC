<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<table border=0 width="100%">
<tr>
	<td>
		<a href="${contextPath}/main.do"><img src="${contextPath }/image/fruit1.jpg"></a>
	</td>
	<td>
		<h2>SpringBoot 실습 홈페이지!</h2>
	</td>
	<td>
		환영합니다.
	</td>
</tr>
</table>
</body>
</html>