<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert URL : YoutubeFavorite</title>
</head>
<body>
	<form:form id="frm" onsubmit="return beforeSend()">
		<p>
			<label for="y_url">URL 주소 : https://www.youtube.com/watch?v= </label>
			<input type="text" id="y_url" name="y_url" />
			<input type="hidden" id="y_title" name="y_title">
		</p>
		<button type="submit" class="btn">등록</button>
	</form:form>
	
	<script>
		function beforeSend() {
			var form = document.getElementById("frm");
			var y_url = form.y_url.value;
			var target = "https://www.googleapis.com/youtube/v3/videos?id=" + y_url + "&key=AIzaSyA4nTsyNNZUN1rb7TrmGy44G17SJdhZoRI&part=snippet";
		
			var xhttp = new XMLHttpRequest();
	  		  xhttp.onreadystatechange = function() {
	      		  if (this.readyState == 4 && this.status == 200) {
	        	
	       		 	var obj = JSON.parse(this.responseText);	            
	             
	        		if(obj.items[0] != undefined) {
	        			var y_title = document.getElementById("y_title")
		      	      y_title.value = obj.items[0].snippet.title	
		     	       form.submit();
	        	}   
	       }
	    }
	    xhttp.open("GET", target, true);
	    xhttp.send(); 
	    
		return false;
	}	
	</script>
</body>
</html>