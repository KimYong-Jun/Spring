<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
</head>
<body>
	<form:form id="frm" onsubmit="return beforeSend()" enctype="multipart/form-data">
		<p>
			제목 : <input type="text" name="g_title"><br>
			이미지  : <input type="file" name="img" accept="image/*">
		</p>
		<input type="submit" value="저장">
	</form:form>
	
	<script>
		function beforeSend() {
			var frm = document.getElementById("frm");
			var pathpoint = frm.img.value.lastindexOf(".");
			var filepoint = frm.img.value.substring(pathpoint+1, frm.img.length);
			var filetype = filepoint.toLowerCase();
			if(frm.title.value == ""){
				alert("제목을 입력해주세요.");
				frm.title.focus();
				return false;
			}else if(frm.img.value == ""){
				alert("이미지를 등록해주세요.");
				return false;
			}else if(frm.img.value == ""){
				alert("이미지를 등록해주세요.");
				return false;
			}else{
				return true;
			}
			
		}
	</script>
</body>
</html>
