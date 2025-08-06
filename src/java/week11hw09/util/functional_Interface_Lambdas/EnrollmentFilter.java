package week11hw09.util.functional_Interface_Lambdas;

import week11hw09.util.modeling.Enrollment;

@FunctionalInterface
public interface EnrollmentFilter {
    boolean matches(Enrollment e);

}

