<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
</head>
<body>
    <h1>Mini site JEE</h1>
    <h2>Gestion des cours</h2>
    <ul>
        <li><a href="<%= request.getContextPath() %>/courses">Voir les cours</a></li>
        <li><a href="<%= request.getContextPath() %>/add-course">Ajouter un cours</a></li>
    </ul>
    <h2>Gestion des etudiants</h2>
    <ul>
        <li><a href="<%= request.getContextPath() %>/students">Voir les etudiants</a></li>
        <li><a href="<%= request.getContextPath() %>/add-student">Ajouter un etudiant</a></li>
    </ul>
</body>
</html>
