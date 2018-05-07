<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
$(document).ready(function(){
	$('#saveButton').on("click",function(){
		$("#redirectPost"").submit();
		
	});
});
</script>
</head>
<body>

<br>
<img src="${addr}"/>
<audio autoplay>
<source src="${audioUrl}" type="audio/webm">
</audio>

<form id ="redirectPost" method ="POST" action="/profileRedirect">
<input type="file" name="file"/>
<input type="hidden" id="recording" name="recording">
<button id="saveButton">SavetoProfile</button>
</form>
</body>
</html>