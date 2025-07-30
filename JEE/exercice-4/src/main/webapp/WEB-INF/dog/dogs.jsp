<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/07/2025
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/07/2025
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><jsp:useBean id="dogList" type="java.util.ArrayList<com.example.exercice4.model.Dog>" scope="request" />

<html>
<head>
  <title>Dogs</title>
  <jsp:include page="/WEB-INF/bootstrap.html" />
</head>
<body>
<main class="container">
  <h1>Liste de chiens</h1>
  <hr>

  <c:if test="${dogList.size() > 0}">
    <table class="table table-dark text-center align-middle">
      <thead>
      <tr>
        <th>Nom</th>
        <th>Race</th>
        <th>Date de naissance</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="c" items="${dogList}" >
        <tr>
          <td>${c.name}</td>
          <td>${c.breed}</td>
          <td>${c.dateOfBirth}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>

  <c:if test="${dogList.size() == 0}">
    <p>Aucun Chat a presenter</p>
  </c:if>
</main>
</body>
</html>
