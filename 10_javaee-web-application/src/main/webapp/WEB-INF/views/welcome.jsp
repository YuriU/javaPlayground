<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Yahoo!!!! From JSP</title>
</head>
<body>
    Welcome ${name} Password: ${password}
    <%
        Date date = new Date();
    %>
    <div>Current date is <%=date%></div>
</body>
</html>