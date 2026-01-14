<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset='utf-8' />
	<title>Register</title>
	<link rel='Stylesheet' href='/springdemoweb/resources/styles/default.css' />
	<link rel='Stylesheet' href='/springdemoweb/resources/styles/input.css' />
</head>
<body>

	<div id='pageContainer'>
		
		<jsp:include page="/WEB-INF/views/modules/header.jsp"></jsp:include>
		
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">회원기본정보</div>
		        <!-- <form id="registerform" action="/springdemoweb/account/register" method="post"> --><!-- 절대경로표시 -->
		        <form id="registerform" action="register" method="post"><!-- 상대경로표시 -->
		        <table>
		            <tr>
		                <th>아이디(ID)</th>
		                <td>
		                    <input type="text" id="memberId" name="memberId" style="width:180px" />
		                    <button id="btn-dup-check" style="width:90px">중복검사</button>
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호</th>
		                <td>
		                	<input type="password" id="passwd" name="passwd" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호 확인</th>
		                <td>
		                    <input type="password" id="confirm" name="confirm" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>이메일</th>
		                <td>
		                	<input type="text" id="email" name="email" style="width:280px" />
		                </td>
		            </tr>
		                       		            
		        </table>
		        <div class="buttons">
		        	<input id="register" type="button" value="등록" style="height:25px" />
		        	<input id="cancel" type="button" value="취소" style="height:25px"  />
		        </div>
		        </form>
		    </div>
		</div>   	
	</div>

	<script src="http://code.jquery.com/jquery-3.7.1.js"></script>
	<script type="text/javascript">
	$(function() {

		let isIdValid = false;
		
		$('input#register').on('click', function(event) {
			event.preventDefault(); // 현재 이벤트를 발생시킨 요소의 기본 동작 수행 차단 ( 예: <a>인 경우 href로 이동하는 동작 수행 차단 )
			// 입력 유효성 검사
			if (!isIdValid) {	
				alert('아이디 중복검사를 하세요.');
				return;
			}
			const id = $('#memberId').val();
			if (id.length == 0) {
				alert('아이디를 입력하세요');
				$('#memberId').focus();
				return;
			}
			const id_re = /^[A-Za-z0-9]{8,20}$/; // new RegExp("^[A-Za-z0-9]$") 
			if (!id_re.test(id)) { // 영문자, 숫자 조합 8 ~ 20 -> ( 입력의 내용 검사 X --> 입력의 형식 검사 O ) --> 정규표현식
				alert('아이디 형식 오류 (8 ~ 20개의 영문자 숫자 조합)');
				$('#memberId').focus();
				return;
			}
			
			const email = $('#email').val();
			if (email.length == 0) {
				alert('이메일을 입력하세요');
				$('#email').focus();
				return;
			}
			const email_re = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
			if (!email_re.test(email)) {
				alert('이메일 형식 오류');
				$('#email').focus();
				return;
			}
			
			$('#registerform').submit(); // 서버로 전송
		})
		
		// btn-dup-check 버튼 찾아서 click 이벤트 연결, 비동기 요청(url: dup-check?memberId=입력한아이디)
		// 요청 결과는 alert으로 출력
		// servlet을 만들고 (DupCheckServlet, mapping:/account/dup-check)
		
		$("#btn-dup-check").on("click", e => {
			e.preventDefault(); // 이렇게 안하면 submit을 유발시켜서 등록 버튼 누른 것 처럼 됨.
			const memberId = $("#memberId").val()
			const url = "dup-check?memberId=" 
					// `dup-check?memberId=${memberId}` =-> EL 과 충돌
					
			fetch(url + memberId).then(r => r.text()).then(data => {
 												
													if(data == "invalid") {
                                                    	alert("아이디 중복")
													} else {
                                                    	alert("사용 가능 아이디")
                                                    	isIdValid = true;
													}
												})
		})
		
		
		
		$('#memberId').on('keyup', (event) => {
			// console.log( $('#memberId').val() );
			isIdValid = false;
		});
		
	});
	</script>

</body>
</html>




























