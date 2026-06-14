package ma.uca.estessaouira.jee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.uca.estessaouira.jee.dao.StudentDAO;
import ma.uca.estessaouira.jee.dao.StudentDAOImpl;
import java.io.IOException;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("students", dao.findAll());
        request.getRequestDispatcher("/views/students.jsp")
                .forward(request, response);
    }
}
