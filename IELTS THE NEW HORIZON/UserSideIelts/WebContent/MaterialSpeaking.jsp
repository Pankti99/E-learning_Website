<%@ include file="header.jsp"%>

<link rel="stylesheet" href="assets/css/audio.css">

<link rel="favicon" href="assets/images/favicon.png">

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/bootstrap-theme.css"
	media="screen">
<link rel="stylesheet" href="assets/css/speaking.css">
<link rel="stylesheet" href="assets/css/modal2.css">
<link rel='stylesheet' id='camera-css' href='assets/css/camera.css'
	type='text/css' media='all'>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/html5shiv.js"></script>
<script src="assets/js/respond.min.js"></script>

<script src="assets/js/app.js"></script>
<script src="assets/js/audio.js"></script>



<div>
	<p
		style="margin-left: 50%; margin-top: 10%; font-size: 30PX; font-family: verdana; color: #1E90FF;">Day1&nbsp;sports
	</p>
</div>
<div>
	<p
		style="margin-left: 50%; margin-top: 10px; font-size: 25PX; font-family: Comic Sans MS, cursive, sans-serif;">
		Today we will practice speaking about Sports.</p>
</div>
<div>


	<div class="speaking_main_day"
		style="margin-left: 20%; margin-top: 10%;">
		<div class="speaking_material_day">
			<div class="speaking_upper" style="margin-top: 0;">
				<img src="assets/images/microphone.gif" height="60" width="50"
					style="margin-top: 10px;">
				<p
					style="font-size: 28px; margin-left: 80px; color: white; margin-top: -70px;">
					part I <br>Intro
				</p>
			</div>

			<p style="font-size: 20px; margin-left: 10px; line-height: normal;">Practice
				short interview type questions</p>
			<br>

			<button class="modal-open11" data-modal="modal1"
				style="margin-left: 13%; width: 50%; background-color: white; color: black;">Question
				1</button>


			<div class="modal" id="modal1">
				<div class="modal-content">
					<div class="modal-header">
						Day1
						<button class="icon modal-close">
							<i class="material-icons" style="color: black;">&times;</i>
						</button>
					</div>
					<div class="modal-body">
						<p style="font-size: 25px; font-family: verdana;">
							<button class="play"  style="width: 105%;!important;" onclick="s()">Press play to listen
								to the question and then record the answer below</button>
							<br>
							<br> <b>Answer:</b> Yes of course. I grew up playing
							football like most children in my country. We used to play after
							school and for hours every day during school break. <br> <br>

							Nowadays, I don't have much time because I work long hours. But
							last month I was on vacation and I had a great time playing on
							the beach.




						</p>


						<div id="controls">
							<button id="recordButton">
								<img src="assets/images/microphone1.png">
							</button>
							<button id="pauseButton" disabled>
								<img src="assets/images/pause.png">
							</button>
							<button id="stopButton" disabled>
								<img src="assets/images/stop.jpg">
							</button>
						</div>
						<br> <br>
						<div id="formats" style="margin-left: 6.5%;">Format: start
							recording to see rate</div>
						<h3 style="margin-right: 70%;">Recordings</h3>
						<ol id="recordingsList"></ol>

					</div>
					<div class="modal-footer">
						<button class="link modal-close">Quite</button>
					</div>
				</div>
			</div>
		</div>
&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
		<button class="modal-open11" data-modal="modal2"
			style="margin-left: -297px; margin-top: 300px; width: 15%; background-color: white; color: black;">Question
			2</button>


		<div class="modal" id="modal2">
			<div class="modal-content">
				<div class="modal-header">
					Day1
					<button class="icon modal-close">
						<i class="material-icons" style="color: black;">&times;</i>
					</button>
				</div>
				<div class="modal-body">
					<p style="font-size: 25px; font-family: verdana;">
						<button class="play"  style="width: 105%;!important;" onclick="q2()">Press play to listen
							to the question and then record the answer below</button>
						<br>
						<br> <b>Answer:</b> Yes I like to watch tennis and football
						every now and then.It's usually when there is a major tournament
						going on.I meet up with friends at a cafe or bar and we watch a
						game together.<br>
						<br>It's a good occasion to have a reunion.And watching
						sports is a great social activity because you can talk and laugh
						as you do it.




					</p>

					<div id="controls1">
						<button id="recordButton1">
							<img src="assets/images/microphone1.png">
						</button>
						<button id="pauseButton1" disabled>
							<img src="assets/images/pause.png">
						</button>
						<button id="stopButton1" disabled>
							<img src="assets/images/stop.jpg">
						</button>
					</div>
					<br> <br>
					<div id="formats1" style="margin-left: 6.5%;">Format: start
						recording to see rate</div>
					<h3 style="margin-right: 70%;">Recordings</h3>
					<ol id="recordingsList1"></ol>

				</div>
				<div class="modal-footer">
					<button class="link modal-close">Quite</button>
				</div>
			</div>
		</div>
	</div>

</div>



