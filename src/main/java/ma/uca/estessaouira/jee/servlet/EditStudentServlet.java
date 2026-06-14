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

@WebServlet("/edit-student")
public class EditStudentServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = dao.findById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/views/edit-student.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        dao.update(new Student(id, name, email, age));
        response.sendRedirect(request.getContextPath() + "/students");
    }
}
