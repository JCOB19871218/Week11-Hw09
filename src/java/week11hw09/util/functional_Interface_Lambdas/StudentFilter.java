package week11hw09.util.functional_Interface_Lambdas;

import week11hw09.util.modeling.Student;

@FunctionalInterface
public interface StudentFilter {
    boolean matches(Student s);

}

