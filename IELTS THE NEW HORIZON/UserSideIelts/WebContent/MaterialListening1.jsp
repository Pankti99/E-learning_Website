<%@ include file="header.jsp"%>

    <link rel="icon" href="images/favicon.png" type="image/x-icon" />
    <link href="vendors/animate/animate.css" rel="stylesheet">
	<link rel="stylesheet" href="vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendors/camera-slider/camera.css">
	<link rel="stylesheet" type="text/css" href="vendors/owl_carousel/owl.carousel.css" media="all">

<script>
function showHideDiv(){
	document.getElementById("ans1").style = "display:block";
	document.getElementById("ans1").style = "color:red";
	document.getElementById("ans2").style = "display:block";
	document.getElementById("ans2").style = "color:red";
	document.getElementById("ans3").style = "display:block";
	document.getElementById("ans3").style = "color:red";
	document.getElementById("ans4").style = "display:block";
	document.getElementById("ans4").style = "color:red";
}
function showHideReset(){
	document.getElementById("q1").value = "";
	document.getElementById("q2").value = "";
	document.getElementById("q3").value = "";
	document.getElementById("q4").value = "";


	document.getElementById("ans1").style = "display:none";
	document.getElementById("ans2").style = "display:none";
	document.getElementById("ans3").style = "display:none";
	document.getElementById("ans4").style = "display:none";
}
</script>

	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
	<br><br><br>
                            <audio controls src="assets/listening/task4.mp3" style="margin-left: 500px;" ></audio>                   

		<h1 style="font-family: verdana; color: green; text-align: center;">
			Questions 1-5</h1>	

		<p style="font-size: 20px; color: black;">Listen the disussion
			about Save The Ocean complete the sentence.</p>
		<p style="font-size: 20px; font-family: verdana; color: red;">Write
			ONE WORD ONLY for each answer.</p>

		<div>
		<p class="t2">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
I would like to share with you this morning some 1.<input
					type="text" class="c" id="q1">	<p style="font-family: verdana; font-size: 20px; color: red; display:none;" id="ans1">Answer:
				stories</p>
			about the ocean through my work as a still photographer for National Geographic magazine. I guess I became an underwater photographer and a 
		
				2.  <input
					type="text" class="c" id="q2"> skills.
			<p style="font-family: verdana; font-size: 20px; color: red; display:none;" id="ans2">Answer:
				 photojournalist</p>because I fell in love with the sea as a child. And I wanted to tell stories about all the amazing things I was seeing
				3. <input
					type="text" class="c" id="q3">,
			<p style="font-family: verdana; font-size: 20px; color: red; display:none;" id="ans3">Answer:
				 underwater</p> incredible wildlife and interesting behaviors. And after even 30 years of doing this, after 30 years of exploring the ocean, I never cease to be amazed at the 
				4.  <input type="text"
					class="c" id="q4">
			<p style="font-family: verdana; font-size: 20px; color: red; display:none;" id="ans4">Answer:
				 extraordinary</p>
				 encounters that I have while I’m at sea. But more and more frequently these days I’m seeing terrible things underwater as well, things that I don’t think most people realize. And I’ve been 
				5.  <input type="text"
					class="c" id="q4">
			<p style="font-family: verdana; font-size: 20px; color: red; display:none;" id="ans4">Answer:
				 compelled</p>
				 to turn my camera towards these issues to tell a more complete story. I want people to see what’s happening underwater, both the horror and the magic.
		</div>
		<div class="button_container" style="margin-top: -1%;">
			<button class="btnv" onclick="showHideDiv();">Submit</button>
			<button class="btnv1" onclick="showHideDiv();" style="margin-left: 7%;">View Solution</button>
				<button class="btnv1" onclick="showHideReset();" style="background-color: red; margin-left: 10%;" value="Reset">Reset</button>
		</div>

	</div>
	</body>
	</html>