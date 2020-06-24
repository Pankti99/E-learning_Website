/*
 * Copyright (c) Ian F. Darwin, http://www.darwinsys.com/, 2002.
 * All rights reserved. Software written by Ian F. Darwin.
 * $Id: ChatServlet.java,v 1.2 2004/02/09 03:34:01 ian Exp $
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *        This product includes software developed by Ian F. Darwin.
 * 4. Neither the name of the author nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * Java, the Duke mascot, and all variants of Sun's Java "steaming coffee
 * cup" logo are trademarks of Sun Microsystems. Sun's, and James Gosling's,
 * pioneering role in inventing and promulgating and standardizing the Java 
 * language and environment is gratefully acknowledged.
 */

package darwinsys.chat;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bean.LoginInfo;
import com.common.connection;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * ChatServlet
 * @author  Ian Darwin
 * @version $Id: ChatServlet.java,v 1.2 2004/02/09 03:34:01 ian Exp $
 */
public class ChatServlet extends HttpServlet implements ChatConstants {

	/** Called in response to a GET request (data encoded in the URL) */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		LoginInfo info = (LoginInfo)session.getAttribute("loginInfo");
		ServletContext application = getServletContext();

		session.setAttribute("isFirst",1);
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;

		ChatState chat = (ChatState)application.getAttribute(APP_STATE);
		// assert(chat != null);

		// to do: logic code and main HTML goes HERE.
		String iSay = request.getParameter("iSay");
		if (iSay != null) {
			iSay = iSay.trim();
			if (iSay.length() != 0) {
				synchronized(chat) {
		
					 conn=connection.getConnection();	
					 String insertSQL = "INSERT INTO tblgroup_chat(user_detail_name, chat_description, created_date) VALUES (?,?,now())";

					 String str = info.getUserName() + " : " + iSay;
					 chat.chat.add(str);
					 
					 try { 
						pstmt = conn.prepareStatement(insertSQL);
						
						pstmt.setString(1,info.getUserName());
						pstmt.setString(2,str);
						
						int rowsAffected = pstmt.executeUpdate();
						System.out.println("Rowsaffected::"+rowsAffected);
					 } catch (SQLException e) {
						e.printStackTrace();
					}

					chat.last++;
					System.out.println("last::"+chat.last);
					 conn=connection.getConnection();	
					String insertSQL1 = "INSERT INTO tblnotification_chat(username,user_detail_id,cnt) VALUES (?,?,?)";
					try
					{
						pstmt1=conn.prepareStatement(insertSQL1);
						pstmt1.setString(1,info.getUserName());
						pstmt1.setInt(2, info.getUser_detail_id());
						pstmt1.setInt(3,0);
						int rowsAffected = pstmt1.executeUpdate();
						System.out.println("Rowsaffected in tbl noti::"+rowsAffected);
					 
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}	
		}

		// Output section in MVC: dispatch to JSP to display the work.
		// (Remember the URL for an RD **MUST** be absolute).
		RequestDispatcher rd = application.getRequestDispatcher("/chat.jsp");
		rd.forward(request, response);
		/*NOTREACHED*/
	}

}