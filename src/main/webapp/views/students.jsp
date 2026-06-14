<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="ma.uca.estessaouira.jee.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des etudiants</title>
</head>
<body>
    <h1>Liste des etudiants</h1>
    <p><a href="<%= request.getContextPath() %>/add-student">Ajouter un etudiant</a></p>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
    %>
    <% if (students == null || students.isEmpty()) { %>
        <p>Aucun etudiant.</p>
    <% } else { %>
        <table border="1" cellpadding="8">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Email</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
            <% for (Student s : students) { %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getAge() %></td>
                <td>
                    <a href="<%= request.getContextPath() %>/edit-student?id=<%= s.getId() %>">Modifier</a>
                    |
                    <a href="<%= request.getContextPath() %>/delete-student?id=<%= s.getId() %>">Supprimer</a>
                </td>
            </tr>
            <% } %>
        </table>
    <% } %>
</body>
</html>
