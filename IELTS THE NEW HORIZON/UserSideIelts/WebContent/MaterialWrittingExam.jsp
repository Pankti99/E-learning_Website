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

    
<div class="static-table-area" style="margin-left:20px;margin-top:30px;">
	<div class="container-fluid">
		<div class="row" style="margin-top: 2%;">
			<div class="col-lg-12 col-md-6 col-sm-6 col-xs-12">
				<div class="sparkline8-list">
					<div class="sparkline8-graph">
						<div class="static-table-list">
							<table class="table">
								<thead>
									<tr style="font-size:20px;color:green;">
										<th style="padding-left:60px;">Sr No.</th>
										<th style="padding-left:400px;">Writing Passage Name</th>
										<th>Action</th>
									</tr>
									<s:iterator value="list">
									<tr style="font-size:18px;color:black;">
										<td style="padding-left:60px;"><s:property value="display_wirtting_pessage_id"/> </td>
										<td style="padding-left:400px;"><s:property value="wirtting_pessage_name"/></td>
										<td><a href="showWrittingPessage.action?id=<s:property value="wirtting_pessage_id"/>" style="color: black;">Start Exam</a></td>
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