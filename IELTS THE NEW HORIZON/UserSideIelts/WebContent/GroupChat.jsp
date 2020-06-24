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

<div class="analytics-sparkle-area">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12"
				style="text-align: center;">
				<div class="analytics-sparkle-line reso-mg-b-30">
					<div class="analytics-content"></div>
				</div>
			</div>

			<form action="submitAnswer.action" method="post">
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"
					style="background-color: #e5e5e5; height: 500px; margin-bottom: 3%;overflow-y: auto;">
					<div class="analytics-sparkle-line reso-mg-b-30">
						<div class="analytics-content"
							style="text-align: center; margin-top: 3%;">
							<h3>Group Chat</h3>
							<hr>
							<div class="form-group">
								<label>Question</label>
								<s:textfield name="group_question" cssClass="form-control"></s:textfield>
							</div>


							<div class="row">
								<div class="col-lg-12">
									<s:submit value="Submit"
										cssClass="btn btn-primary waves-effect waves-light"></s:submit>
								</div>
							</div>

						</div>
					</div>
					<br>
					<br>
					<ul id="myTabedu1" class="tab-review-design">
						<li class="active"><a href="#description">Group Chat</a></li>
					</ul>

					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<s:iterator value="groupChatList">
							<div>
								(Que :
								<s:property value="question_user_detail_name" />
								) &nbsp;
								<s:property value="group_question" />
							</div>
							<div style="margin-top: -4%; text-align: right;">
								<s:property value="question_date" />
							</div>
							<br>
									(Ans : <s:property value="answer_user_detail_name" />) &nbsp; <s:property
								value="group_answer" />
							<br>
							<hr>
						</s:iterator>

					</div>
				</div>
			</form>

			<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12"
				style="text-align: center;">
				<div class="analytics-sparkle-line reso-mg-b-30">
					<div class="analytics-content"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>