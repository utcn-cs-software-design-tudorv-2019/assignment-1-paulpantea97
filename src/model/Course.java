package model;
import java.sql.Date;
public class Course {

    private String name;
    private Date exam;

    public Course() {
        this.name = null;
        this.exam = null;
    }

    public Course(String name, Date exam) {
        this.name = name;
        this.exam = exam;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getExam() {
        return exam;
    }
    public void setExam(Date exam) {
        this.exam = exam;
    }
    @Override
    public String toString() {
        return "Course ("+name +","+ exam+")\n";
    }
}
