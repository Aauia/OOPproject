package User;

public class TeacherResearcher extends ResearcherDecorator {
    public TeacherResearcher(Researchable researcher) {
        super(researcher);
    }
}
