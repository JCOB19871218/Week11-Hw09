package week11hw09.util.db;

import week11hw09.util.repository_layer.CourseRepositoryImpl;
import week11hw09.util.repository_layer.EnrollmentRepositoryImpl;
import week11hw09.util.repository_layer.StudentRepositoryImpl;
import week11hw09.util.repository_layer.implRepository.CourseRepository;
import week11hw09.util.repository_layer.implRepository.EnrollmentRepository;
import week11hw09.util.repository_layer.implRepository.StudentRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDrop {
    public static void dropTableStudent() {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        studentRepository.dropTable();
    }

    public static void dropTableCourse() {
        CourseRepository courseRepository = new CourseRepositoryImpl();
        courseRepository.dropTable();
    }

    public static void dropTableEnrollment() {
        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryImpl();
        enrollmentRepository.dropTable();
    }

}
