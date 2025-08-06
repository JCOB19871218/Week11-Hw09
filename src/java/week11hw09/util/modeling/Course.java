package week11hw09.util.modeling;

public class Course {
    private int id;
    private String title;
    private String department;
    private int credits;

    public Course(String title, String department, int credits) {
        this.title = title;
        this.department = department;
        this.credits = credits;
    }
    public Course(int id, String title, String department, int credits) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public String getDepartment() {
        return department;
    }
    public int getCredits() {
        return credits;
    }
    @Override
    public String toString() {
        return "Course Detail: " +'\n'+
                "Title= " + title +
                "    |    Department= " + department +
                "    |    Credits=" + credits +'\n'+
                "_______________________________"+'\n';
    }
}
