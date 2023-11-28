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
<h2>사이트 메뉴</h2>
<h2><a href="${contextPath }/member/listMembers.do">회원관리</a></h2>
<h2><a href="${contextPath }/board/listArticles.do">게시판 관리</a></h2>
</body>
</html>