package week11hw09.util.service_layer.impl;

import week11hw09.util.functional_Interface_Lambdas.EnrollmentFilter;
import week11hw09.util.modeling.Enrollment;
import week11hw09.util.modeling.Student;

import java.util.List;

public interface EnrollmentService {
    void givenCourseAfterGivenDate(List<Student> students, List<Enrollment> enrollmentList, EnrollmentFilter filter);

}
