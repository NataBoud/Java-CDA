<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="background-color: #f8f9fa; padding: 20px; margin-bottom: 20px;">
  <h1>Bienvenue dans l'Hopital</h1>
  <div style="margin-top: 10px;">
    <a href="${pageContext.request.contextPath}/hello-servlet" class="" style="margin-right: 10px;">
      Accueil
    </a>
    <a href="${pageContext.request.contextPath}/patient/list" class="">
      Liste des patients
    </a>
  </div>
</div>
