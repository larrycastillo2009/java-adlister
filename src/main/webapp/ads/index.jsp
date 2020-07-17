<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View ads</title>
</head>
<body>
<h1>Here are all the products:</h1>

<c:forEach var="ads" items="${ads}">
    <div>
        <h2>${ads.title}</h2>
        <p>Description: ${ads.description}</p>
    </div>
</c:forEach>

</body>
</html>
