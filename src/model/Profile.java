package model;

public class Profile {
	private Student student;
	private Course course;
	private Group group;
	private int grade;
	
	public Profile() {
		this.student = null;
		this.course = null;
		this.grade = 1;
		this.group = null;
	}
	
	public Profile(Student student, Course course, Group group, int grade) {
		super();
		this.student = student;
		this.course = course;
		this.group = group;
		this.grade = grade;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Profile ("+student +","+ course+","+ group+","+ grade+")\n";
	}
}
