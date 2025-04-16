package com.jsp;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServalet
 */
@WebServlet("/loginservlet")
public class LoginServalet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String sql="select * from login1 where email=? and password=?";
		Connection conn=null;
		
		try {
			conn=DBconnection.getConnection();
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				HttpSession hs=request.getSession();
				hs.setAttribute("name", name);
				response.sendRedirect("welcome.jsp");
			}else {
				response.getWriter().print("Invalid login Detail");
				response.sendRedirect("Register.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
