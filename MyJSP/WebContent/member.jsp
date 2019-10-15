<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
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
				<c:forEach items="${list}" var="i">
					${i}<br>
				</c:forEach>
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