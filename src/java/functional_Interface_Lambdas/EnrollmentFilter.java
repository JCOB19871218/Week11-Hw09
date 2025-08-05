package functional_Interface_Lambdas;

import modeling.Enrollment;
import modeling.Student;

@FunctionalInterface
public interface EnrollmentFilter {
    boolean matches(Enrollment e);

}

