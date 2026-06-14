package ma.uca.estessaouira.jee.dao;

import ma.uca.estessaouira.jee.model.Course;
import java.util.List;

public interface CourseDAO {
    List<Course> findAll();
    void add(Course course);
}
