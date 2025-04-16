<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.jsp.entity.Student" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Users</title>
</head>
<body>

<h2>All Registered Users</h2>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Address</th>
        <th>Actions</th>
    </tr>

<%
    List<Student> users = (List<Student>) request.getAttribute("users");
    for (Student user : users) {
%>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getAge() %></td>
        <td><%= user.getAddress() %></td>
        <td>
            <a href="editUser?age=<%= user.getAge() %>">Edit</a> |
            <a href="deleteUser?id=<%= user.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>
        </td>
    </tr>
<% } %>
</table>

<br><a href="addUser.jsp">Add New User</a>

</body>
</html>
