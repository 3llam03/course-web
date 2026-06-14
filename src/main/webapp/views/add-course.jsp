<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un cours</title>
</head>
<body>
    <h1>Ajouter un cours</h1>
    <p>
        <a href="<%= request.getContextPath() %>/">Accueil</a> |
        <a href="<%= request.getContextPath() %>/courses">Liste des cours</a>
    </p>
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <%
        }
    %>
    <form action="<%= request.getContextPath() %>/add-course" method="post">
        <p>
            <label>Titre :</label><br>
            <input type="text" name="title">
        </p>
        <p>
            <label>Enseignant :</label><br>
            <input type="text" name="teacher">
        </p>
        <p>
            <label>Duree en heures :</label><br>
            <input type="number" name="duration">
        </p>
        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
