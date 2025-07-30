<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 28/07/2025
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="lenom" type="java.lang.String" scope="request" />
<jsp:useBean id="prenoms" type="java.util.ArrayList<java.lang.String>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Recuperation et affichage variables avec Scriplet


<p>
 Le nom transmis est : <%= lenom %>
</p>

<p>
    Le prenom transmis est ${leprenom}
</p>

Boucle foreach avec scriplet

<% for ( String p: prenoms) { %>
    <p><%= p %><p>
    <p><%= new Date() %><p>
    <p><%= p.toUpperCase() %><p>

 <% } %>

<%--<%@include file="WEB-INF/madiv.html"%>--%>

</body>
</html>
