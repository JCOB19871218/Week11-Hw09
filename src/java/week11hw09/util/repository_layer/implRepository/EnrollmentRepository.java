package week11hw09.util.repository_layer.implRepository;

import week11hw09.util.modeling.Enrollment;

import java.sql.*;
import java.util.List;

public interface EnrollmentRepository {

    List<Enrollment> getListEnrollment();

    void findById(int studentId);

    List<Enrollment> getAllEnrollment();

    void creatEnrollment(Enrollment enrollment);

    void readEnrollment(int studentId) throws SQLException;

    void updateStudent(int studentId, double grade);

    void dropStudent(int studentId);


}
