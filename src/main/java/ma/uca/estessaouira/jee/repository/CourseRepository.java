package ma.uca.estessaouira.jee.repository;

import ma.uca.estessaouira.jee.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private static final List<Course> courses = new ArrayList<>();
    private static int nextId = 1;

    static {
        add("Java OOP", "M. Erraji", 12);
        add("Servlet et JSP", "M. Erraji", 9);
    }

    public static List<Course> findAll() {
        return courses;
    }

    public static Course add(String title, String teacher, int duration) {
        Course course = new Course(nextId++, title, teacher, duration);
        courses.add(course);
        return course;
    }
}
