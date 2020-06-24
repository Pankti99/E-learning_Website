<%@include file="header.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link rel="icon" href="images/favicon.png" type="image/x-icon" />
<link href="vendors/animate/animate.css" rel="stylesheet">
<link rel="stylesheet"
	href="vendors/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="vendors/camera-slider/camera.css">
<link rel="stylesheet" type="text/css"
	href="vendors/owl_carousel/owl.carousel.css" media="all">

<!--Theme Styles CSS-->
<link rel="stylesheet" type="text/css" href="css/style.css" media="all" />
<SCRIPT type="text/javascript">
function getResult() {
		var marks = 0;
		for (var i = 1; i < 6; i++) {
			var ans = document.getElementById("ans" + i).value;
			for (var j = 1; j < 5; j++) {
				if (document.getElementById("1" + j).checked) {
					if (ans == j) {
						marks = marks + 1;
					}
				}
			}
		}
// 		alert("Marks : " + marks);
		document.getElementById("totalMarks").value = marks;
		document.getElementById("submitResult").submit();
	}
	</script>
<section class="banner_area"style="margin-top:30px; height:250px;" data-stellar-background-ratio="0.5">
	<h2>Vocabulary</h2>
	<ol class="breadcrumb">
		<li><a href="index.jsp"><span>Home</span></a></li>	
		<li><a class="active" >Vocabulary Exam</a></li>
	</ol>
</section>

				
				<div class="timer" style="padding-left: 40%;margin-top:1%;">
					<div class="time">
						<p id="output" style="width:15%;color:red;text-align:center;font-size:25px;margin-left:8%;border-radius:10px;height:40px;">00:00</p>
					</div>
					<button  id="startPause" onclick="startPause()"  style="width:15%;margin-top:1%;background:hotpink;border-radius:10px;height:40px;font-size:20px;">
						<p id="start"style="color:white;">Start</p>
					</button>
					<button name="reset" id="reset" onclick="reset()"  style="margin-left:1%;width:15%;background:blue;border-radius:10px;height:40px;font-size:20px;">
						<p style="color:white;">Reset</p>
					</button>
				</div>

<section  style="margin-top:60px;">
	
	<form name="submitResult" id="submitResult" action="submitResult.action">
		<div class="container">
			<s:iterator value="tests">
				<div class="row contact_row" style="margin-bottom: -15%; padding: 55px 0;!important;font-size:20px;">
				
					<div class="col-sm-12 contact_info send_message" style="color:green;">
					
						Question :
						<s:property value="dispaly_vocabulary_test_id" />
						 &nbsp;
						<s:property value="vocabulary_material_word" />
						<br>
					</div>
					
					<div class="col-sm-3 contact_info send_message" style="color:black;">
					
						(A) &nbsp;<input type="radio"
							name="<s:property value="dispaly_vocabulary_test_id"/>"
							id="<s:property value="dispaly_vocabulary_test_id"/>1" value="1">
						&nbsp;
						<s:property value="option1" />
					</div>
					<div class="col-sm-3 contact_info send_message" style="color:black;">
						(B) &nbsp;<input type="radio"
							name="<s:property value="dispaly_vocabulary_test_id"/>"
							id="<s:property value="dispaly_vocabulary_test_id"/>2" value="2">
						&nbsp;
						<s:property value="option2" />
					</div>
					<div class="col-sm-3 contact_info send_message" style="color:black;">
						(C) &nbsp;<input type="radio"
							name="<s:property value="dispaly_vocabulary_test_id"/>"
							id="<s:property value="dispaly_vocabulary_test_id"/>3" value="3">
						&nbsp;
						<s:property value="option3" />
					</div>
					<div class="col-sm-3 contact_info send_message" style="color:black;">
						(D) &nbsp;<input type="radio"
							name="<s:property value="dispaly_vocabulary_test_id"/>"
							id="<s:property value="dispaly_vocabulary_test_id"/>4" value="4">
						&nbsp;
						<s:property value="option4" />
					</div>
					<input type="hidden" name="correct_answer"
						value="<s:property value="correct_answer"/>"
						id="ans<s:property value="dispaly_vocabulary_test_id"/>">
					
				</div>
				<br><br><br><br>
			</s:iterator>
		</div>
		<br>
		<br>
		<s:hidden name="totalMarks" id="totalMarks"></s:hidden>
		<button type="button" style="margin-left:12%;margin-bottom:2%;font-size:15px;font-family:verdana;width:auto;" onclick="getResult();"
			class="btn">Submit Exam</button>
	</form>
</section>




<script type="text/javascript">
    var time = 0;
var running = 0;
function startPause(){
    if(running == 0){
        running = 1;
        increment();
    document.getElementById("start").innerHTML = "Pause";
    document.getElementById("startPause").style.backgroundColor = "red";   
    document.getElementById("startPause").style.borderColor = "red";
    }
    else{
        running = 0;
    document.getElementById("start").innerHTML = "Resume"; 
    document.getElementById("startPause").style.backgroundColor = "green"; 
    document.getElementById("startPause").style.borderColor = "green";
    }
}
function reset(){
    running = 0;
    time = 0;
    document.getElementById("start").innerHTML = "Start";
    document.getElementById("output").innerHTML = "00:00";
    document.getElementById("startPause").style.backgroundColor = "#4CAF50"; 
    document.getElementById("startPause").style.borderColor = "#4CAF50";
}
function increment(){
    if(running == 1){
        setTimeout(function() {
            time++;
            var mins = Math.floor(time/10/60);
            var secs = Math.floor(time/10 % 60);
            var hours = Math.floor(time/10/60/60);
            var tenths = time % 10;
            if(mins < 10){
                mins = "0" + mins;
            }
            if(secs < 10){
                secs = "0" + secs;
            }
            if(mins==01)
        	{
            	document.getElementById("output").innerHTML = "Times up";
            	System.out.println("Times Up");
            	document.getElementById("ans1").disabled=true;
            	document.getElementById("ans2").disabled=true;
            	document.getElementById("ans3").disabled=true;
            	document.getElementById("ans4").disabled=true;
            	document.getElementById("ans5").disabled=true;
        	
        	
        	}
            document.getElementById("output").innerHTML =  mins + ":" + secs;
            increment();
        },100)
      
    }
    
}
</script>
<%@include file="footer.jsp"%>
