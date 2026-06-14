<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="ma.uca.estessaouira.jee.model.Course" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des cours</title>
</head>
<body>
    <h1>Liste des cours</h1>
    <p>
        <a href="<%= request.getContextPath() %>/">Accueil</a> |
        <a href="<%= request.getContextPath() %>/add-course">Ajouter un cours</a>
    </p>
    <%
        List<Course> courses = (List<Course>) request.getAttribute("courses");
    %>
    <% if (courses == null || courses.isEmpty()) { %>
        <p>Aucun cours disponible.</p>
    <% } else { %>
        <table border="1" cellpadding="8">
            <tr>
                <th>ID</th>
                <th>Titre</th>
                <th>Enseignant</th>
                <th>Duree</th>
            </tr>
            <% for (Course course : courses) { %>
                <tr>
                    <td><%= course.getId() %></td>
                    <td><%= course.getTitle() %></td>
                    <td><%= course.getTeacher() %></td>
                    <td><%= course.getDuration() %> h</td>
                </tr>
            <% } %>
        </table>
    <% } %>
</body>
</html>
