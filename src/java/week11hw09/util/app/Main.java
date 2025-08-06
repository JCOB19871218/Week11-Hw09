package week11hw09.util.app;

import week11hw09.util.functional_Interface_Lambdas.EnrollmentFilter;
import week11hw09.util.functional_Interface_Lambdas.StudentFilter;
import week11hw09.util.modeling.Student;
import week11hw09.util.service_layer.CourseServiceImpl;
import week11hw09.util.service_layer.EnrollmentServiceImpl;
import week11hw09.util.service_layer.StudentServiceImpl;
import week11hw09.util.service_layer.impl.CourseService;
import week11hw09.util.service_layer.impl.EnrollmentService;
import week11hw09.util.service_layer.impl.StudentService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) throws SQLException {

        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        EnrollmentService enrollmentService = new EnrollmentServiceImpl();

        while (true) {
            System.out.println();
            System.out.println("________________________Hello____________________________");
            System.out.println("1. Filter GPA And Major");
            System.out.println("2. Filter Enrollment Date After given date ");
            System.out.println("3. Count all student older than a certain year ");
            System.out.println("4. Print courses in which the average grade is above ... ");
            System.out.println("5. Print student names in uppercase ");
            System.out.println("6. Exite program");
            System.out.println();
            System.out.println("Please select your choice: ");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:

                    // 1.Filter for GPA > 3.5 And Major "Computer Science"
                    System.out.println('\n' + " // 1.Filter for GPA And Major //  " + '\n');
                    System.out.println("Enter your GPA: ");
                    double gpa = new Scanner(System.in).nextDouble();
                    System.out.println("Enter your Major: ");
                    String major = new Scanner(System.in).nextLine();
                    StudentFilter gpaFilter = s -> s.getGpa() > gpa;
                    StudentFilter majorFilter = s -> s.getMajor().equalsIgnoreCase(major);
                    studentService.findStudent(DBFetcher.seedStudents(), gpaFilter, majorFilter);
                    break;

                case 2:
                    // 2.Filter Enrollment Date after date
                    System.out.println('\n' + " // 2.Filter Enrollment Date After date  //  " + '\n');
                    System.out.println("Enter your date: ");
                    String enterDateUser = new Scanner(System.in).nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
                    LocalDate dateUser = LocalDate.parse(enterDateUser, formatter);
                    EnrollmentFilter dateFilter = e -> e.getEnrollmentDate().isAfter(dateUser);
                    enrollmentService.givenCourseAfterGivenDate(DBFetcher.seedStudents(), DBFetcher.seedEnrollments(), dateFilter);
                    break;

                case 3:
                    // 3.Count all students older than a certain year using lambda
                    System.out.println('\n' + " // 3.Count all students older than a certain year ...) //  " + '\n');
                    System.out.println("Enter your date: ");
                    String enterDateUser1 = new Scanner(System.in).nextLine();
                    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-M-d");
                    LocalDate dateUser1 = LocalDate.parse(enterDateUser1, formatter1);
                    Predicate<Student> studentPredicate = s -> s.getYear().isBefore(dateUser1);
                    long countStudent = studentService.countStudent(DBFetcher.seedStudents(), studentPredicate);
                    System.out.println("Count all students older than a certain year: " + countStudent);
                    break;

                case 4:
                    //4.Print courses in which the average grade is above ...
                    System.out.println('\n' + " // 4.Print courses in which the average grade is above ... //  " + '\n');
                    System.out.println("Enter your average grade : ");
                    double getAverageGrade = new Scanner(System.in).nextDouble();
                    courseService.averageGrade(DBFetcher.seedEnrollments(), DBFetcher.seedCourses(), getAverageGrade);
                    break;

                case 5:
                    // 5. Print student names in uppercase (using Consumer<Student>)
                    System.out.println('\n' + " // 5. Print student names in uppercase (using Consumer<Student>) //  " + '\n');
                    Consumer<Student> consumer = student -> System.out.println("Student name change to UpperCase -> " + student.getName().toUpperCase());
                    studentService.printNameUpperCase(DBFetcher.seedStudents(), consumer);
                    break;

                case 6:
                    //6.Exite System
                    System.out.println("Exite the program....");
                    System.exit(0);

                default:
                    System.out.println("This choice not exist!!!");
            }
        }


    }
}






