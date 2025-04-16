<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">

</head>
<body>

<h2>Registration Form</h2>
    <form action="RegisterServlet" method="post">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" ><br>
        Password: <input type="password" name="password" required   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" 
        ><br>
        <button type="submit">Register</button>
    </form>


</body>
</html>