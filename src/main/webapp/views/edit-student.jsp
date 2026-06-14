<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="ma.uca.estessaouira.jee.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un etudiant</title>
</head>
<body>
    <h1>Modifier un etudiant</h1>
    <p><a href="<%= request.getContextPath() %>/students">Liste des etudiants</a></p>
    <%
        Student student = (Student) request.getAttribute("student");
    %>
    <form action="<%= request.getContextPath() %>/edit-student" method="post">
        <input type="hidden" name="id" value="<%= student.getId() %>">
        <p>
            <label>Nom :</label><br>
            <input type="text" name="name" value="<%= student.getName() %>">
        </p>
        <p>
            <label>Email :</label><br>
            <input type="text" name="email" value="<%= student.getEmail() %>">
        </p>
        <p>
            <label>Age :</label><br>
            <input type="number" name="age" value="<%= student.getAge() %>">
        </p>
        <button type="submit">Modifier</button>
    </form>
</body>
</html>
