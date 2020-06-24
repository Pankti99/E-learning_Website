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
		if(document.getElementById("password").value == ""){
			document.getElementById("passError").style = "display:block";
			document.getElementById("passError").style = "color:red";
			temp = false;	
		}
		
		if(temp == true){
			document.getElementById("loginFormId").submit();
		}
	}
	</script>
    <section class="banner_area" data-stellar-background-ratio="0.5" style="margin-top: 2%;">
        <h2>Login</h2>
        <ol class="breadcrumb">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#" class="active">Login</a></li>
        </ol>
    </section>

    <section class="all_contact_info">
        <div class="container">
            <div class="row contact_row" style="margin-top: -7%;">
                <div class="col-sm-3 contact_info send_message">
            	</div>
                <div class="col-sm-6 contact_info send_message">
                    <h2>Login</h2>
                    <form class="form-inline contact_box" id="loginFormId" action="loginAsUser.action" method="post" style="color:pink;">
                        <span id="userError" style="display:none;">* This Field is Required.</span>
                        <input type="text" class="form-control input_box" style="color: black;" placeholder="Enter User Name" name="userName" id="userName">
                        <span id="passError" style="display:none;">* This Field is Required.</span>
                     	<input type="password" class="form-control input_box" style="color: black;" placeholder="Enter Password" name="password" id="password">
                        <br><input type="button" value="Login" onclick="checkValidation();" class="btn btn-default" style="width: 35%;"/>
                        &nbsp;&nbsp;&nbsp;<a href="ForgotPassword.jsp" style="color: blue;">Forgot Password?</a> 
                        
                    </form>
                </div>
                <div class="col-sm-3 contact_info send_message">
            	</div>
            </div>
        </div>
    </section>


<%@include file="footer.jsp"%>