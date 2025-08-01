
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patients" type="java.util.List<com.example.exhopital.model.Patient>" scope="request" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hopital</title>
  <%@ include file="/WEB-INF/bootstrapimports.html" %>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<main class="container py-5">
  <div class="row">
    <div class="col-10">
      <div class=" p-4">

        <!-- FORMULAIRE DE RECHERCHE -->
        <form method="get" action="${pageContext.request.contextPath}/patient/search" class="mb-4">
          <div class="mb-3">
            <h2 class="mb-3">Rechercher un patient</h2>
            <input type="text" id="keyword" name="keyword" class="form-control" placeholder="Rechercher par nom ou prénom" />
          </div>
          <button type="submit" class="btn btn-success">Rechercher</button>
        </form>


        <!-- FORMULAIRE DE CRÉATION D’UN PATIENT -->
        <form action="${pageContext.request.contextPath}/patient/add" method="post" enctype="multipart/form-data" class="mb-5 border p-4 rounded bg-light">
          <h2 class="mb-3">Ajouter un patient</h2>

          <!-- Nom -->
          <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
          </div>

          <!-- Prénom -->
          <div class="mb-3">
            <label for="prenom" class="form-label">Prénom</label>
            <input type="text" class="form-control" id="prenom" name="prenom" required>
          </div>

          <!-- Date de naissance -->
          <div class="mb-3">
            <label for="dateNaissance" class="form-label">Date de naissance</label>
            <input type="date" class="form-control" id="dateNaissance" name="dateNaissance" required>
          </div>

          <!-- Upload image -->
          <div class="mb-3">
            <label for="image" class="form-label">Photo du patient</label>
            <input type="file" class="form-control" id="image" name="image" accept="image/*">
          </div>

          <!-- Bouton submit -->
          <div class="text-end">
            <button type="submit" class="btn btn-success">
              <i class="bi bi-plus-circle"></i> Enregistrer
            </button>
          </div>
        </form>

        <h2 class="mb-4">Liste des patients</h2>

        <!-- Si aucun patient -->
        <c:if test="${empty patients}">
          <div class="alert alert-warning text-center">
            Aucun patient n'est encore enregistré.
          </div>
        </c:if>

        <!-- Affichage des patients en cartes -->
        <c:if test="${not empty patients}">
          <div class="row row-cols-1 row-cols-md-2 g-4">
            <c:forEach var="patient" items="${patients}">
              <div class="col">
                <div class="card bg-light h-100">
                  <div class="card-body">
                    <h5 class="card-title">${patient.nom} ${patient.prenom}</h5>
                    <p class="card-text">Date de naissance : ${patient.dateNaissance}</p>
                    <a href="${pageContext.request.contextPath}/patient/details?id=${patient.id}" class="btn btn-outline-secondary">
                      <i class="bi bi-eye"></i> Détails
                    </a>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </c:if>

      </div>
    </div>
  </div>
</main>
</body>
</html>
