package week11hw09.util.service_layer;

import week11hw09.util.functional_Interface_Lambdas.StudentFilter;
import week11hw09.util.modeling.Student;
import week11hw09.util.service_layer.impl.StudentService;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StudentServiceImpl implements StudentService {
    
    @Override
    public void findStudent(List<Student> studentList, StudentFilter gpaFilter, StudentFilter majorFilter) {
        studentList.stream().filter(s -> gpaFilter.matches(s) && majorFilter.matches(s))
                .forEach(System.out::println);

    }
    @Override
    public  long countStudent(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .count();
    }
@Override
    public  void printNameUpperCase(List<Student> students, Consumer<Student> consumer) {
        students.stream().forEach(consumer);
    }
}
