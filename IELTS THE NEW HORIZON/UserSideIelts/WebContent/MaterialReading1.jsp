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

		<center class="p">The construction of roads and bridges</center>
		<br>
		<div class="image">
			<img src="assets/images/the-construction-of-roads-and-bridges.png">
		</div>
		<p>
			<br>
       <p><strong>Roads</strong></p>
<p><span style="font-weight: 400;">Although there were highway links in Mesopotamia from as early as 3500 </span><span style="font-weight: 400;">bc, </span><span style="font-weight: 400;">the Romans were probably the first road-builders with fixed engineering standards. At the peak of the Roman Empire in the first century </span><span style="font-weight: 400;">ad, </span><span style="font-weight: 400;">Rome had road connections totalling about 85,000 kilometres.</span></p>
<p><span style="font-weight: 400;">Roman roads were constructed with a deep stone surface for stability and load-bearing. They had straight alignments and therefore were often hilly. The Roman roads remained the main arteries of European transport for many centuries, and even today many roads follow the Roman routes. New roads were generally of inferior quality, and the achievements of Roman builders were largely unsurpassed until the resurgence of road-building in the eighteenth century.</span></p>
<p><span style="font-weight: 400;">With horse-drawn coaches in mind, eighteenth-century engineers preferred to curve their roads to avoid hills. The road surface was regarded as merely a face to absorb wear, the load-bearing strength being obtained from a properly prepared and well-drained foundation. Immediately above this, the Scottish engineer John McAdam (1756-1836) typically laid crushed stone, to which stone dust mixed with water was added, and which was compacted to a thickness of just five centimetres, and then rolled. McAdam&rsquo;s surface layer - hot tar onto which a layer of stone chips was laid - became known as &lsquo;tarmacadam&rsquo;, or tarmac. Roads of this kind were known as flexible pavements.</span></p> <i>
			<br>
	</div>
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
	<br><br><br> <br><br>
		<p>
Label the diagram below.<br>
			<b><i>Questions 1-3</b>
				Choose <b style="color: Red;"> NO MORE THAN THREE WORDS / OR A NUMBER</b> from the
				passage for each answer.
			</i><br> Write your answers in boxes 1-3 <br>
	
		<div class="image">
<img src="assets/images/the-construction-of-roads-and-bridges_que.png" alt="" >
</div>
		<p>
			 <br>1.<input type="text"
				name="misc" value="" id="que1" /><span id="ans1" class="showhide" style="color: red; display:none;"><b>Answer:
					 hot tar</b></span>  <br><br> 2.<input type="text"
				name="misc1" value="" id="que2" /> <span id="ans2" class="showhide" style="color: red; display:none;"><b>Answer: Solar
					 five centimetres </b></span><br> <br>3.<input type="text" id="que3" name="">
			<br> <span id="ans3" class="showhide" style="color: red; display:none;"><b>Answer
					:  water </b></span><br> 
		</p>
	</div>
	<div class="button_container" style="margin-top: -2px;margin-left: -20px;">
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btnv" onclick="showHideDiv();">   Submit Answer</button>
	<button class="btnv1" onclick="showHideDiv();" style="margin-left: 2%;"> View Solution </button>
	<button class="btnv1" onclick="showHideReset();" style="background-color: red;width: 10%;" value="Reset">Reset</button>
</div>
</div>
</body>
</html>