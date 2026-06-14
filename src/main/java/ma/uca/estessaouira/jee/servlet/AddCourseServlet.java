package ma.uca.estessaouira.jee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.uca.estessaouira.jee.dao.CourseDAO;
import ma.uca.estessaouira.jee.dao.CourseDAOImpl;
import ma.uca.estessaouira.jee.model.Course;
import java.io.IOException;

@WebServlet("/add-course")
public class AddCourseServlet extends HttpServlet {
    private CourseDAO dao = new CourseDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/add-course.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String teacher = request.getParameter("teacher");
        String durationText = request.getParameter("duration");

        if (title == null || title.isBlank()
                || teacher == null || teacher.isBlank()
                || durationText == null || durationText.isBlank()) {
            request.setAttribute("error", "Tous les champs sont obligatoires.");
            request.getRequestDispatcher("/views/add-course.jsp")
                    .forward(request, response);
            return;
        }

        int duration;
        try {
            duration = Integer.parseInt(durationText);
            if (duration <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            request.setAttribute("error", "La duree doit etre un nombre positif.");
            request.getRequestDispatcher("/views/add-course.jsp")
                    .forward(request, response);
            return;
        }

        dao.add(new Course(0, title, teacher, duration));
        response.sendRedirect(request.getContextPath() + "/courses");
    }
}
