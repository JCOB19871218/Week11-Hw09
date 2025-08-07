package week11hw09.util.repository_layer.implRepository;

import week11hw09.util.modeling.Student;

import java.util.List;

public interface StudentRepository {


    List<Student> seedStudent();

    void creatStudent(Student student);

    void readStudent(int studentId);

    void updateStudent(int studentId, double gpa);

    void dropStudent(int studentId);

    int findById(String name);

    List<Student> getAllStudent();

    void creatTable();

    void dropTable();

}
