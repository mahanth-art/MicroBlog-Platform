
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Login</title></head>
<body>
<h2>Login</h2>
<form action="login" method="post">
    Username: <input name="username" required /><br/>
    Password: <input name="password" type="password" required /><br/>
    <button type="submit">Login</button>
</form>
<p><a href="register.jsp">Create an account</a></p>
</body>
</html>
