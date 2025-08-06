package week11hw09.util.repository_layer;

import week11hw09.util.modeling.Course;
import week11hw09.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseRepositoryImpl implements week11hw09.util.repository_layer.implRepository.CourseRepository {
    public List<Course> getListCourse() {
        List<Course> courseList = Arrays.asList(
                new Course("Computer Science", "Software", 4),
                new Course("Software Engineering", "Software", 3),
                new Course("Database Systems", "Software", 3),
                new Course("Computer Science", "Hardware", 3),
                new Course("Operating Systems", "Software", 4),
                new Course("Computer Science", "IT", 2),
                new Course("Computer Networks", "Hardware", 3),
                new Course("Web Programming", "Software", 2),
                new Course("Artificial Intelligence", "AI", 4),
                new Course("Computer Science", "Data", 5)
        );

        return courseList;
    }

    public void creatCourse(Course course) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT into course(title,department,credits) values (?,?,?)");
        ) {
            preparedStatement.setString(1, course.getTitle());
            preparedStatement.setString(2, course.getDepartment());
            preparedStatement.setInt(3, course.getCredits());
            int countCreatStudent = preparedStatement.executeUpdate();
//            System.out.println(numberAddStudent + "  Add Course...");
//            System.out.println(course.getTitle().concat(" | ").concat(course.getDepartment()).concat(" | ").concat(String.valueOf(course.getCredits())));
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

    }

    public void readStudent(int courseID) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from course where course_id = ?");
        ) {
            preparedStatement.setInt(1, courseID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String titleCourse = rs.getString("title");
                String departmentCourse = rs.getString("department");
                int creditsCourse = rs.getInt("credits");
                System.out.println(titleCourse.concat(" | ".concat(" id:  0000").concat(departmentCourse)).concat(" | ").concat(String.valueOf(creditsCourse)));
                System.out.println("---------------------------------------" + '\n');

            }

        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void updateStudent(int courseId, String title) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update course set title =? where course_id= ?");
        ) {
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, courseId);
            int numberAddStudent = preparedStatement.executeUpdate();
            if (numberAddStudent == 0) {
                System.out.println("Course id:  0000" + courseId + " not found!");
            }
            System.out.println(numberAddStudent + "  Update Student...");
            System.out.println("---------------------------------------");
            System.out.println(" Update information for Course id: 0000" + courseId + " -> update title   |   new value of title: " + title);
            System.out.println("---------------------------------------" + '\n');


        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());

        }
    }

    public void dropStudent(int courseId) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from course where course_id =?");
        ) {
            preparedStatement.setInt(1, courseId);
            int numberAddStudent = preparedStatement.executeUpdate();
            System.out.println(numberAddStudent + "  Delete Course...");
            System.out.println("---------------------------------------");
            System.out.println("Course id : 0000" + courseId + " has delete of database...");
            System.out.println("---------------------------------------" + '\n');


        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());

        }
    }

    public int findById(String title) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select course_id from course where title = ?");
        ) {
            preparedStatement.setString(1, title);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int courseId = rs.getInt("course_id");
//                System.out.println("Course title: " + title + "  | Course Id: 0000" + courseId);
                return courseId;
            }

        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
            ;
        }
        return 0;
    }

    public  List<Course> getAllCourse() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from course");
             ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                Course course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("title"),
                        rs.getString("department"),
                        rs.getInt("credits")
                );
                courses.add(course);
            }
        } catch (SQLException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
        return courses;
    }
}

