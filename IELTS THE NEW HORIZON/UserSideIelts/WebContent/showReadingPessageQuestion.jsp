<%@include file="header.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="icon" href="images/favicon.png" type="image/x-icon" />
<link href="vendors/animate/animate.css" rel="stylesheet">
<link rel="stylesheet"
	href="vendors/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="vendors/camera-slider/camera.css">
<link rel="stylesheet" type="text/css"
	href="vendors/owl_carousel/owl.carousel.css" media="all">

<!--Theme Styles CSS-->
<link rel="stylesheet" type="text/css" href="css/style.css" media="all" />


<script>
	function getTotalMarks() {
		var marks = 0;
		for (var i = 1; i < 6; i++) {
			var ans = document.getElementById("ans" + i).value;
			for (var j = 1; j < 6; j++) {
				var sans = document.getElementById("que" + j).value;
				if (ans == sans) {
					marks = marks + 1;
				}
			}
		}
		document.getElementById("totalMarks").value = marks;
		document.getElementById("saveReadingExamResult").submit();
	}
</script>

<section class="banner_area" data-stellar-background-ratio="0.5" style="margin-top:80px; height:200px;">
	<h2 style="padding-top: 3%;">Reading Passage Exam</h2>
	<ol class="breadcrumb" style="margin-bottom: -5%;">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#" class="active">Reading Passage Exam</a></li>
	</ol>
</section>


<div class="row">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="review-content-section">
			<div id="dropzone1" class="pro-ad" style="padding-top: 2%;">
				<h3 style="padding-left: 45%;">
					<p style="font-family:verdana;"><s:property value="paragraph_test_name" /></p>
				</h3>

				
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
				

				<form action="saveReadingExamResult.action"
					name="saveReadingExamResult" id="saveReadingExamResult">
					<s:hidden name="paragraph_test_id"></s:hidden>
					<div class="row" style="margin-top: 3%; margin-left: 3%;">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"
							style="text-align: justify;font-size:18px;border-right:2px solid black;">
							<s:iterator value="readingPesssagesList">
								<div class="form-group">
									<span><s:property value="reading_pessage" /></span><br> <br>
								</div>
							</s:iterator>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<s:iterator value="readingPessageExamsList">
								<div class="form-group" style="font-size:18px;">
									<span style="color:green;">Question : <s:property
											value="display_reading_pessage_exam_id" /> &nbsp;&nbsp;<s:property
											value="paragraph_test_que" /></span><br><br> <span style="color:red;">Answer : <s:property
											value="display_reading_pessage_exam_id" /> &nbsp; <input
										type="text"
										id="que<s:property value="display_reading_pessage_exam_id"/>"
										name="que<s:property value="display_reading_pessage_exam_id"/>" />
										<input type="hidden"
										id="ans<s:property value="display_reading_pessage_exam_id"/>"
										value="<s:property value="paragraph_test_ans"/>"
										name="ans<s:property value="display_reading_pessage_exam_id"/>" />
									</span><br> <br>
								</div>
							</s:iterator>
						</div>

						<input type="hidden" name="totalMarks" id="totalMarks"> <input
							type="submit" class="btn btn-default" onclick="getTotalMarks();"
							value="Submit">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>



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