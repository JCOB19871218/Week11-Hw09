package week11hw09.util.repository_layer.implRepository;

import week11hw09.util.modeling.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> seedCourse();

    int findById(String title);

    List<Course> getAllCourse();

    void creatCourse(Course course);

    void readStudent(int courseID);

    void updateStudent(int courseId, String title);

    void dropStudent(int courseId);

    public void creatTable();

    void dropTable();

}
