<%@include file="header.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
    <link rel="icon" href="images/favicon.png" type="image/x-icon" />
    <link href="vendors/animate/animate.css" rel="stylesheet">
	<link rel="stylesheet" href="vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendors/camera-slider/camera.css">
	<link rel="stylesheet" type="text/css" href="vendors/owl_carousel/owl.carousel.css" media="all">

    <!--Theme Styles CSS-->
	<link rel="stylesheet" type="text/css" href="css/style.css" media="all" />
   	<script>
	function checkValidation(){
		var temp = true;
		if(document.getElementById("userName").value == ""){
			document.getElementById("userError").style = "display:block";
			document.getElementById("userError").style = "color:red";
			temp = false;	
		}
		if(temp == true){
			document.getElementById("loginFormId").submit();
		}
	}
	</script>
 
    <section class="banner_area" data-stellar-background-ratio="0.5">
        <h2>Forgot User Name</h2>
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li><a href="#" class="active">Forgot User Name</a></li>
        </ol>
    </section>

    <section class="all_contact_info">
        <div class="container">
            <div class="row contact_row" style="margin-top: -7%;">
                <div class="col-sm-3 contact_info send_message">
            	</div>
                <div class="col-sm-6 contact_info send_message">
                    <h2>Forgot User Name</h2>
                    <s:property value="message"/><br>
                    <form class="form-inline contact_box" id="loginFormId" action="ForgotUsername.action" method="post">
   						<span id="userError" style="display:none;">* This Field is Required.</span>
                        <input type="text" class="form-control input_box" style="color: black;" placeholder="Enter Mobie Number" name="userName" id="userName">
                        <br><input type="button" onclick="checkValidation();" value="Get User Name" class="btn btn-default" style="width: 35%;"/>
                    </form>
                </div>
                <div class="col-sm-3 contact_info send_message">
            	</div>
            </div>
        </div>
    </section>


<%@include file="footer.jsp"%>