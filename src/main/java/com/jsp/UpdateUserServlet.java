package com.jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");

		try (Connection conn = DBconnection.getConnection()) {
			String sql = "UPDATE login2 SET name=?, email=?,  address=? ,id=? WHERE age=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setInt(4, id);
			pst.setInt(5, age);
			pst.setString(3, address);
			

			int result = pst.executeUpdate();

			if (result > 0) {
				response.sendRedirect("listUsers");
			} else {
				response.getWriter().println("Update failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
