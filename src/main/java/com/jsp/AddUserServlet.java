package com.jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");

        try (Connection conn = DBconnection.getConnection()) {
            String sql = "INSERT INTO login2 (name, email, age, address) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setInt(3, age);
            pst.setString(4, address);

            int result = pst.executeUpdate();

            if (result > 0) {
                response.getWriter().print("User registered successfully.");
                response.sendRedirect("listUsers");
            } else {
                response.getWriter().print("User registration failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
