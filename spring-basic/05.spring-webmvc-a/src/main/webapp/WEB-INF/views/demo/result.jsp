<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
</head>
<body>
	
	<h2>Result Page</h2>
	<h3>DATA1 : <%= request.getAttribute("data1") %></h3>
	<h3>DATA2 : ${ data2 }</h3>
	<hr>
	<h3>Person : ${ personUsingModelAttribute }</h3>
	<h3>Person : ${ person2 }</h3>
</body>
</html>