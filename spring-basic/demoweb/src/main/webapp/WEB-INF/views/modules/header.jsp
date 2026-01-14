<%@page import="com.demoweb.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<div id="header" style="background-color:${not empty param.bgcolor ? param.bgcolor : ''}">    	

	<div class="title">
	        <a href="/demoweb/home">DEMO WEBSITE</a>
	</div>
	
	<div class="links">
	<!-- headr2.jsp 와 비교 -->
		
	<!-- if -->
		<%--
		<c:if test="${loginuser == null}">
			<a href="/demoweb/account/login">로그인</a>
		    <a href="/demoweb/account/register">회원가입</a>
		</c:if>
		<c:if test="${loginuser != null}">
			${loginuser.getMemberId()}(${loginuser.getEmail()}) 
			pageContext,application,session, request에 저장된 loginuser 을 찾아옴.
			${sessionScope.loginuser.getMemberId()}(${sessionScope.loginuser.getEmail()}) 명시적으로 찾아올 곳 지정
	   		<a href="/demoweb/account/logout">로그아웃</a>
		</c:if>
		--%>
		
	<!-- choose -->
		<c:choose>
			<c:when test="${empty loginuser}">
				<a href="/demoweb/account/login">로그인</a>
		    	<a href="/demoweb/account/register">회원가입</a>
			</c:when>
			<c:otherwise>
				${loginuser.getMemberId()}(${sessionScope.loginuser.getEmail()}) <!-- sessionScope 명시적으로 찾아올 곳 지정 -->
		   		<a href="/demoweb/account/logout">로그아웃</a>
			</c:otherwise>
		</c:choose>
		
    </div>
</div>  

 <div id="menu">
       <div>
           <ul>
               	<li><a href="/demoweb/admin/user">사용자관리</a></li>
				<li><a href="/demoweb/mail/list">메일보내기</a></li>
				<li><a href="/demoweb/library/list">자료실</a></li>
				<li><a href="/demoweb/board/list">게시판</a></li>
           </ul>
       </div>
</div>

<div style="border:solid 1px;text-align:right;padding:5px">
	[total : <%= application.getAttribute("total") %>]
	[current : <%= application.getAttribute("current") %>]
</div>