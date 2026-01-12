<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
</head>
<body>
	
	<h3>[<a href="index.html">홈으로</a>]</h3>
	<a href="14.filelist.jsp">파일 목록 보기.</a>
	<hr>
	<form action="upload" method="post" enctype="multipart/form-data">
		데이터 1 : <input type="text" name="data1"><br> 
		데이터 2 : <input type="text" name="data2"><br>
		첨부파일 : <input type="file" name="attach"><br>
		<input type="submit" value="전송">
	</form>
	
</body>
</html>