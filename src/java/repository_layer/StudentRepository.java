package repository_layer;

import modeling.Student;
import util.DBUtil;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepository {
    public static List<Student> getListStudents() {
        Student student1 = new Student("Jahan Esfandiyari", "Computer Science", LocalDate.of(1988,3,8), 18.00);
        Student student2 = new Student("Ali Omrani", "Database Systems", LocalDate.of(2000,2,2), 17.10);
        Student student3 = new Student("Ali Mortazavi", "Web Programming", LocalDate.of(2002,12,2), 17.00);
        Student student4 = new Student("Sara Amiri", "Computer Science", LocalDate.of(1999,12,12), 17.25);
        Student student5 = new Student("Reza Kazemi", "Database Systems", LocalDate.of(1998,12,18), 20);
        Student student6 = new Student("Mina Rahmani", "Computer Science", LocalDate.of(1990,1,1), 20);
        Student student7 = new Student("Hossein Moradi", "Web Programming", LocalDate.of(1992,5,15), 12.5);
        Student student8 = new Student("Fatemeh Zarei", "Computer Science", LocalDate.of(1998,8,14), 19.75);
        Student student9 = new Student("Arman Gholami", "Software Engineering", LocalDate.of(2000,12,12), 18);
        Student student10 = new Student("Negar Ahmadi", "Software Engineering", LocalDate.of(2001,3,5), 25);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6,
                student7, student8, student9, student10);
        return students;
    }
    public void creatStudent(Student student) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT into student(name,major,year,gpa) values (?,?,?,?)");
        ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getMajor());
            preparedStatement.setDate(3, Date.valueOf(student.getYear()));
            preparedStatement.setDouble(4, student.getGpa());
            int numberAddStudent = preparedStatement.executeUpdate();
//            System.out.println(numberAddStudent + "  Add Student...");
//            System.out.println(student.getName().concat(" | ").concat(student.getMajor()).concat(" | ").concat(String.valueOf(student.getGpa())).concat(String.valueOf(Date.valueOf(student.getYear()))));
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

    }
    public void readStudent(int studentId) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from student where student_id = ?");
        ) {
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nameStudent = rs.getString("name");
                String majorStudent = rs.getString("major");
                Date yearOldStudent = rs.getDate("year");
                double gpaStudent = rs.getDouble("gpa");
                System.out.println(nameStudent.concat(" | ".concat("student id:  0000").concat(majorStudent)).concat(" | ").concat(String.valueOf(yearOldStudent)).concat(" | ").concat(String.valueOf(gpaStudent)));
                System.out.println("---------------------------------------"+'\n');

            }

        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    public void updateStudent(int studentId, double gpa) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update student set gpa =? where student_id= ?");
        ) {
            preparedStatement.setDouble(1, gpa);
            preparedStatement.setInt(2, studentId);
            int numberAddStudent = preparedStatement.executeUpdate();
            if (numberAddStudent == 0) {
                System.out.println("Student id " + studentId + " not found!");
            }
            System.out.println(numberAddStudent + "  Update Student...");
            System.out.println("---------------------------------------");
            System.out.println(" Update information for Student id: 0000" + studentId + " -> update GPA   |   new value of GPA: " + gpa);
            System.out.println("---------------------------------------"+'\n');


        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());

        }
    }
    public void dropStudent(int studentId) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from student where student_id =?");
        ) {
            preparedStatement.setInt(1, studentId);
            int numberAddStudent = preparedStatement.executeUpdate();
            System.out.println(numberAddStudent + "  Delete Student...");
            System.out.println("---------------------------------------");
            System.out.println("Student id : 0000" + studentId + " has delete of database...");
            System.out.println("---------------------------------------"+'\n');


        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());

        }
    }
    public int findById(String name) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select student_id from student where name = ?");
        ) {
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
//                System.out.println("Student name: " + name + "  | Student Id: 0000" + studentId+'\n'+
//                        "_______________________________________"+'\n');
                return studentId;
            }

        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
            ;
        }


        return 0;
    }
    public static List<Student> getAllStudent(){
        List<Student> students = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
        ResultSet rs = preparedStatement.executeQuery();){
            while (rs.next()){
                Student student = new Student(
                rs.getInt("student_id"),
                rs.getString("name"),
                rs.getString("major"),
                rs.getDate("year").toLocalDate(),
                rs.getDouble("gpa")
                        );
                students.add(student);
            }
        }catch (SQLException exception){
            System.out.println("Exception: "+exception.getMessage());
        }
    return students;}
}
