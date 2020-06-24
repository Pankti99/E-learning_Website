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
        <audio controls src="assets/listening/task2.mp3" style="margin-left: 5%; border:black;" ></audio><br>

		<h1 style="font-family: verdana; color: green; text-align: center;">
			Questions 1-4</h1>

		<p style="font-size: 20px; color: black;">Listen the disussion
			about open university and complete the sentence.</p>
		<p style="font-size: 20px; font-family: verdana; color: red;">Write
			NO MORE THAN ONE WORD for each answer.</p>

		<div>
			<p class="t2">
				1. Studying with the Open University demanded a great deal of <input
					type="text" class="c" id="q1">
			<p style="font-family: verdana; font-size: 20px; color: red; display:none;" id="ans1">Answer:
				Motivation</p>
			<p class="t2">
				2. Studying and working at the same time improved Rachel <input
					type="text" class="c" id="q2"> skills.
			<p style="font-family: verdana; font-size: 20px; color: red; display:none;" id="ans2">Answer:
				time(-)management</p>
			<p class="t2">
				3. It was helpful that the course was structured in <input
					type="text" class="c" id="q3">
			<p style="font-family: verdana; font-size: 20px; color: red; display:none;" id="ans3">Answer:
				modules</p>
			<br>
			<p class="t2">
				4. She enjoyed meeting other students at <input type="text"
					class="c" id="q4">
			<p style="font-family: verdana; font-size: 20px; color: red; display:none;" id="ans4">Answer:
				summer school(s)</p>
		</div>
		<div class="button_container" style="margin-top: -1%;">
			<button class="btnv" onclick="showHideDiv();">Submit</button>
			<button class="btnv1" onclick="showHideDiv();" style="margin-left: 7%;">View Solution</button>
			<button class="btnv1" onclick="showHideReset();" style="background-color: red; margin-left: 10%;" value="Reset">Reset</button>
		</div>

	</div>
	</body>
	</html>