<div class="speaking_main_day"
	style="margin-left: 40%; margin-top: -500px;">
	<div class="speaking_material_day">
		<div class="speaking_upper" style="margin-left: 0; margin-top: 0;">
			<img src="assets/images/microphone.gif" height="60" width="50"
				style="margin-top: 10px;">
			<p
				style="font-size: 28px; margin-left: 80px; color: white; margin-top: -70px;">
				part II <br>Long Turn
			</p>
		</div>

		<p style="font-size: 20px; margin-left: 10px; line-height: normal;">Practice
			speaking on topic</p>
		<br>

		<button class="modal-open2" data-modal="modal3"
			style="margin-left: 10%; width: 50%; background-color: white; color: black; margin-top: 10%;">Question
			3</button>


		<div class="modal" id="modal3">
			<div class="modal-content">
				<div class="modal-header">
					Day1
					<button class="icon modal-close">
						<i class="material-icons" style="color: black;">&times;</i>
					</button>
				</div>
				<div class="modal-body">
					<p style="font-size: 25px; font-family: verdana;">
						<button class="play"  style="width: 105%;!important;" onclick="q3()">Press play to listen
							to the question and then record the answer below</button>
						<br>
						<br> <b>Answer:</b> I would really like to learn fencing. It
						is such an elegant sport. I've watched it on television during the
						Olympics. <br>
						<br> Two opponents face each other in a duel using swords and
						wearing light metal vests. Each fencer tries to touch the tip of
						their sword onto the body of their opponent and the first one to
						do so wins a point. The first fencer to score three points wins
						the match. <br>
						<br> The two opponents are masked which adds to the mystery
						of the game. You only see their faces after it's over and the
						winner is announced. <br>
						<br> This seems like a difficult sport to me, requiring
						training with a knowledgeable coach. I would have to join a
						fencing club and practice for months before I can participate in a
						duel. But I think I would enjoy the challenge.





					</p>


					<div id="controls3">
						<button id="recordButton3">
							<img src="assets/images/microphone1.png">
						</button>
						<button id="pauseButton3" disabled>
							<img src="assets/images/pause.png">
						</button>
						<button id="stopButton3" disabled>
							<img src="assets/images/stop.jpg">
						</button>
					</div>
					<br> <br>
					<div id="formats3" style="margin-left: 6.5%;">Format: start
						recording to see rate</div>
					<h3 style="margin-right: 70%;">Recordings</h3>
					<ol id="recordingsList3"></ol>

				</div>
				<div class="modal-footer">
					<button class="link modal-close">Quite</button>
				</div>
			</div>
		</div>
	</div>




</div>
<div class="speaking_main_day"
	style="margin-left: 20%; margin-top: 550px;">
	<div class="speaking_material_day">
		<div class="speaking_upper" style="margin-left: 1px; margin-top: 0;">
			<img src="assets/images/microphone.gif" height="60" width="50"
				style="margin-top: 10px;">
			<p
				style="font-size: 28px; margin-left: 80px; color: white; margin-top: -70px;">
				part III <br>Discussion
			</p>
		</div>

		<p style="font-size: 20px; margin-left: 10px; line-height: normal;">
			Practice Discussing an <br>opinion
		</p>
		<br>

		<button class="modal-open11" data-modal="modal4"
			style="margin-left: 10%; width: 50%; background-color: white; color: black; margin-top: 10%;">Question
			4</button>


		<div class="modal" id="modal4">
			<div class="modal-content">
				<div class="modal-header">
					Day1
					<button class="icon modal-close">
						<i class="material-icons" style="color: black;">&times;</i>
					</button>
				</div>
				<div class="modal-body">
					<p style="font-size: 25px; font-family: verdana;">
						<button class="play" onclick="q4()">Press play to listen
							to the question and then record the answer below</button>
						<br>
						<br> <b>Answer:</b> I prefer to watch sports live. There is
						nothing like the atmosphere of a stadium and the noise made by the
						fans. Especially when there is a rivalry and some history between
						the competing sides. <br>
						<br> Television is very convenient nowadays. You can watch
						replays and get the best view of every moment. But being in
						person, you get to feel the emotion of the game. <br>
						<br> I remember the last time I went to a cup final to
						support my local football team. We sang and cheered so much that
						the next day I lost my voice and couldn't speak at all.



					</p>


					<div id="controls4">
						<button id="recordButton4">
							<img src="assets/images/microphone1.png">
						</button>
						<button id="pauseButton4" disabled>
							<img src="assets/images/pause.png">
						</button>
						<button id="stopButton4" disabled>
							<img src="assets/images/stop.jpg">
						</button>
					</div>
					<br> <br>
					<div id="formats4" style="margin-left: 6.5%;">Format: start
						recording to see rate</div>
					<h3 style="margin-right: 70%;">Recordings</h3>
					<ol id="recordingsList4"></ol>

				</div>
				<div class="modal-footer">
					<button class="link modal-close">Quite</button>
				</div>
			</div>
		</div>
	</div>

</div>


</body>

</html>

<script src="assets/js/modal1.js"></script>

<script
	src="https://cdn.rawgit.com/mattdiamond/Recorderjs/08e7abd9/dist/recorder.js"></script>
<script src="assets/js/audio.js"></script>
<script>
	function s() {

		var msg = new SpeechSynthesisUtterance('Do you play any sports?');
		window.speechSynthesis.speak(msg);
	}

	function q2() {

		var msg = new SpeechSynthesisUtterance(
				'Do you watch sports on television?');
		window.speechSynthesis.speak(msg);
	}

	function q3() {

		var msg = new SpeechSynthesisUtterance(
				'Describe a sport you would like to learn.           you should say what the sport is?           explain the basic rules to someone who is not familier with this sport.             Describe what equipments is needed to play this sport.        how you would learn this sport and          why would you like to learn this sport? ');
		window.speechSynthesis.speak(msg);
	}

	function q4() {

		var msg = new SpeechSynthesisUtterance(
				'Do you like to attend sport events in person?  what do you prefer to watch on a television?   and   why?');
		window.speechSynthesis.speak(msg);
	}
</script>