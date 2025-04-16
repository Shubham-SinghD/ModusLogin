<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jsp.entity.Student" %>
<%
    Student user = (Student) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h2>Edit User</h2>
    <form action="updateUser" method="post">
        <input type="hidden" name="id" value="<%= user.getId() %>">
        Name: <input type="text" name="name" value="<%= user.getName() %>" required><br><br>
        Email: <input type="email" name="email" value="<%= user.getEmail() %>" required><br><br>
        Age: <input type="number" name="age" value="<%= user.getAge() %>" required><br><br>
        Address: <input type="text" name="address" value="<%= user.getAddress() %>" required><br><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
