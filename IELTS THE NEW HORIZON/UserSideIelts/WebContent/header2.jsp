<!DOCTYPE html>
<%@page import="com.bean.LoginInfo"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="webThemez.com">
	<title>IELTS The New Horizon</title>
    <link rel="favicon" href="assets/images/favicon.png">
<!--     <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700"> -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"> 
    <link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen"> 
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel='stylesheet' id='camera-css'  href='assets/css/camera.css' type='text/css' media='all'> 

    <link rel="stylesheet" href="css/style.css">
	
<%LoginInfo info = (LoginInfo)session.getAttribute("loginInfo"); %>	
</head>
<body>
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
				<a class="navbar-brand" href="index.html">
					<img src="assets/images/l2.png" alt="" height=80 style="margin-top: -40px;"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right mainNav">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="aboutUs.jsp">About</a></li>
					
					<%if(info != null){ %>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Vocabulary<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="showVocabulary.action">About Vocabulary</a></li>
							<li><a href="showVocabularyList.action">Vocabulary List</a></li>
							<li><a href="showExamQuestion.action">Vocabulary Exam</a></li>
						</ul>
					</li>
					<%} %>
					
					<%if(info != null){ %>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Exam<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="showWrittingList.action">Writing</a></li>
							<li><a href="showReadingPessageName.action">Reading</a></li>
							<li><a href="showListeningPessageName.action">Listening</a></li>
							<li><a href="showSpeakingTest.action">Speaking</a></li>
						</ul>
					</li>
					<%} %>
					
					<%if(info != null){ %>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Exam Result<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="showVocabularyResultList.action">Vocabulary</a></li>
							<li><a href="showWrittingResultList.action">Writing</a></li>
							<li><a href="showReadingResultList.action">Reading</a></li>
							<li><a href="showListeningResultList.action">Listening</a></li>
							<li><a href="showSpeakingResultList.action">Speaking</a></li>
						</ul>
					</li>
					<%} %>

					<%if(info != null){ %>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Material<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="Materialwriting.action">Writing</a></li>
							<li><a href="MaterialReading.action">Reading</a></li>
							<li><a href="MaterialListening.action">Listening</a></li>
							<li><a href="MaterialSpeaking.action">Speaking</a></li>
							<li><a href="showChat.action">Group Chat</a></li>
						</ul>
					</li>
					<%} %>

					
					<li><a href="contact.jsp">Contact Us</a></li>

					<%if(info == null){ %>
						<li><a href="login.jsp">Login</a></li>
					<%} else { %>
						<li><a href="logout.action">Log Out</a></li>
					<% } %>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- /.navbar -->