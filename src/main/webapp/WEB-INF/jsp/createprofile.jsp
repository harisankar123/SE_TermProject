<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Create Profile</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark"> <!-- Brand/logo -->
	
<fb:login-button scope="public_profile,email" onlogin="checkLoginState();" data-size="large" data-auto-logout-link="true"></fb:login-button>
			</nav>

	<div class="container" style="margin-top: 30px"">
				<h1>Create your profile</h1>
				<br>
				<form action="/upload" method="POST" enctype="multipart/form-data">
					<label for="comment">UserName:</label>
				
					<input type="text" name="name" placeholder="Username" required>
					<div class="form-group">
						<label for="comment">Description:</label>
						<textarea class="form-control" rows="5" name="desc" required></textarea>
					</div>
					<input type="file" name="file" required/> <input type="submit"/>

				</form>
		
	
	</div>
</body>
</html>