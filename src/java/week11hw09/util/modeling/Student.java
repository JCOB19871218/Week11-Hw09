package week11hw09.util.modeling;
import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private String major;
    private LocalDate year;
    private double gpa;


    public Student(String name,String major, LocalDate year, double gpa) {
        this.name = name;
        this.major = major;
        this.year = year;
        this.gpa = gpa;
    }
    public Student(int id, String name, String major, LocalDate year, double gpa) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.year = year;
        this.gpa = gpa;
    }
    public Student(int id){this.id = id;}

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getMajor() {
        return major;
    }
    public LocalDate getYear() {
        return year;
    }
    public double getGpa() {
        return gpa;
    }
    @Override
    public String toString() {
        return "Student Detail: " +'\n'+
                "name= " + name +
                "   |   Major= " + major +
                "   |   Year= " + year +
                "   |   Gpa= " + gpa +'\n'+
                "___________________________"+'\n';
    }
}
