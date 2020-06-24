<!DOCTYPE html>
<%@page import="com.bean.LoginInfo"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.common.connection"%>
<%@page import="darwinsys.chat.ChatConstants"%>
<%@page import="darwinsys.chat.ChatState"%>

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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen">
<link rel="stylesheet" href="assets/css/style.css">
<link rel='stylesheet' id='camera-css' href='assets/css/camera.css'
	type='text/css' media='all'>

<link rel="stylesheet" href="assets/styles.css">
<link rel="stylesheet" href="assets/popup.css">

<%
	LoginInfo info = (LoginInfo) session.getAttribute("loginInfo");
%>
</head>
<body style="background:white;">

	<a class="navbar-brand" href="index.jsp"> <img src="assets/images/l2.png" alt="" height=80 style="margin-top: -35px;">
	</a>
	<div id='cssmenu' style="margin-left:18%; margin-top: 2%; z-index:-1;">
		<ul style="color:blue;background:white;">
			<li><a href='index.jsp'><span>Home</span></a></li>
			<li><a href='aboutUs.jsp'><span>About</span></a></li>
			
			<li class='has-sub'><a href='#'><span>Material</span></a>
				<ul>
					<li class='has-sub'><a href='#'><span>Writing</span></a>
						<ul>
							<li class='has-sub'><a href='Materialwriting.action'><span>Writing 1</span></a></li>
							<li class='has-sub'><a href='Materialwriting1.action'><span>Writing 2</span></a></li>
							<li class='has-sub'><a href='Materialwriting2.action'><span>Writing 3</span></a></li>
						</ul>
					</li>
					<li class='has-sub'><a href='#'><span>Reading</span></a>
						<ul>
							<li class='has-sub'><a href='MaterialReading.action'><span>Reading 1</span></a></li>
							<li class='has-sub'><a href='MaterialReading1.action'><span>Reading 2</span></a></li>
							<li class='has-sub'><a href='MaterialReading2.action'><span>Reading 3</span></a></li>
						</ul>
					</li>
					<li class='has-sub'><a href='#'><span>Listening</span></a>
						<ul>
							<li class='has-sub'><a href='MaterialListening.action'><span>Listening 1</span></a></li>
							<li class='has-sub'><a href='MaterialListening1.action'><span>Listening 2</span></a></li>
							<li class='has-sub'><a href='MaterialListening1.action'><span>Listening 3</span></a></li>
						</ul>
					</li>
					<li class='has-sub'><a href='#'><span>Speaking</span></a>
						<ul>
							<li class='has-sub'><a href='MaterialSpeaking.action'><span>Speaking 1</span></a></li>
							<li class='has-sub'><a href='MaterialSpeaking1.action'><span>Speaking 2</span></a></li>
							<li class='has-sub'><a href='MaterialSpeaking2.action'><span>Speaking 3</span></a></li>
						</ul>
					</li>
				</ul>
			</li>
			
			
			
			
			<%if(info != null){ %>
			<li class='has-sub'><a href='#'><span>Vocabulary</span></a>
				<ul>
					<li class='has-sub'><a href='showVocabulary.action'><span>About Vocabulary</span></a></li>
					<li class='has-sub'><a href='showVocabularyList.action'><span>Vocabulary List</span></a></li>
					<li class='has-sub'><a href='showExamQuestion.action'><span>Vocabulary Exam</span></a></li>
							<li><a href='showVocabularyResultList.action'><span>Vocabulary Result</span></a></li>
			
				</ul>
			</li>
			<%} %>
			
			<%if(info != null){ %>
			<li class='has-sub'><a href='#'><span>Exam</span></a>
				<ul>
				
					<li class='has-sub'><a href='#'><span>Practice Test</span></a>
						<ul>
							<li><a href='showWrittingList.action?isMock=0'><span>Writing</span></a></li>
							<li><a href='showReadingPessageName.action?isMock=0'><span>Reading</span></a></li>

							<li><a href='showListeningName.action?isMock=0'><span>Listening</span></a></li>
							
							<li class='last'><a href='showSpeakingName.action?isMock=0'><span>Book Speaking Slot</span></a></li>
							<li class='last'><a href='showSpeakingSlotList.action?isMock=0'><span>Speaking</span></a></li>
						</ul></li>
					
					
			
					<li class='has-sub'><a href='#'><span>Mock Test</span></a>
						<ul>
							<li><a href='showWrittingListMock.action?isMock=1'><span>Writing</span></a></li>
							<li><a href='showReadingPessageNameMock.action?isMock=1'><span>Reading</span></a></li>
							<li><a href='showListeningNameMock.action?isMock=1'><span>Listening</span></a></li>
							
							<li class='last'><a href='showSpeakingName.action?isMock=1'><span>Book Speaking Slot</span></a></li>
							<li class='last'><a href='showSpeakingSlotList.action?isMock=0'><span>Speaking</span></a></li>
						</ul>
					</li>
					
						
				</ul>
			</li>
			<%} %>
			
			<%if(info != null){ %>
			<li class='has-sub'><a href='#'><span>Exam Result</span></a>
				<ul>
					<li class='has-sub'><a href='#'><span>Practice Result</span></a>
						<ul>
							<li><a href='showWrittingResultList.action'><span>Writing</span></a></li>
							<li><a href='showReadingResultList.action'><span>Reading</span></a></li>
							<li><a href='showListeningResultList.action'><span>Listening</span></a></li>
							<li class='last'><a href='showSpeakingResultList.action'><span>Speaking</span></a></li>
						</ul></li>
			
			
					<li class='has-sub'><a href='#'><span>Mock Result</span></a>
						<ul>
							<li><a href='showMockResultList.action'><span>Mock Result</span></a></li>
						</ul></li>
				</ul>
			</li>
			<%} %>

			<li class='last'><a href='contact.jsp'><span>Contact</span></a></li>
						
					<%if(info != null){ 
				Connection conn=connection.getConnection();	
				PreparedStatement pstmt=null;
				ResultSet rs = null;
				int id=0;
				if(conn!=null){
					 String selectSQL = "Select * from tblnotification_chat";
					 try {
						pstmt = conn.prepareStatement(selectSQL);
						rs = pstmt.executeQuery();
						while(rs.next()){
							id=rs.getInt("user_detail_id");
						}
					 }
						catch(Exception e )
						{
						e.printStackTrace();
						}
					 System.out.println("id is ::"+id);
					 System.out.println("id is ::"+info.getUserDetailId());
	
					if(info.getUserDetailId()!=id){ %> 
					
					  

<div id="popup" onclick="myFunction()">
 <i class="fa fa-bell" style="font-size:52px;color:white;background:#6495ED;" ></i>
 <a href="chat.jsp"> <span class="popuptext" id="myPopup">New chat message!</span></a>
 </div>
 
  
			  
				
		
<%  }}%>

<% } %>
				
		

			<%if(info == null){ %>
				<li class='last'><a href='login.jsp'><span>Login</span></a></li>
				
			<%} else { %>
			
			<li class='last'><a href='chat.jsp?id=1'><span>Chat</span></a></li>
			
			<% String x = info.getUserName(); %>	
			<li style=" background:#6495ED;color:white;font-size:20px;height:52px;padding-top:10px;"><span><%out.println(x);%></span></li>
			
				<li class='last'><a href='logout.action'><span>Log Out</span></a></li>
				
			<% } %>
			
			


		</ul>
	</div>
	
	
	
	<script>
// When the user clicks on div, open the popup
function myFunction() {
  var popup = document.getElementById("myPopup");
  popup.classList.toggle("show");
}
</script>