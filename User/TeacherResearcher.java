package User;

public class TeacherResearcher extends ResearcherDecorator {
	private Teacher teacher;
	
	public TeacherResearcher(Teacher teacher, Researchable researcher) {
		    super(researcher);
	        this.teacher = teacher;
	 }
}