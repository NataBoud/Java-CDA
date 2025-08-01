<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patient" type="com.example.exhopital.model.Patient" scope="request" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Détails du patient</title>
  <%@ include file="/WEB-INF/bootstrapimports.html" %>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<main class="container py-5">
  <div class="row">
    <div class="col-8 offset-2">
      <div class="card shadow">
        <div class="row g-0">
          <div class="col-md-4 text-center p-3">
            <!-- Affichage de la photo si disponible -->
            <c:choose>
              <c:when test="${not empty patient.photo}">
                <img src="${pageContext.request.contextPath}/images/${patient.photo}"
                     alt="Photo de ${patient.nom}" class="img-fluid rounded shadow-sm" />
              </c:when>
              <c:otherwise>
                <img src="${pageContext.request.contextPath}/images/default-avatar.png"
                     alt="Pas de photo" class="img-fluid rounded shadow-sm" />
              </c:otherwise>
            </c:choose>
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <h3 class="card-title">${patient.nom} ${patient.prenom}</h3>
              <p class="card-text"><strong>Date de naissance :</strong> ${patient.dateNaissance}</p>

              <div class="mt-4">
                <a href="${pageContext.request.contextPath}/patient/list" class="btn btn-secondary">
                  <i class="bi bi-arrow-left"></i> Retour à la liste
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</main>
</body>
</html>
