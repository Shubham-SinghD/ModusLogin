package com.jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.jsp.entity.Student;

@WebServlet("/listUsers")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Student> userList = new ArrayList<>();

		try (Connection conn = DBconnection.getConnection()) {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM login2");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Student user = new Student();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));

				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("users", userList);
		request.getRequestDispatcher("listUsers.jsp").forward(request, response);
	}
}
