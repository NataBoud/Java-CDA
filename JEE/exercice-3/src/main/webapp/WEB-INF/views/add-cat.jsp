<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ajouter un chat</title>
  <jsp:include page="/WEB-INF/bootstrapimports.html" />
</head>
<body class="container mt-5">
<h1 class="mb-4">Ajouter un chat</h1>

<form action="${pageContext.request.contextPath}/add-cat" method="post">
  <div class="mb-3">
    <label for="name" class="form-label">Nom</label>
    <input type="text" class="form-control" id="name" name="name" required>
  </div>

  <div class="mb-3">
    <label for="breed" class="form-label">Race</label>
    <input type="text" class="form-control" id="breed" name="breed" required>
  </div>

  <div class="mb-3">
    <label for="favoriteMeal" class="form-label">Repas préféré</label>
    <input type="text" class="form-control" id="favoriteMeal" name="favoriteMeal" required>
  </div>

  <div class="mb-3">
    <label for="birthDate" class="form-label">Date de naissance</label>
    <input type="date" class="form-control" id="birthDate" name="birthDate" required>
  </div>

  <button type="submit" class="btn btn-success">Enregistrer</button>
  <a href="${pageContext.request.contextPath}/cats" class="btn btn-secondary">Annuler</a>
</form>
</body>
</html>
