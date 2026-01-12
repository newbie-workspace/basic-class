<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Test</title>
</head>
<body>

	<%--subpage.jsp의 내용을 그대로 복사해서 삽입하는 방식. --%>
	<%@ include file="subpage.jsp" %>
	
	<hr>
	
	<%-- subpage.jsp의 실행 결과를 삽입하는 방식 --%>
	<jsp:include page="subpage.jsp"></jsp:include>
	
</body>
</html>