
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.common.connection"%>
<%@page import="darwinsys.chat.ChatConstants"%>
<%@page import="darwinsys.chat.ChatState"%>

<%@ include file="header.jsp"%>



<link rel="stylesheet" type="text/css" href="assets/css/stylesheet.css" media="all" />


<body>
<div class="chat1">
<div style="color:black;width:50%;margin-left:20%;">
<p  class="grp">Group Chat</p>
<form action="ChatServlet" name="ChatDemo" id="ChatDemo" method="post">
<p style="padding-left:2%;text-align:center;margin-top:8%;margin-left:20%;">
<!-- Set rows to 13 but only print 10, needed on some browsers -->
<textarea name="chat" disabled id="chat" rows="13" cols="67" style="border:5px solid #FFDAB9;background:white;">
<%
	// Set the content of the textArea to the history.
	ChatState chat = (ChatState)application.getAttribute(ChatConstants.APP_STATE);
	// assert(chat != null);
		if(null == session.getAttribute("isFirst")){
		Connection conn=connection.getConnection();	
		PreparedStatement pstmt=null;
		ResultSet rs = null;

		if(conn!=null){
			 String selectSQL = "Select * from tblgroup_chat";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
				rs = pstmt.executeQuery();
				while(rs.next()){
					out.println(rs.getString("chat_description"));
					
				}
				
				
			 } catch (Exception e) {
				e.printStackTrace();
			}
		 }
		} else {

			Connection conn=connection.getConnection();	
			PreparedStatement pstmt=null;
			ResultSet rs = null;

			if(conn!=null){
				 String selectSQL = "Select * from tblgroup_chat";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
					rs = pstmt.executeQuery();
					while(rs.next()){
						out.println(rs.getString("chat_description"));
					}
					
					
				 } catch (Exception e) {
					e.printStackTrace();
				}
			 }
			
		}
	
/* 	int start = Math.max(chat.first, chat.last-10);
	for (int i=start; i<chat.last; i++) {
		out.println(chat.chat.get(i));
	}
 */ %>
</textarea>
</div>
<br/>
</p>
<p style="padding-left:33%;color:white;font-size:17px;margin-top:40px;font-weight:50px;"><b>Type a message</b>	<input type="text" name="iSay" size="30" placeholder="   Start Typing..."style="border:3px solid 	#FFDAB9;margin-left:1%;color:black;"/></p>
<br/>
</form>
</div>
</body>
</html>
<%@include file="footer.jsp"%>
