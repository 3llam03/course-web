<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un etudiant</title>
</head>
<body>
    <h1>Ajouter un etudiant</h1>
    <p><a href="<%= request.getContextPath() %>/students">Liste des etudiants</a></p>
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <%
        }
    %>
    <form action="<%= request.getContextPath() %>/add-student" method="post">
        <p>
            <label>Nom :</label><br>
            <input type="text" name="name">
        </p>
        <p>
            <label>Email :</label><br>
            <input type="text" name="email">
        </p>
        <p>
            <label>Age :</label><br>
            <input type="number" name="age">
        </p>
        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
