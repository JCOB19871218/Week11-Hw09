package week11hw09.util.app;

import week11hw09.util.modeling.Course;
import week11hw09.util.modeling.Enrollment;
import week11hw09.util.modeling.Student;
import week11hw09.util.repository_layer.CourseRepositoryImpl;
import week11hw09.util.repository_layer.EnrollmentRepositoryImpl;
import week11hw09.util.repository_layer.StudentRepositoryImpl;
import week11hw09.util.repository_layer.implRepository.CourseRepository;
import week11hw09.util.repository_layer.implRepository.EnrollmentRepository;
import week11hw09.util.repository_layer.implRepository.StudentRepository;
import week11hw09.util.service_layer.CourseServiceImpl;
import week11hw09.util.service_layer.EnrollmentServiceImpl;
import week11hw09.util.service_layer.StudentServiceImpl;
import week11hw09.util.service_layer.impl.CourseService;
import week11hw09.util.service_layer.impl.EnrollmentService;
import week11hw09.util.service_layer.impl.StudentService;

import java.util.List;

public class DBFetcher {
private static List<Student> cacheStudent;
private static List<Course> cacheCourse;
private static List<Enrollment> cachEnrollment;


    public static List<Student> seedStudents() {
        if(cacheStudent == null){
        StudentRepository studentRepository = new StudentRepositoryImpl();
        cacheStudent = studentRepository.getAllStudent();}
        return cacheStudent;
    }

    public static List<Course> seedCourses() {
        if(cacheCourse == null){
        CourseRepository courseRepository = new CourseRepositoryImpl();
        cacheCourse = courseRepository.getAllCourse();}
        return cacheCourse;
    }

    public static List<Enrollment> seedEnrollments() {
        if(cachEnrollment == null){
        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryImpl();
         cachEnrollment = enrollmentRepository.getAllEnrollment();}
        return cachEnrollment;
    }
}
