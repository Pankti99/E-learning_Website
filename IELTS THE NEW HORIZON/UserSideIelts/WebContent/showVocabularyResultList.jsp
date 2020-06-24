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

    <section class="banner_area"style="margin-top:50px; height:200px;" data-stellar-background-ratio="0.5">
        <h2 style="padding-top:0%;">Vocabulary Result</h2>
        <ol class="breadcrumb" style="margin-bottom: -5%;">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#" class="active">Vocabulary Result</a></li>
        </ol>
    </section>
    
    
<div class="static-table-area" style="margin-top:40px;margin-left:60px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-6 col-sm-6 col-xs-12">
				<div class="sparkline8-list">
					<div class="sparkline8-graph">
						<div class="static-table-list">
							<table class="table">
								<thead>
									<tr style="font-size:20px;color:green;">
										<th>Sr No.</th>
										<th>User Name</th>
										<th>Total Marks</th>
										<th>Exam Date</th>
									</tr>
									<s:iterator value="vocabularyResults">
									<tr style="font-size:18px;color:black;">
										<td><s:property value="display_vocabulary_result_id"/> </td>
										<td><s:property value="user_detail_name"/></td>
										<td style="padding-left:50px;"><s:property value="total_marks"/></td>
										<td><s:property value="exam_result_date"/></td>
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