<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>viewItem</title>
  <script src="https://cdn.ckeditor.com/4.6.2/standard/ckeditor.js"></script>
  
	<meta name="google-signin-client_id" content="30081514308-nsdkis6qpuda4f9vr2mb2d3aeg0otqgq.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>


   <!-- Compiled and minified CSS -->
   <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">
   <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
	<!-- Compiled and minified JavaScript -->
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>
  	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
 
</head>
<body>

   <div id="snackbar">${invalid}${norecord}</div>
  <nav class="white" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="#" class="brand-logo"><span style="font-family: "Comic Sans MS";">DISCUSSION FORUM</span></a>
  
      <ul class="right hide-on-med-and-down">
     <li><a href="/logout">Logout</a></li>
        <li><a href="a">About</a></li>
        <li><a href="a">Contact Us</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="#modal1">Logout</a></li>
        <li><a href="a">About</a></li>
        <li><a href="a">Contact Us</a></li>
      </ul>
      <a href="a" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
<div id="main">

		<div id="ques" class="z-depth-1" align="center">
			<h4>${itemName }</h4>
			
			
			
			<%
		        int i = 1;
			%>
			<table class=" bordered highlight ">


				<c:forEach var="itemslist" items="${items}">
			
			 <c:set var = "itemid" scope = "session" value = "${itemid}"/>
			 <c:set var = "itemsid" scope = "session" value = "${itemslist.ItemId}"/>
			
				  
			<c:if test="${itemid==itemsid}" >
			
		         <div align="left">
		         <img src="${itemslist.ItemImageUrl}" >
		         </div>
			    <div align="right">
			     <c:out
									value=" item description -->>${itemslist.ItemDescription }" escapeXml="false"/>
			     
			     <c:out
									value=" item price -->>${itemslist.ItemPrice }" escapeXml="false"/>
									
				<c:out
									value=" item brand name -->>${itemslist.ItemBrandName }" escapeXml="false"/>					
			  
			  
			    <c:out
									value=" item rating -->>${itemslist.ItemRating }" escapeXml="false"/>  
			    </div>
   
				
					</c:if>
					<%
						i = i + 1;
					%>
				
                      
				</c:forEach>
			</table>
		</div>
	
	
	<div id="ques" class="z-depth-1" align="center">
	 <form name=frm action="addans" method="post">
         
        
           <div class="input-field col s6">
			<font size="10">YOUR ANSWER</font>	<textarea id="constraints" name="userans" required> </textarea>
				</div>
				<input type=text name="id" value="${qid}">
         <div align="center">
							<button type="submit" class="waves-effect waves-light btn blue"
								style="margin-bottom: 0;">Submit</button>
						</div>
     
          </form>
</div>
</div>
	<!--  Scripts-->
	<script>
          CKEDITOR.replace( 'constraints', {
        	// Define the toolbar groups as it is a more accessible solution.
  			toolbarGroups: [
  				{"name":"basicstyles","groups":["basicstyles"]},
  				{"name":"links","groups":["links"]},
  				{"name":"paragraph","groups":["list","blocks"]},
  				{"name":"document","groups":["mode"]},
  				{"name":"insert","groups":["insert"]},
  				{"name":"styles","groups":["styles"]},
  				{"name":"about","groups":["about"]}
  			],
  			// Remove the redundant buttons from toolbar groups defined above.
  			removeButtons: 'Underline,Strike,Subscript,Superscript,Anchor,Styles,Specialchar',
          
  			width: '50%',
  			height: '60%'
  		} );
          </script>
  
  <script src="js/init.js"></script>
  <script>
	function indicator() {
		$(".indicator").css("background", "#1E88E5");
	}
	function snackBar() {
		var x = document.getElementById("snackbar")
		if ($('#snackbar').is(':empty')) {
			return;
		} else {
			x.className = "show";
			setTimeout(function() {
				x.className = x.className.replace("show", "");
			}, 3000);
		}
	}
	$(function() {
		indicator();
		snackBar();
	});
	$(document).ready(function() {
		$(".indicator").css("background", "#1E88E5");
		// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
		$('.modal').modal();
	});
	$('.modal').modal({
		dismissible : true, // Modal can be dismissed by clicking outside of the modal
		opacity : .5, // Opacity of modal background
		inDuration : 300, // Transition in duration
		outDuration : 200, // Transition out duration
		startingTop : '4%', // Starting top style attribute
		endingTop : '10%', // Ending top style attribute
		ready : function(modal, trigger) { // Callback for Modal open. Modal and trigger parameters available.
			alert("Ready");
			console.log(modal, trigger);
		},
		complete : function() {
			alert('Closed');
		} // Callback for Modal close
	});
	$('#modlbtn').on('click', function() {
		indicator();
	});
</script>
  
 
 </body>
 <style>
h1 {
	margin-top: 180px;
	margin-bottom: 50px;
	font-size: 70px;
	color: #fff;
}
#login_form, #signup_form {
	padding: 20px 45px;
}
#login_form h3 {
	font-size: 30px;
	margin: 0;
}
#cards button {
	margin-top: 10px;
	margin-bottom: 15px;
}
#cards {
	padding: 0;
	margin-top: 50px;
}
.indicator {
	background: #1E88E5;
}
#mdlbtn {
	/* 	margin-top:300px; */
	
}
/* snackbar */
/* The snackbar - position it at the bottom and in the middle of the screen */
#snackbar {
	visibility: hidden; /* Hidden by default. Visible on click */
	min-width: 250px; /* Set a default minimum width */
	margin-left: -125px; /* Divide value of min-width by 2 */
	background-color: #333; /* Black background color */
	color: #fff; /* White text color */
	text-align: center; /* Centered text */
	border-radius: 2px; /* Rounded borders */
	padding: 16px; /* Padding */
	position: fixed; /* Sit on top of the screen */
	z-index: 1; /* Add a z-index if needed */
	left: 50%; /* Center the snackbar */
	bottom: 100px; /* 30px from the bottom */
}
/* Show the snackbar when clicking on a button (class added with JavaScript) */
#snackbar.show {
	visibility: visible; /* Show the snackbar */
	/* Add animation: Take 0.5 seconds to fade in and out the snackbar. 
However, delay the fade out process for 2.5 seconds */
	-webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
	animation: fadein 0.5s, fadeout 0.5s 2.5s;
}
/* Animations to fade the snackbar in and out */
@
-webkit-keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}
to {
	bottom: 30px;
	opacity: 1;
}
}
@
keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}
to {
	bottom: 30px;
	opacity: 1;
}
}
@
-webkit-keyframes fadeout {
	from {bottom: 30px;
	opacity: 1;
}
to {
	bottom: 0;
	opacity: 0;
}
}
@
keyframes fadeout {
	from {bottom: 30px;
	opacity: 1;
}
to {
	bottom: 0;
	opacity: 0;
}
}
</style>
</html>