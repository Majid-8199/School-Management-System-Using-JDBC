package entity;

public class MarkDetails {
	int id, studentId;
	String subject;
	double marks;
	public MarkDetails(int id, String subject, int studentId, double marks) {
		super();
		this.id = id;
		this.subject = subject;
		this.studentId = studentId;
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getStudent() {
		return studentId;
	}
	public void setStudent(int studentId) {
		this.studentId = studentId;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
}
