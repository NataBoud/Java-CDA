<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/07/2025
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="catList" type="java.util.ArrayList<com.example.exercice3.model.Cat>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Les Chats</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous" defer></script>
</head>
<body>

<main class="container">
    <h1>Liste de Chats</h1>
    <hr>

    <c:if test="${catList.size() > 0}">
        <table class="table table-dark text-center align-middle">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Race</th>
                <th>Plat favoris</th>
                <th>Date de naissance</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${catList}" >
                <tr>
                    <td>${c.name}</td>
                    <td>${c.breed}</td>
                    <td>${c.favMeal}</td>
                    <td>${c.dateOfBirth}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${catList.size() == 0}">
        <p>Aucun Chat a presenter</p>
    </c:if>


    <hr>

    <h2>Formulaire d'ajout de Chat</h2>

    <form action="${pageContext.request.contextPath}/cat" method="post">
        <div>
            <label for="name">Nom :</label>
            <input type="text" id="name" name="name">
        </div>
        <div>
            <label for="breed">Race :</label>
            <input type="text" id="breed" name="breed">
        </div>
        <div>
            <label for="favMeal">Plat favoris :</label>
            <input type="text" id="favMeal" name="favMeal">
        </div>
        <div>
            <label for="dateOfBirth">Date de Naissance :</label>
            <input type="date" id="dateOfBirth" name="dateOfBirth">
        </div>
        <button>Ajouter</button>
        <button type="reset">Annuler</button>


    </form>


</main>

</body>
</html>
