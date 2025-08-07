package week11hw09.util.db;

import week11hw09.util.modeling.Course;
import week11hw09.util.modeling.Enrollment;
import week11hw09.util.modeling.Student;
import week11hw09.util.repository_layer.CourseRepositoryImpl;
import week11hw09.util.repository_layer.EnrollmentRepositoryImpl;
import week11hw09.util.repository_layer.StudentRepositoryImpl;
import week11hw09.util.repository_layer.implRepository.CourseRepository;
import week11hw09.util.repository_layer.implRepository.EnrollmentRepository;
import week11hw09.util.repository_layer.implRepository.StudentRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DbRead {
    public static void readTableStudent() throws Exception {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        List<Student> students = studentRepository.getAllStudent();
        System.out.println("Student: ");
        students.forEach(System.out::println);

    }

    public static void readTableCourse() throws Exception {
        CourseRepository courseRepository = new CourseRepositoryImpl();
        List<Course> courses = courseRepository.getAllCourse();
        System.out.println("Course: ");
        courses.forEach(System.out::println);


    }

    public static void readTableEnrollment() throws Exception {
        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryImpl();
        List<Enrollment> enrollments = enrollmentRepository.getAllEnrollment();
        System.out.println("Enrollment: ");
        enrollments.forEach(System.out::println);

    }
}
