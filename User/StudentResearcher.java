package User;

public class StudentResearcher extends ResearcherDecorator {
	public StudentResearcher(Researchable researcher) {
        super(researcher);
    }
}
