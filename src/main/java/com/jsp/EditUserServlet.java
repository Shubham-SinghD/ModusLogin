package com.jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

import com.jsp.entity.Student;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("age"));

		try (Connection conn = DBconnection.getConnection()) {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM login2 WHERE age = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Student user = new Student();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));

				request.setAttribute("user", user);
				request.getRequestDispatcher("editUser.jsp").forward(request, response);
			} else {
				response.getWriter().println("User not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
