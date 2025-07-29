<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 29/07/2025
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="personnes" type="java.util.ArrayList<com.example.exercice2.models.Personne>" scope="request" />
<html>
<head>
    <title>Title</title>
    <jsp:include page="/WEB-INF/bootstrapimports.html" />
</head>
<body class="container mt-5">
<h2 class="mb-4">Liste des personnes</h2>

<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Âge</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${personnes}">
        <tr>
            <td>${p.nom}</td>
            <td>${p.prenom}</td>
            <td>${p.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
