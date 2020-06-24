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

    
<div class="static-table-area" style="margin-top:40px;margin-left:60px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-6 col-sm-6 col-xs-12" style="margin-top: 2%;">
				<div class="sparkline8-list">
					<div class="sparkline8-graph">
						<div class="static-table-list">
							<table class="table">
								<thead>
									<tr style="font-size:20px;color:green;">
										<th>Sr No.</th>
										<th>Writing Topic</th>
										<th>User Name</th>
										<th>Writing Band</th>
										<th>Writing Exam Date</th>
									</tr>
									<s:iterator value="writtingPessageAnswer">
									<tr style="font-size:18px;color:black;">
										<td><s:property value="writting_pessage_answer_id"/> </td>
										<td><s:property value="writting_pessage_name"/></td>
										<td><s:property value="user_detail_name"/></td>
										<td style="padding-left:50px;"><s:property value="writting_pessage_band"/></td>
										<td><s:property value="writting_pessage_date"/></td>
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