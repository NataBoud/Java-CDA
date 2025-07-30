<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 29/07/2025
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire</title>
</head>
<body>
<h1>Formulaire</h1>

<form action="form" method="post">
  <div>
    <label for="firstname">Firstname :</label>
    <input type="text" id="firstname" name="firstname">
  </div>
  <div>
    <label for="lastname">Lastname :</label>
    <input type="text" id="lastname" name="lastname">
  </div>
  <div>
    <label for="age">Age :</label>
    <input type="number" id="age" name="age">
  </div>
  <button>Ajouter</button>
  <button type="reset">Annuler</button>


</form>
</body>
</html>
