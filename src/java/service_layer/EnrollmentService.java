package service_layer;

import functional_Interface_Lambdas.EnrollmentFilter;
import modeling.Course;
import modeling.Enrollment;
import modeling.Student;
import java.time.LocalDate;
import java.util.List;

public class EnrollmentService {

    public static void givenCourseAfterGivenDate(List<Student> students, List<Enrollment> enrollmentList, EnrollmentFilter filter, LocalDate date) {
        enrollmentList.stream()
                .filter(filter::matches)
                .forEach(System.out::println);

    }

}

