<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		제목 : ${vo.g_title }<br>
			이미지  <br>
			<img src="/yf/res/img/${vo.g_path }"><br>
			등록일자 : ${vo.g_regdate }<br><br>
</body>
</html>