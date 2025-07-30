<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/07/2025
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dogs</title>
    <jsp:include page="/WEB-INF/bootstrap.html" />
</head>
<body>
<main class="container">
    <h1>Liste de Chiens</h1>
    <hr>

    <form action="${pageContext.request.contextPath}/dogs" method="post">
        <div>
            <label for="name">Nom :</label>
            <input type="text" id="name" name="name">
        </div>
        <div>
            <label for="breed">Race :</label>
            <input type="text" id="breed" name="breed">
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
