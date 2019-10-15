<%@page import="com.kb.org.member.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<!--head -->
		<jsp:include page="menu.jsp"></jsp:include>
		<!--body -->
		<div class="row">
			<div class="col">
				<table class="table">
					<tr>
						<td>순번</td>
						<td>아이디</td>
						<td>비밀번호</td>
						<td>이름</td>
						<td>성별</td>
						<td>가입날짜</td>
					</tr>
					<%
// 						List<MemberVO> list = (List)request.getAttribute("list");
// 						for( MemberVO vo : list)
// 							out.println(vo.getName());
 					%> 
					<c:forEach items="${list}" var="i">
						<tr>
							<td>${i.seq}</td>
							<td>${i.id}</td>
							<td>${i.pwd}</td>
							<td>${i.name}</td>
							<td>${i.gender}</td>
							<td>${i.joindate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!--footer -->
		<div class="row">
			<div class="col text-center">
				copy right
			</div>
		</div>
	</div>
</body>
</html>