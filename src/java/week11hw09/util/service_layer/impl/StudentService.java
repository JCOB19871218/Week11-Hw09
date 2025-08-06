package week11hw09.util.service_layer.impl;

import week11hw09.util.functional_Interface_Lambdas.StudentFilter;
import week11hw09.util.modeling.Student;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface StudentService {
    void findStudent(List<Student> studentList, StudentFilter gpaFilter, StudentFilter majorFilter);
    long countStudent(List<Student> students, Predicate<Student> predicate);
    void printNameUpperCase(List<Student> students, Consumer<Student> consumer) ;
    }
