<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제어문</title>
</head>
<body>

<%

	int minAvg = 20;
	int maxAvg = 26;
	
	// 2. 요청 처리 (여기서는 번호 뽑기)		
	int[] numbers = new int[6];
	int avg = 0;
	boolean valid = false;
	
	do {
		for (int i = 0; i < numbers.length; i++) {
			
			numbers[i] = (int)(Math.random() * 45) + 1; // 1 ~ 45, random
			//중복 검사
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) { // 중복인 경우
					//i--;	// 현재 위치에서 다시 뽑기
					i = -1;	// 처음부터 다시 뽑기
					break;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		avg = sum / numbers.length;
		valid = avg >= minAvg && avg <= maxAvg;
	
	} while (!valid);

%>

<table border="1" align="center">
	<tr>
	<% for (int number : numbers) { %>
		<% if (number / 10 == 0) { %>
		<th style="width:50px;height:50px;background-color:yellow">
		<% } else if (number / 10 == 1) { %>
		<th style="width:50px;height:50px;background-color:green">
		<% } else { %>
		<th style="width:50px;height:50px;background-color:orange">
		<% } %>		
			<%= number %>
		</th>
	<% } %>
	</tr>
</table>

</body>
</html>