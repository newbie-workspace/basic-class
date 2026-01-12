<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax</title>
</head>
<body>
	
	<a href='javascript:' id="sync">동기방식 호출 (All Refresh)</a>
	&nbsp;&nbsp;
	<a href='javascript:' id="async">비동기방식 호출 (Partial Refresh)</a>
	<hr>
	<div id="container">
	
	</div>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
	
		$( () => { // 브라우저가 html을 읽고 객체 트리를 완성한 후에서야 자동으로 호출
			$("#sync").on("click", (e) => {
				e.preventDefault(); // 이 이벤트를 발생시킨 객체의 기본 기능 비활성화
				location.href = "request-data" // location.href = 주소 입력 또는 링크 클릭과 같은 효과
			});
			$("#async").on("click", (e) => {
				
				// 1. jQuery 기능 사용
				/* 
				$.ajax({
					url:"request-data",
					method: "get",
					success: function(data, status, xhr) {
						
						$('<div></div>').css({"border":"solid 1px", 
											  "padding":"10px", 
											  "margin-top":"2px"})
										.text(data)
										.appendTo($("#container"));
					},
					fail: function(xhr, status, err) {
					}
				})		 
				*/
				
				// 2. fetch 함수 사용
				fetch("request-data").then(r => r.text()).then(data => {

					$('<div></div>').css({"border":"solid 1px", 
										  "padding":"10px", 
										  "margin-top":"2px"})
									.text(data)
									.appendTo($("#container"));
					
				})		
			});
		});
		
	</script>
</body>
</html>