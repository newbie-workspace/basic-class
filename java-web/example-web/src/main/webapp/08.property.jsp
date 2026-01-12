<%@page import="com.exampleweb.dto.Person"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Property Demo</title>
</head>
<body>
	<%-- 아래 두 개의 인스턴스 생성 구문은 동일한 기능 --%>
	<% Person person = new Person(); %>
	<jsp:useBean id="person2" class="com.exampleweb.dto.Person" scope="page" />
	
	<%-- 아래 두 그룹의 데이터 저장 구문은 동일한 기능 --%>
	<%-- property : 변수처럼 사용하지만 실제로는 getter/setter를 호출하는 표현 방식 --%>
	<% person.setName("Jeanette Voerman"); %>
	<% person.setEmail("j.voerman@vtm.com"); %>
	<% person.setPhone("010-6523-7894"); %>
	<jsp:setProperty name="person2" property="name" value="Therese Voerman" />
	<jsp:setProperty name="person2" property="email" value="t.voerman@vtm.com" />
	<jsp:setProperty name="person2" property="phone" value="010-5214-3369" />
	
	<%-- 아래 두 그룹의 get 기능은 동일함. --%>
	<h2>
		[<%= person.getName() %>]
		[<%= person.getPhone() %>]
		[<%= person.getEmail() %>]
	</h2>
	<h2>
		[<jsp:getProperty name="person2" property="name" />]
		[<jsp:getProperty name="person2" property="phone" />]
		[<jsp:getProperty name="person2" property="email" />]
	</h2>

</body>
</html>