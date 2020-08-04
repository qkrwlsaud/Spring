<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div>
		<h1 class="subtitle">
		
		
		<c:choose>
		    <c:when test="${message != null}">
				${message}
		    </c:when>
		    <c:otherwise>
		    	로그인 실패 
		    </c:otherwise>
   	 	</c:choose>


		</h1>
		<hr>

	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>