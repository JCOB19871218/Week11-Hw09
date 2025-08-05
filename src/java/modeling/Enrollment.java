package modeling;
import java.time.LocalDate;

public class Enrollment {
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private double grade;

    public Enrollment(int studentId, int courseId, LocalDate enrollmentDate, double grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }
    public int getCourseId() {
        return courseId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    public double getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return "Enrollment Detail:" +'\n'+
                "studentId= " + studentId +
                "    | courseId= " + courseId +
                "    | enrollmentDate= " + enrollmentDate +
                "    | grade= " + grade +'\n'+
                "_______________________________"+'\n';
    }
}
