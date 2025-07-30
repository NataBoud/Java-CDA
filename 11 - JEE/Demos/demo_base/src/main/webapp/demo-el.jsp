<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 28/07/2025
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Bonjour ${nom} !!!! (affiché avec EL)</p>

<jsp:include page="WEB-INF/madiv.html" />

<jsp:include page="WEB-INF/composant.jsp" />

</body>
</html>
