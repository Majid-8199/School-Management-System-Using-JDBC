package entity;

public class SubjectDetails {
	int subjectId;
	String subject;
	public SubjectDetails(int subjectId, String subject) {
		super();
		this.subjectId = subjectId;
		this.subject = subject;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
