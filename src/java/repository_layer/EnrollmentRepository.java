package repository_layer;

import modeling.Course;
import modeling.Enrollment;
import modeling.Student;
import util.DBUtil;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class EnrollmentRepository {

    public static List<Enrollment> getListEnrollment() {

        StudentRepository sr = new StudentRepository();
        CourseRepository cr = new CourseRepository();
        EnrollmentRepository er = new EnrollmentRepository();
        List<String[]> enrollmentData = Arrays.asList(
                new String[]{"Jahan Esfandiyari", "Computer Science"},
                new String[]{"Ali Omrani", "Database Systems"},
                new String[]{"Ali Mortazavi", "Web Programming"},
                new String[]{"Sara Amiri", "Computer Science"},
                new String[]{"Reza Kazemi", "Database Systems"},
                new String[]{"Mina Rahmani", "Computer Science"},
                new String[]{"Hossein Moradi", "Web Programming"},
                new String[]{"Fatemeh Zarei", "Computer Science"},
                new String[]{"Arman Gholami", "Software Engineering"},
                new String[]{"Negar Ahmadi", "Software Engineering"}
        );

        List<Enrollment> enrollments = new ArrayList<>();

        for (String[] data : enrollmentData) {
            String studentName = data[0];
            String courseTitle = data[1];


            int studentId = sr.findById(studentName);
            int courseId = cr.findById(courseTitle);

            Random rand = new Random();
            LocalDate startDate = LocalDate.of(2023, 06, 01);
            LocalDate endDate = LocalDate.now();
            long betweenDay = ChronoUnit.DAYS.between(startDate, endDate);
            long randomDay = rand.nextInt((int) betweenDay + 1);
            LocalDate randomDate = startDate.plusDays(randomDay);
            int randomGrade = rand.nextInt(50) + 51;

            if (studentId != -1 && courseId != -1) {
                Enrollment enrollment = new Enrollment(studentId, courseId, randomDate, randomGrade);
                enrollments.add(enrollment);
                enrollment.setStudentId(studentId);
                enrollment.setCourseId(courseId);
                er.creatEnrollment(enrollment);
            } else
                System.out.println("Not found Student -> " + studentName + " |  Course title: " + courseTitle);

        }
        return enrollments;


    }

    public void creatEnrollment(Enrollment enrollment) {

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT into enrollment(student_id,course_id,enrollment_date,grade) values (?,?,?,?)");
        ) {

            preparedStatement.setInt(1, enrollment.getStudentId());
            preparedStatement.setInt(2, enrollment.getCourseId());
            preparedStatement.setDate(3, Date.valueOf(enrollment.getEnrollmentDate()));
            preparedStatement.setDouble(4, enrollment.getGrade());
            int numberAddStudent = preparedStatement.executeUpdate();
//            System.out.println(numberAddStudent + "  Add Enrollment...");
//            System.out.println(("Student Id: "+enrollment.getStudentId() + " |  Course Id: ".concat(String.valueOf(enrollment.getCourseId())).concat(" |  Enrollment Date: ").concat(String.valueOf(enrollment.getEnrollmentDate())).concat(" |  Grade: ").concat(String.valueOf(enrollment.getGrade()))));
//            System.out.println("______________________________________________________________________________________________");
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

    }

    public void readEnrollment(int studentId) throws SQLException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from enrollment where student_id = ?");
        ) {
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int courseId = rs.getInt("course_id");
                Date enrollmentDate = rs.getDate("enrollment_date");
                Double enrollmentGrade = rs.getDouble("grade");
                System.out.println("Student id :  0000" + studentId + " Course id:  0000".concat(" | ").concat("Enrollment Date: ".concat(String.valueOf(enrollmentDate)).concat(" |  ").concat(String.valueOf(enrollmentGrade))));
                System.out.println("---------------------------------------" + '\n');

            }
        }
    }

    public void updateStudent(int studentId, double grade) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update enrollment set grade =? where student_id= ?");
        ) {
            preparedStatement.setDouble(1, grade);
            preparedStatement.setInt(2, studentId);
            int numberAddStudent = preparedStatement.executeUpdate();
            if (numberAddStudent == 0) {
                System.out.println("Student id:  0000" + studentId + " not found!");
            }
            System.out.println(numberAddStudent + "  Update Enrollment...");
            System.out.println("---------------------------------------");
            System.out.println(" Update information for Enrollment id: 0000" + studentId + " -> update grade   |   new value of grade: " + grade);
            System.out.println("---------------------------------------" + '\n');


        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());

        }
    }

    public void dropStudent(int studentId) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from enrollment where student_id =?");
        ) {
            preparedStatement.setInt(1, studentId);
            int numberAddStudent = preparedStatement.executeUpdate();
            System.out.println(numberAddStudent + "  Delete Enrollment...");
            System.out.println("---------------------------------------" + '\n');
            System.out.println("Delete Enrollment -> Student id : 0000" + studentId);
            System.out.println("---------------------------------------" + '\n');


        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());

        }
    }

    public void findById(int studentId) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from enrollment where student_id = ?");
        ) {
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int courseId = rs.getInt("course_id");
                Date enrollmentDate = rs.getDate("enrollment_date");
                double grade = rs.getDouble("grade");
                System.out.println("Student id: " + studentId + "  | Course Id: 0000" + courseId + " | Enrollment Date : " + enrollmentDate + " |  Grade: " + grade);
            }

        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static List<Enrollment> getAllEnrollment() {
        List<Enrollment> enrollments = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from enrollment");
             ResultSet rs = preparedStatement.executeQuery();) {
            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDate("enrollment_date").toLocalDate(),
                        rs.getDouble("grade")
                );
                enrollments.add(enrollment);
            }
        } catch (SQLException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
        return enrollments;
    }
}

