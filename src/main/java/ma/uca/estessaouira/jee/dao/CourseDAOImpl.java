package ma.uca.estessaouira.jee.dao;

import ma.uca.estessaouira.jee.model.Course;
import ma.uca.estessaouira.jee.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM courses")) {
            while (rs.next()) {
                courses.add(new Course(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("teacher"),
                    rs.getInt("duration")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public void add(Course course) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO courses (title, teacher, duration) VALUES (?, ?, ?)")) {
            ps.setString(1, course.getTitle());
            ps.setString(2, course.getTeacher());
            ps.setInt(3, course.getDuration());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
