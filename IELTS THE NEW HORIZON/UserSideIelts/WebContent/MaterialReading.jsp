<%@ include file="header.jsp"%>

    <link rel="icon" href="images/favicon.png" type="image/x-icon" />
    <link href="vendors/animate/animate.css" rel="stylesheet">
	<link rel="stylesheet" href="vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendors/camera-slider/camera.css">
	<link rel="stylesheet" type="text/css" href="vendors/owl_carousel/owl.carousel.css" media="all">

<link rel="stylesheet" href="assets/css/question.css">
<script src="assets/js/jquerysplit.js"></script>
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
	document.getElementById("ans5").style = "display:block";
	document.getElementById("ans5").style = "color:red";
}
function showHideReset(){
	document.getElementById("que1").value = "";
	document.getElementById("que2").value = "";
	document.getElementById("que3").value = "";
	document.getElementById("que4").value = "";
	document.getElementById("que5").value = "";


	document.getElementById("ans1").style = "display:none";
	document.getElementById("ans2").style = "display:none";
	document.getElementById("ans3").style = "display:none";
	document.getElementById("ans4").style = "display:none";
	document.getElementById("ans5").style = "display:none";
}
</script>

<style type="text/css">
body {
	background-color: #FAEBD7;
}

.image img {
	margin-top: 3%;
	margin-left: 25%;
	width: 50%;
	height: 50%;
	border: 2px solid black;
}

u {
	text-decoration: underline;
	-webkit-text-decoration-color: red; /* Safari */
	text-decoration-color: red;
	background-color: yellow;
}

p {
	font-size: 20px;
	font-family: "Times New Roman", Times, serif;
	text-align: justify;
	text-justify: inter-word;
}

.p {
	font-size: 30px;
	font-family: "Times New Roman", Times, serif;
	text-align: center;
	text-justify: inter-word;
}

::selection {
	color: red;
	background: yellow;
}
</style>





<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-top: 2%;">
	<!-- Left side content> -->
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"
		style="text-align: justify;">

		<center class="p">Information theory - the big idea</center>
		<br>
		<div class="image">
			<img src="assets/images/it.jpg">
		</div>
		<p>
			<br> <i>Information theory lies at the heart of everything -
				from DVD players and the genetic code of DNA to the physics of the
				universe at its most fundamental. It has been central to the
				development of the science of communication, which enables data to
				be sent electronically and has therefore had a major impact on our
				lives Jupiter and Saturn and then soared out of the  Solar System on
			a one-way mission to the stars. After 25 years of exposure to the
			freezing temperatures of deep space, the probe was beginning to show
			its age. Sensors and circuits were on the brink of failing and NASA experts
			realised that they had to do something or lose contact with their
			probe forever. The solution was to get a message to Voyager I to
			instruct it to use spares to change the failing parts. With the probe 12 billion
			kilometres from Earth, this was not an easy task. By means of a radio dish belonging
			to NASA's Deep Space Network, the message was sent out into the
			depths of space. Even travelling at the speed of light, it took over
			11 hours to reach its target, far beyond the orbit of Pluto. Yet,
			incredibly, the little probe managed to hear the faint call from its
			home planet, and successfully made the switchover.<br>
	</div>
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
		<p>
			<b>Questions 1-5</b><br> <i>Complete the notes below.<br>
				Choose <b style="color: Red;"> NO MORE THAN THREE WORDS</b> from the
				passage for each answer.
			</i><br> Write your answers in boxes 1-5 <br>
		</p>
		<center class=p>The Voyager 1 Space Probe</center>
		<br>
		<p>
			The probe transmitted pictures of both <br>1.<input type="text"
				name="misc" value="" id="que1" />,<span id="ans1" class="showhide" style="color: red; display:none;"><b>Answer:
					Jupiter and Saturn</b></span> then left the <br> 2.<input type="text"
				name="misc1" value="" id="que2" /> <span id="ans2" class="showhide" style="color: red; display:none;"><b>Answer: Solar
					System </b></span><br> The freezing temperatures were found to have a
			negative effect on parts of the space probe.<br> Scientists
			feared that both the <br>3.<input type="text" id="que3" name="">
			were about to stop working.<br> <span id="ans3" class="showhide" style="color: red; display:none;"><b>Answer
					: sensors and circuits </b></span><br>
			The only hope was to tell the probe to replace them with <br>4.<input
				type="text" name="" id="que4"> - but distance made communication with
			the probe difficult.<br> <span id="ans4" class="showhide" style="color: red; display:none;"><b>Answer:
					spares </b></span> <br> A 5.<input type="text" id="que5" name=""> was used
			to transmit the message at the speed of light.<br> <span id="ans5" class="showhide"
				style="color: red; display:none;"><b>Answer: radio dish</b></span><br> 
		</p>
	</div>
	<div class="button_container" style="margin-top: -1%;">
	<button class="btnv" onclick="showHideDiv();">Submit Answer</button>
	<button class="btnv1" onclick="showHideDiv();" style="margin-left: 2%;"> View Solution </button>
	<button class="btnv1" onclick="showHideReset();" style="background-color: red;width: 10%;" value="Reset">Reset</button>
</div>
	
</div>


</body>
</html>