
<%--
  Created by IntelliJ IDEA.
  User: astah
  Date: 08.03.2024
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Меню</title>
</head>
<body>
<h1>Name: <%=request.getAttribute("userName")%></h1>
<h3>Age: <%=request.getAttribute("userAge")%></h3>
<h3>Email: <%=request.getAttribute("userEmail")%></h3>
<h3>Login: <%=request.getAttribute("userLogin")%></h3>
<h3>Password: <%=request.getAttribute("userPassword")%></h3>
</body>
</html>
