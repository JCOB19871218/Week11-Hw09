package service_layer;

import functional_Interface_Lambdas.StudentFilter;
import modeling.Course;
import modeling.Enrollment;
import modeling.Student;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;

public class StudentService {
    

    public static void findStudent(List<Student> studentList, StudentFilter gpaFilter, StudentFilter majorFilter) {
        studentList.stream().filter(s -> gpaFilter.matches(s) && majorFilter.matches(s))
                .forEach(System.out::println);

    }

    public static long countStudent(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .count();
    }

    public static void printNameUpperCase(List<Student> students, Consumer<Student> consumer) {
        students.stream().forEach(consumer);
    }
}
