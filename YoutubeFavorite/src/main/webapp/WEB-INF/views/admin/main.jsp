<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	메인
	<form:form action="${pageContext.request.contextPath }/logout" method="Post">
		<input type="submit" value="로그아웃">
		<a href="insertURL"><button type="button">동영상 등록</button></a>
	</form:form>
</body>
</html>