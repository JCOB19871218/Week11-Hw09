package functional_Interface_Lambdas;

import modeling.Student;

@FunctionalInterface
public interface StudentFilter {
    boolean matches(Student s);

}

