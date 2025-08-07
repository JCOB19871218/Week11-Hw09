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

public class DbUpdate {

    public static void updateStudent(int studentId, double gpa) throws Exception {

        StudentRepository studentRepository = new StudentRepositoryImpl();
        List<Student> students = studentRepository.getAllStudent();
        studentRepository.updateStudent(studentId, gpa);

        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryImpl();
        enrollmentRepository.getAllEnrollment();

    }

    public static void updateCourse(int courseId, String title) throws Exception {

        CourseRepository courseRepository = new CourseRepositoryImpl();
        List<Course> courses = courseRepository.getAllCourse();
        courseRepository.updateStudent(courseId, title);

    }

    public static void updateEnrollment(int studentId, double grade) throws Exception {

        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryImpl();
        List<Enrollment> enrollments = enrollmentRepository.getAllEnrollment();
        enrollmentRepository.updateStudent(studentId, grade);

    }
}

