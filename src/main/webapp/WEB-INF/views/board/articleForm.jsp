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
<title>글쓰기 창</title>
</head>
<body>
<h3>글쓰기</h3>
	<script type="text/javascript">
	function backToList(obj){
		obj.action = "${contextPath}/board/listArticles.do ";
		obj.submit();
		
	}
	</script>


	<%-- ${pageContext.request.contextPath }: http://localhost:8090<hr> --%>
	<form name="articleForm" method="post"
		action="${contextPath}/board/addNewArticle.do" enctype="multipart/form-data">
		<table border="1" align="center" width="80%">
			<tr align="center">
				<td>작성자</td>
				<td><input type="text" value="${member.name }"></td>
			</tr>
			<tr align="center">
				<td>글 제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr align="center">
				<td>글 내용</td>
				<td><textarea row="10" cols="65"></textarea></td>
			</tr>
			<tr>
				<td>이미지 첨부파일1</td><td></td>
				<td>이미지 첨부파일2</td><td></td>
			</tr>
			<tr>
				<td colspan="4"><div></div></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2">
				<input type="submit" value="글쓰기버튼">
				<input type="button" value="목록보기" onClick="backToList(this.form)">
				</td>
			</tr>

		</table>
	</form>

</body>
</html>