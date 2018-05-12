<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Page</title>

</head>
<body>
<h2> Post Saved Successfully </h2>
<br>
<img src="${post.postPhoto}" alt="Profile image example" width="200" height="200" style=margin-left:2% />
<audio autoplay>
<source src="${post.postAudio}" type="audio/webm">
</audio>
<a href="/viewProfile">
   View Profile
</a>



</body>
</html>