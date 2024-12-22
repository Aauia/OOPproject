package User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Education.*;

public class Researcher implements Researchable,Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<ResearchPaper> researchPapers;
    private ArrayList<ResearchProject> researchProjects;

    public Researcher() {
        this.researchPapers = new ArrayList<>();
        this.researchProjects = new ArrayList<>();
    }

    public void addResearchPaper(ResearchPaper paper) {
        this.researchPapers.add(paper);
    }

    public void addResearchProject(ResearchProject project) {
        this.researchProjects.add(project);
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> c) {
        Collections.sort(researchPapers, c);
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper);
        }
    }

    public ArrayList<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public ArrayList<ResearchProject> getResearchProjects() {
        return researchProjects;
    }

    public void printResearchProjects() {
        for (ResearchProject project : researchProjects) {
            System.out.println(project);
        }
    }

	public int getName() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int calculateHIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}