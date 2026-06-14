package ma.uca.estessaouira.jee.dao;

import ma.uca.estessaouira.jee.model.Student;
import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    Student findById(int id);
    void add(Student student);
    void update(Student student);
    void delete(int id);
}
