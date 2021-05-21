<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<p><a href="index.jsp">Home</a></p>

<h2>Users list</h2>

<c:forEach items="${model}" var="user">
User <a href ='showUser?name=${user.name}'>${user.name}</a>, email: ${user.email}<p>
</c:forEach>

</body>
</html>
