<%@page import="com.exampleweb.dto.LottoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	th {
		width: 70px;
		height: 70px;
	}
</style>
<meta charset="UTF-8">
<title>회차별 당첨 번호</title>
</head>
<body>
	<% LottoDto lotto = (LottoDto) request.getAttribute("lotto"); %>
	<table border="1" align="center">
		<tr>
			<th colspan="7">
			<%= lotto.getRnd() %> 회차 당첨번호 <br> (추첨일 : <%= lotto.getGameDate() %>)
			</th>
		</tr>
		<tr>
			<th><%= lotto.getNumber1() %></th>
			<th><%= lotto.getNumber2() %></th>
			<th><%= lotto.getNumber3() %></th>
			<th><%= lotto.getNumber4() %></th>
			<th><%= lotto.getNumber5() %></th>
			<th><%= lotto.getNumber6() %></th>
			<th><%= lotto.getBonus() %></th>
		</tr>
	</table>
</body>
</html>