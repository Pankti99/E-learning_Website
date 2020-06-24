<%@include file="header.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="icon" href="images/favicon.png" type="image/x-icon" />
<link href="vendors/animate/animate.css" rel="stylesheet">
<link rel="stylesheet" href="vendors/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="vendors/camera-slider/camera.css">
<link rel="stylesheet" type="text/css" href="vendors/owl_carousel/owl.carousel.css" media="all">
	

<!--Theme Styles CSS-->
<link rel="stylesheet" type="text/css" href="css/style.css" media="all" />




<section class="banner_area" data-stellar-background-ratio="0.5" style="margin-top:100px; height:200px;">
	<h2 style="padding-top: 3%;">Writing Passage Exam</h2>
	<ol class="breadcrumb" style="margin-bottom: -5%;">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#" class="active">Writing Passage Exam</a></li>
	</ol>
</section>


				<div class="timer" style="padding-left: 40%;margin-top:1%;">
					<div class="time">
						<p id="output" style="width:15%;color:red;text-align:center;font-size:25px;margin-left:8%;border-radius:10px;height:40px;">0:00:00</p>
					</div>
					<button  id="startPause" onclick="startPause()"  style="width:15%;margin-top:1%;background:hotpink;border-radius:10px;height:40px;font-size:20px;">
						<p id="start"style="color:white;">Start</p>
					</button>
					<button name="reset" id="reset" onclick="reset()"  style="margin-left:1%;width:15%;background:blue;border-radius:10px;height:40px;font-size:20px;">
						<p style="color:white;">Reset</p>
					</button>
				</div>

<section class="all_contact_info">
	<div class="container">
		<div class="row contact_row">
			<div class="col-sm-12 contact_info send_message" style="font-size:20px;">
				<form class="form-inline contact_box"
					action="saveWirttingPessageAns.action" method="post">
					
					<s:hidden name="isMock"></s:hidden>
					<s:hidden name="writting_pessage_id"></s:hidden>
					Enter Your Answer for Subject : <b style="color:green;"><s:property
							value="writting_pessage_name" /></b>
					<textarea rows="10" cols="20" class="form-control input_box"
						style="color: black;" name="writtingPessageAns"></textarea>

					<button type="submit" class="btn" style="width:20%;background:gold;font-size:20px;color:white;">Submit</button>
				</form>
			</div>
		</div>
	</div>
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