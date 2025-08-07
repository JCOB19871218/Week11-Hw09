package week11hw09.util.db;

import week11hw09.util.db.DBUtil;
import week11hw09.util.repository_layer.CourseRepositoryImpl;
import week11hw09.util.repository_layer.EnrollmentRepositoryImpl;
import week11hw09.util.repository_layer.StudentRepositoryImpl;
import week11hw09.util.repository_layer.implRepository.CourseRepository;
import week11hw09.util.repository_layer.implRepository.EnrollmentRepository;
import week11hw09.util.repository_layer.implRepository.StudentRepository;

import java.sql.*;

public class DbCreator {

    public static void creatTableStudent() {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        studentRepository.creatTable();
    }

    public static void creatTableCourse() {
        CourseRepository courseRepository = new CourseRepositoryImpl();
        courseRepository.creatTable();
    }

    public static void creatTableEnrollment() {
        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryImpl();
        enrollmentRepository.creatTable();
    }

}
