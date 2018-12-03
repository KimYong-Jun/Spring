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
	클라이언트 리스트 화면
	<c:forEach items="${list }" var="item">
		<div>
			<div>제목 : ${item.y_title }</div>
			<a target="_blank" href="https://www.youtube.com/watch?v=${item.y_url }"> 
			<img style="width: 300px; height: 100px;"
				src="http://img.youtube.com/vi/${item.y_url }/maxresdefault.jpg">	
			</a> 
		</div>
	</c:forEach>
</body>
</html>