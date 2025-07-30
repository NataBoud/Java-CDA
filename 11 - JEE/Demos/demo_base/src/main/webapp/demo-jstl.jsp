<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 28/07/2025
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<c:if test="${not empty nom}" >--%>
<%--  <p>Si j'ai un nom je lui dit bonjour :</p>--%>
<%--<p>Bonjour ${nom} !!! (affiché avec JSTL) </p>--%>
<%--</c:if>--%>


<%--<jsp:include page="WEB-INF/madiv.html" />--%>

<%--<jsp:include page="WEB-INF/composant.jsp" />--%>

<h3>La balise c:if</h3>
<c:if test="${isTrue}">
    <p>La valeur est vrai !!!!!</p>
</c:if>

<c:if test="${isFalse}">
    <p>La valeur est fausse !!!!!</p>
</c:if>

<c:if test="${other}">
    <p>other !!!!!</p>
</c:if>

<h3>La balise c:out</h3>
<p>
    <c:out value="${nameDemo}" />
</p>

<p>
    <c:out value="${name}" default="Au cas ou ... j'ai une valeur par defaut !!!!" />
</p>


<h3>La balise c:foreach</h3>
<c:forEach var="p" items="${prenoms}" >
    <p>- ${p}</p>
</c:forEach>

<h3>Les balises c:choose c:when c:otherwise</h3>

<c:choose>
    <c:when test="${isFalse}">
        <p>La premiere condition est vrai !!!!</p>
    </c:when>
    <c:when test="${isTrue}">
        <p>La seconde condition est vrai !!!!</p>
    </c:when>
    <c:otherwise>
        <p>Aucune des valeurs precedente est vrai !!!</p>
    </c:otherwise>
</c:choose>

</body>
</html>
