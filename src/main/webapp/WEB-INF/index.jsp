<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>INDEX</title>

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
<body >
  <nav class="nav-extended light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container " style="color:"white";">
      <a id="logo-container" href="#" class="brand-logo"><span style="font-family: "Comic Sans MS";"><font color="white">E-COMMERCE</font></span></a>
      
      <ul class=" hide-on-med-and-down right " >
       <li> <div class="center row">
                          <div class="col s12 " >
                            <div class="row" id="topbarsearch">
                              <div class="input-field col s6 s12 white-text">
                                <form action="searchitem" method="post"></form>
                                <i class="white-text material-icons prefix">search</i>
                                <input type="text" placeholder="search" id="autocomplete-input" class="autocomplete white-text" name="keyword">
                                </div>
                              </div>
                            </div>
                          </div>  
       </li>
        <li><a href="#"><font color="white">Login</font></a></li>
        <li><a href="#"><font color="white">About</font></a></li>
        <li><a href="#"><font color="white">Contact Us</font></a></li>
      
      </ul>
      
      <ul id="nav-mobile" class="side-nav">
        <li><a href="#"><font color="white">Login</font></a></li>
        <li><a href="#"><font color="white">About</font></a></li>
        <li><a href="#"><font color="white">Contact Us</font></a></li>
      </ul>
    
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
    
         <div class="nav-content container">
      		
                   	
      	 </div>
 
  </nav>
  

      
  <div class="slider" style="display:block">
    <ul class="slides">
      <li>
        <img src="http://lorempixel.com/580/250/nature/1"> <!-- random image -->
        <div class="caption center-align">
          <h3>This is our big Tagline!</h3>
          <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        </div>
      </li>
      <li>
        <img src="http://lorempixel.com/580/250/nature/2"> <!-- random image -->
        <div class="caption left-align">
          <h3>Left Aligned Caption</h3>
          <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        </div>
      </li>
      <li>
        <img src="http://lorempixel.com/580/250/nature/3"> <!-- random image -->
        <div class="caption right-align">
          <h3>Right Aligned Caption</h3>
          <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        </div>
      </li>
      <li>
        <img src="http://lorempixel.com/580/250/nature/4"> <!-- random image -->
        <div class="caption center-align">
          <h3>This is our big Tagline!</h3>
          <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        </div>
      </li>
    </ul>
  </div>


  <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text"><i class="material-icons">flash_on</i></h2>
            <h5 class="center">Speeds up development</h5>

            <p class="light">We did most of the heavy lifting for you to provide a default stylings that incorporate our custom components. Additionally, we refined animations and transitions to provide a smoother experience for developers.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text"><i class="material-icons">group</i></h2>
            <h5 class="center">User Experience Focused</h5>

            <p class="light">By utilizing elements and principles of Material Design, we were able to create a framework that incorporates components and animations that provide more feedback to users. Additionally, a single underlying responsive system across all platforms allow for a more unified user experience.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text"><i class="material-icons">settings</i></h2>
            <h5 class="center">Easy to work with</h5>

            <p class="light">We have provided detailed documentation as well as specific code examples to help new users get started. We are also always open to feedback and can answer any questions a user may have about Materialize.</p>
          </div>
        </div>
      </div>

    </div>
    <br><br>

    <div class="section">
  
           <%
		        int i = 1;
			%>
		

		<c:forEach var="itemlist" items="${items}" begin="0" end="4">
		
			<table class=" bordered highlight ">
			    <tr>
			    	<td rowspan="3"><a href="/viewitem?itemid=${itemslist.ItemId}"><img src="${itemslist.ItemImageUrl}" ></a></td>
			    	<td><c:out value=" item brand name -->>${itemslist.ItemBrandName }" escapeXml="false"/></td>
			   </tr>
			   <tr>
			   		<td></td>
			   		<td> <c:out	value=" item price -->>${itemslist.ItemPrice }" escapeXml="false"/></td>
			   		
			    </tr>
			    
				<%
						i = i + 1;
					%>
				 </table>    
				</c:forEach>
			
		</div>
  </div>

  <footer class="page-footer light-blue lighten-1">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Company Bio</h5>
          <p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.</p>


        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Settings</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Connect</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by Materialize
      </div>
    </div>
  </footer>


  <!--  Scripts-->
 
  <script src="js/init.js"></script>
<script>
$(document).ready(function(){
    $('.slider').slider();
  });
$('.slider').slider('pause');
//Start slider
$('.slider').slider('start');
//Next slide
$('.slider').slider('next');
//Previous slide
$('.slider').slider('prev');
   
      
     
</script>

  </body>
</html>
