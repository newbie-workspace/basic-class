<%@page import="com.demoweb.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% String bgColor = request.getParameter("bgcolor"); %>
<% bgColor =( bgColor != null && bgColor.length() > 0 ? bgColor : "" ); %>
<div id="header" style="background-color:<%=bgColor%>">    	
	<div class="title">
	        <a href="/springdemoweb/home">DEMO WEBSITE</a>
	</div>
	<div class="links">
	<% MemberDto loginUser = (MemberDto)session.getAttribute("loginuser"); %>
	<% if ((loginUser) == null) { %>
			<a href="/springdemoweb/account/login">로그인</a>
	        <a href="/springdemoweb/account/register">회원가입</a>
   	<% } else {  %>
   		<%= loginUser.getMemberId() %>
   		(<%= loginUser.getEmail() %>)
   		<a href="/springdemoweb/account/logout">로그아웃</a>
   	<% } %>
    </div>
</div>  

 <div id="menu">
       <div>
           <ul>
               	<li><a href="/springdemoweb/admin/user">사용자관리</a></li>
				<li><a href="/springdemoweb/mail/list">메일보내기</a></li>
				<li><a href="/springdemoweb/library/list">자료실</a></li>
				<li><a href="/springdemoweb/board/list">게시판</a></li>
           </ul>
       </div>
</div>

<div style="border:solid 1px;text-align:right;padding:5px">
	[total : <%= application.getAttribute("total") %>]
	[current : <%= application.getAttribute("current") %>]
</div>