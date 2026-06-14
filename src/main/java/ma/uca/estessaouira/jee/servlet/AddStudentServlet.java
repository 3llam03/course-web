package ma.uca.estessaouira.jee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.uca.estessaouira.jee.dao.StudentDAO;
import ma.uca.estessaouira.jee.dao.StudentDAOImpl;
import ma.uca.estessaouira.jee.model.Student;
import java.io.IOException;

@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/add-student.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageText = request.getParameter("age");

        if (name == null || name.isBlank()
                || email == null || email.isBlank()
                || ageText == null || ageText.isBlank()) {
            request.setAttribute("error", "Tous les champs sont obligatoires.");
            request.getRequestDispatcher("/views/add-student.jsp")
                    .forward(request, response);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            request.setAttribute("error", "L'age doit etre un nombre positif.");
            request.getRequestDispatcher("/views/add-student.jsp")
                    .forward(request, response);
            return;
        }

        dao.add(new Student(0, name, email, age));
        response.sendRedirect(request.getContextPath() + "/students");
    }
}
