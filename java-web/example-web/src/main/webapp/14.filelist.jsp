<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 목록</title>
</head>
<body>

	<h3>[<a href="index.html">홈으로</a>]</h3>
	<h3>[<a href="13.fileupload.jsp">파일 업로드</a>]</h3>
	<br>
	<h2>파일 목록</h2>
	<hr>
	
	<% String path = application.getRealPath("/upload-files"); %>
	<% File directory = new File(path); %>
	<% File[] files = directory.listFiles(); %>  <!-- 디렉터리에 있는 파일과 디렉터리 목록 반환 -->
	<% pageContext.setAttribute("files",files); %>
	
	<c:forEach var="file" items="${files}">
		<p><a href="download?filename=${ file.getName() }">
		${file.getName()}</a>
		</p>
	</c:forEach>
	<hr>
	
</body>
</html>