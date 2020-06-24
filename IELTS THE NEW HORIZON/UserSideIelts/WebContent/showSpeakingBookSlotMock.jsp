<%@include file="header.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<link href="datePicker/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">

<!--Theme Styles CSS-->
<link rel="stylesheet" type="text/css" href="css/style.css" media="all" />


<div class="static-table-area">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-6 col-sm-6 col-xs-12">
				<form class="form-inline contact_box"
					action="bookSlotForSpeaking.action" method="post">
					<div class="sparkline8-list">
					<s:property value="message"/>
						<div class="sparkline8-graph">
							<div class="static-table-list">
								<div class="form-group" style="padding-left: 170px;;margin-top: 2%;">
									<label>Select Speaking Topic Name</label> <select
										name="speaking_test_id" class="form-control" id="speaking_test_id"
										style="width: 50%; margin-bottom: 5%;">
										<option>--Select--</option>
										<s:iterator value="listeningTest">
											<option value="<s:property value="listening_test_id"/>"><s:property
													value="listening_test_name" />
											</option>
										</s:iterator>
									</select>
								</div>
								
								
								<div class="form-group-inner">
										<label for="dtp_input2" class="col col-md-1 control-label"
											style="margin-left: 154px; width: 20%; vertical-align: text-top;">
											Speaking Book Date</label>
										<div class="input-group date form_datetime col-md-10" data-date=""
											data-date-format="dd-mm-yyyy hh:ii" data-link-field="dtp_input2"
											data-link-format="yyyy-mm-dd"
											style="width: 825px; margin-left: 362px;margin-top: -5%;margin-bottom: -2%;">
											<input type="text" class="form-control" style="width:34%;" size="16" id="spekingDate"
												name="spekingDate" value="">
											<span class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span></span> 
										</div>
									</div>
								
								
								
								<div class="form-group" style="padding-left: 40%; margin-bottom: 1%; margin-top: 1%;">
										<input type="submit" value="Book Slot" class="btn btn-primary waves-effect waves-light">
<%-- 										<s:submit value="Book Slot" cssClass="btn btn-primary waves-effect waves-light"></s:submit> --%>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="datePicker/jquery-1.8.3.min.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="datePicker/bootstrap.min.js"></script>
<script type="text/javascript"
	src="datePicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript"
	src="datePicker/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">
	$('.form_datetime').datetimepicker({
		//language:  'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1
	});
	$('.form_date').datetimepicker({
		//language : 'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});
	$('.form_time').datetimepicker({
		//language : 'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 1,
		minView : 0,
		maxView : 1,
		forceParse : 0
	});
</script>

<%@include file="footer.jsp"%>