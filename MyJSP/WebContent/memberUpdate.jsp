<%@page import="com.kb.org.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
// 	MemberVO mv = (MemberVO)request.getAttribute("row");
// 	out.println(mv.getId());
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원수정</title>
<%@ include file="head.jsp" %>
</head>
<body>
	<div class="container">
		<jsp:include page="menu.jsp" />
		<!-- 중간 -->
		<div class="row"><!-- xs( xm md lg -->
			<div class="col-xs-12">
				<form action="${path}/memberUpdateProc.do">
					<input type="hidden" name="seq" value="${param.seq}">
					<div class="form-group">
						<label for="id">ID:</label>
						<input type="text" class="form-control" id="id" name="id" value="${row.id}">
					</div>
					<div class="form-group">
						<label for="name">Name:</label>
						<input type="text" class="form-control" id="name" name="name" value="${row.name}">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label>
						<input type="password" class="form-control" id="pwd" name="pwd" value="${row.pwd}">
					</div>
					<div class="form-group">
						<label for="gender">Gender:</label>
						<input type="text" class="form-control" id="gender" name="gender" value="${row.gender}">
					</div>
					<div class="checkbox">
						<label><input type="checkbox" name="save"> Remember me</label>
					</div>
					<button type="submit" class="btn btn-default">Update</button>
				</form>
			</div>
		</div>
		<!-- 발 -->
		<div class="row">
			<div class="col text-center">
				copy right 멍구
			</div>
		</div>
	</div>
</body>
</html>





