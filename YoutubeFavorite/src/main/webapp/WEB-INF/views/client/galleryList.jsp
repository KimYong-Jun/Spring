<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list }" var="item">
		<a href="galleryDetail?g_no=${item.g_no }">
		<div>
			<img src="/yf/res/img/thumb/${item.g_path }"><br>	
		</div>
		</a>
	</c:forEach>
</body>
</html>