package com.jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String sql="insert into login1 values (?,?,?)";
		
		Connection conn=null;
		
		
		try {
			conn=DBconnection.getConnection();
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, password);
			int rs = pst.executeUpdate();
			if(rs>0) {
				response.sendRedirect("login.jsp");
			}else {
				response.getWriter().print("Invalid Crediant");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
