<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cats" type="java.util.ArrayList<com.example.exercice3.models.Cat>" scope="request" />

<html>
<head>
  <title>JSP - Cats</title>
  <jsp:include page="/WEB-INF/bootstrapimports.html" />
</head>
<body class="container mt-5">
<h1 class="mb-4">Cats</h1>
<a href="${pageContext.request.contextPath}/add-cat" class="btn btn-primary mb-4">Ajouter un chat</a>

<c:choose>
  <c:when test="${empty cats}">
    <div class="alert alert-warning">Aucun chat trouvé.</div>
  </c:when>
  <c:otherwise>
    <table class="table table-bordered table-striped">
      <thead class="table-dark">
      <tr>
        <th>Nom</th>
        <th>Race</th>
        <th>Repas préféré</th>
        <th>Date de naissance</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="cat" items="${cats}">
        <tr>
          <td>${cat.name}</td>
          <td>${cat.breed}</td>
          <td>${cat.favoriteMeal}</td>
          <td>${cat.birthDate}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:otherwise>
</c:choose>

</body>
</html>
