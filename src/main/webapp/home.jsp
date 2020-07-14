<%--
  Created by IntelliJ IDEA.
  User: larry
  Date: 7/14/20
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!String firstname = "Larry";%>
<%!String lastname = "Castillo";%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello, <%=firstname%> <%=lastname%></h1>

<form action="/profile.jsp" method="post">
    <button></button>
</form>

<%@ include file="aboutme.jsp"%>

</body>
</html>
