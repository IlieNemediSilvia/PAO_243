<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<p><a href="index.jsp">Home</a></p>
<a href ="users">Go back to user list</a>

<h2>Hello ${model.name}, your email address is ${model.email} </h2>

<h3>Contacts</h3>
<c:forEach items="${model.contacts}" var="name">
<a href='showUser?name=${name}'>${name}</a><p>
</c:forEach>

</body>
</html>
