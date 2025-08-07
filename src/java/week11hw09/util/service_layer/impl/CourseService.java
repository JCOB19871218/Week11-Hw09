package week11hw09.util.service_layer.impl;

import week11hw09.util.modeling.Course;
import week11hw09.util.modeling.Enrollment;

import java.util.List;

public interface CourseService {
    void averageGrade(List<Enrollment> enrollments, List<Course> courses, double getAverageGrade);

}
