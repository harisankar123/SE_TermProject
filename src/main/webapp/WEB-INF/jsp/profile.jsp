<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Profile</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js">
</script>
<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}
</style>
</head>

<body>

<script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
    	
      // Logged into your app and Facebook.
      testAPI();
    } else {
      // The person is not logged into your app or we are unable to tell.
      window.location = '/';
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    }
  }
  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1994771880778927',
      cookie     : true,  // enable cookies to allow the server to access 
                          // the session
      xfbml      : true,  // parse social plugins on this page
      version    : 'v2.8' // use graph api version 2.8
    });
    // Now that we've initialized the JavaScript SDK, we call 
    // FB.getLoginStatus().  This function gets the state of the
    // person visiting this page and can return one of three states to
    // the callback you provide.  They can be:
    //
    // 1. Logged into your app ('connected')
    // 2. Logged into Facebook, but not your app ('not_authorized')
    // 3. Not logged into Facebook and can't tell if they are logged into
    //    your app or not.
    //
    // These three cases are handled in the callback function.
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  };
  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));
  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me?fields=id,name,email', function(response) {
      console.log(response);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
      $('[name="myId"]').val(response.id);
      $('[name="myName"]').val(response.name);
     // $('[name="myEmail"]').val(response.email);
    
   // FB.api('/me/friends',function(response){
    //	console.log(response);
    	
    	//console.log(response);
        //Append the data
        /* response.data.forEach(function(ele,i){
        	
        	$("#tableBody").append(
        			'<tr><th scope = "row">'+i+'</th>'+
        			'<td>'+ ele.name+'</td>'+
        			'<td>'+ ele.id+'</td>'+
        			'</tr>'
        			);
        	//var earlierVal = $('[name=myFriends]').val();
        	$('[name=myFriends]').val(earlierVal + ele.id + "/" + ele.name + "/" );
       */
       // $("#redirectForm").submit();
      //});
    });
    
  }
</script>

<nav class="navbar navbar-light bg-light">
   <fb:login-button class="fb-login-button" data-max-rows="1"
				data-size="large" data-button-type="login_with"
				data-show-faces="false" data-auto-logout-link="true"
				data-use-continue-as="false"
				scope="public_profile,email,user_friends"
				onlogin="checkLoginState();">
			</fb:login-button>
</nav>
<br> 

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'Profilepage')">Profile</button>
  <button class="tablinks" onclick="openCity(event, 'CreatePost')">CreatePost</button>
  <button class="tablinks" onclick="openCity(event, 'Friends')">Friends</button>
</div>


<div id="Profilepage" class="tabcontent">
  <div class="container">
    <div class="fb-profile">
        <img align="left" src="${user.profilephoto}" alt="Profile image example" width="200" height="200" style=margin-left:2% />
        
        <div class="fb-profile-text">
            <h1>Name:"${user.name}"</h1>
            <p>About me:${user.description}.</p>
        </div>
        
    </div>
    <div>
    	<img align="left" src="${post.postPhoto}" alt="Profile image example" width="200" height="200" style=margin-left:2% />
    </div>
</div>


</div>

<div id="CreatePost" class="tabcontent">
<a href="/recordAudio">
   <button>Create Post</button>
</a>
</div>

<div id="Friends" class="tabcontent">
  <h3>Tokyo</h3>
  <p>Tokyo is the capital of Japan.</p>
</div>

<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>
     
</body>
</html> 
		
		


<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

</body>
</html>