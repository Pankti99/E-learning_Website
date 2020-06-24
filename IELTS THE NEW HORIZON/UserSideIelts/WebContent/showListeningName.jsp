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

<section class="banner_area" data-stellar-background-ratio="0.5" style="margin-top:100px; height:200px;">
	<h2 style="padding-top: 3%;">Listening Passage</h2>
	<ol class="breadcrumb" style="margin-bottom: -5%;">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="#" class="active">Listening Passage</a></li>
	</ol>
</section>

<div class="static-table-area">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-6 col-sm-6 col-xs-12">
				<form class="form-inline contact_box"
					action="showListeningPessageName.action" method="post">
					<div class="sparkline8-list">
					<s:property value="message"/>
						<div class="sparkline8-graph">
							<div class="static-table-list">
								<div class="form-group" style="padding-left: 40%;margin-top: 2%;">
									<label style="font-size:16px;">Select Listening Pessage Name</label> <select
										name="paragraph_test_id" class="form-control" id="paragraph_test_id"
										style="width: 50%; margin-bottom: 5%;">
										<option>--Select--</option>
										<s:iterator value="listeningTest">
											<option value="<s:property value="listening_test_id"/>"><s:property
													value="listening_test_name" />
											</option>
										</s:iterator>
									</select>
								</div>
								<div class="form-group" style="padding-left: 42%;">
										<input type="submit" value="Start" class="btn btn-primary waves-effect waves-light">
<%-- 										<s:submit value="Start" cssClass="btn btn-primary waves-effect waves-light"></s:submit> --%>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>