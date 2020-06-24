<%@include file="header.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
    <link rel="icon" href="images/favicon.png" type="image/x-icon" />
    <link href="vendors/animate/animate.css" rel="stylesheet">
	<link rel="stylesheet" href="vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendors/camera-slider/camera.css">
	<link rel="stylesheet" type="text/css" href="vendors/owl_carousel/owl.carousel.css" media="all">

    <!--Theme Styles CSS-->
	<link rel="stylesheet" type="text/css" href="css/style.css" media="all" />

    <section class="banner_area" data-stellar-background-ratio="0.5" style="margin-top: 2%;">
        <h2>Contact Us</h2>
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li><a href="#" class="active">Contact Us</a></li>
        </ol>
    </section>

    <section class="all_contact_info">
        <div class="container">
            <div class="row contact_row">
                <div class="col-sm-6 contact_info">
                    <h2>Contact Info</h2>
                    <p>
JEC is a coaching class. JEC's motto is Result Oriented Quality Education. We understand that to get the best result we need to prepare the environment for students giving them various facilities. 
The Expert Faculties have the core knowledge of every subject. We coach for the IELTS, OET, ACT, SAT, PSAT, TOEFL, PTE, GRE, GMAT, CMAT, CAT. PERSONALITY DEVELOPMENT is free for all the students.
</p>
<p>Library facility is essential for students to concentrate on gaining knowledge on a subject.  Homely atmosphere plays a significant role in preparing for a test in a relaxed mood to get a great result. On the other hand, specific stress is also necessary to understand the seriousness of the test.</p> 

                  
                    <div class="location">
                        <div class="location_laft">
                            <a class="f_location">location</a>
                            <a>phone</a>
                            <a> email</a>
                        </div>
                        <div class="address">
                            <a>
                            	Jeremy Education Center <br> 
                            	307,3rd Eye Vision, <br>
                            	Above NEXA, IIM Road, Panjrapol, <br>
				     	 		Ahmedabad-15, Gujarat.<br> 
				     	 	</a>
                            
                            <a>9601421347</a>
                            <a>info@jeremyeducation.com</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 contact_info send_message">
                    <h2>Send Us a Message</h2>
                    <form class="form-inline contact_box" action="saveContactUs.action" method="post">
                        <input type="text" class="form-control input_box" style="color: black;" placeholder="Enter Full Name" name="contact_us_detail_name">
                        <input type="text" class="form-control input_box" style="color: black;" placeholder="Enter Email Id" name="contact_us_detail_email">
                        <input type="text" class="form-control input_box" style="color: black;" placeholder="Enter Subject" name="contact_us_detail_subject">
                        <textarea class="form-control input_box" style="color: black;" placeholder="Enter Message" name="contact_us_detail_message"></textarea>
                        
                        <button type="submit" class="btn" style="width:45%;background:gold;color:white;font-size:20px;text-align:center;">Send Message</button>
                    </form>
                </div>
            </div>
        </div>
    </section>


<%@include file="footer.jsp"%>