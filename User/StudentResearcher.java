package User;

public class StudentResearcher extends ResearcherDecorator {
	private Student student;
	
	public StudentResearcher(Student student,Researchable researcher) {
	    super(researcher);
		this.student=student;
    }

}
