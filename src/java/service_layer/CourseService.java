package service_layer;
import modeling.Course;
import modeling.Enrollment;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CourseService {

    public static void averageGrade(List<Enrollment> enrollments, List<Course> courses,double getAverageGrade) {
        Map<Integer, List<Enrollment>> groupByCourse = enrollments.stream()
                .collect(Collectors.groupingBy(Enrollment::getCourseId));

        for (Map.Entry<Integer, List<Enrollment>> entry : groupByCourse.entrySet()) {
            int courseId = entry.getKey();
            List<Enrollment> enrollmentForCourse = entry.getValue();

            double average = enrollmentForCourse.stream()
                    .mapToDouble(Enrollment::getGrade)
                    .average()
                    .orElse(0);
//
//            if (average > getAverageGrade)
//            {
//                System.out.println(" CourseId: " + courseId);
//                System.out.println(" Passed average >"+getAverageGrade+" check - Average for this course -> " +String.format("%.2f",average));
//                System.out.println("_____________________________________________");}
            Optional.of(average)
                            .filter(avg -> avg >getAverageGrade)
                                    .ifPresent(avg ->{
                                        System.out.println(" CourseId: " + courseId);
                System.out.println(" Passed average >"+getAverageGrade+" check - Average for this course -> " +String.format("%.2f",average));
                System.out.println("_____________________________________________");
                                    });


        }
    }
}




