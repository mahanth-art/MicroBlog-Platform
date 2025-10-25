
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Register</title></head>
<body>
<h2>Register</h2>
<form action="register" method="post">
    Username: <input name="username" required /><br/>
    Email: <input name="email" type="email" /><br/>
    Password: <input name="password" type="password" required /><br/>
    <button type="submit">Register</button>
</form>
<p><a href="login.jsp">Already have an account? Login</a></p>
</body>
</html>
