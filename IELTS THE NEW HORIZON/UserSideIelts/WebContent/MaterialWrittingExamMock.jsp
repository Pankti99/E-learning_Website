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

    
<div class="static-table-area">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-6 col-sm-6 col-xs-12" style="margin-top: 2%;">
				<div class="sparkline8-list">
					<div class="sparkline8-graph">
						<div class="static-table-list">
							<h4 style="text-align: center;"><s:property value="message"/></h4>
							<table class="table">
								<thead>
									<tr>
										<th>Sr No.</th>
										<th>Writing Passage Name</th>
										<th>Action</th>
									</tr>
									<s:iterator value="list">
									<tr>
										<td><s:property value="display_wirtting_pessage_id"/> </td>
										<td><s:property value="wirtting_pessage_name"/></td>
										<td><a href="showWrittingPessage.action?isMock=1&id=<s:property value="wirtting_pessage_id"/>" style="color: black;">Start Exam</a></td>
									</tr>
									</s:iterator>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>