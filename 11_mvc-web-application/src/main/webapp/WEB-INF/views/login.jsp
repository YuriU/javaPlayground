<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Yahoo!!!! From JSP</title>
</head>
<body>
    Hello from JSP!!! ${name}
    <%
        Date date = new Date();
    %>
    <div>Current date is <%=date%></div>
    <form action="/login" method="post">
        <p><font color="red">${errorMessage}</font></p>
        Enter your name <input type="text" name="name" />
        Password: <input type="password" name="password" />
        <input type="submit" name="Login">
    </form>
</body>
</html>