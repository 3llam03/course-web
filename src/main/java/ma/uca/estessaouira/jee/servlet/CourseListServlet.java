package ma.uca.estessaouira.jee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.uca.estessaouira.jee.dao.CourseDAO;
import ma.uca.estessaouira.jee.dao.CourseDAOImpl;
import java.io.IOException;

@WebServlet("/courses")
public class CourseListServlet extends HttpServlet {
    private CourseDAO dao = new CourseDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("courses", dao.findAll());
        request.getRequestDispatcher("/views/courses.jsp")
                .forward(request, response);
    }
}
