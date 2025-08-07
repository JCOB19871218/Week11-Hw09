package week11hw09.util.service_layer;

import week11hw09.util.functional_Interface_Lambdas.EnrollmentFilter;
import week11hw09.util.modeling.Enrollment;
import week11hw09.util.modeling.Student;
import week11hw09.util.service_layer.impl.EnrollmentService;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {
    @Override
    public void givenCourseAfterGivenDate(List<Student> students, List<Enrollment> enrollmentList, EnrollmentFilter filter) {
        enrollmentList.stream()
                .filter(filter::matches)
                .forEach(System.out::println);

    }

}

