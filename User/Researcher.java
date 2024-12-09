package User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Education.*;

public class Researcher implements Researchable {
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

    @Override
    public int calculateHIndex() {
        Collections.sort(researchPapers, Comparator.comparingInt(paper -> Integer.parseInt(((ResearchPaper) paper).getCitation())).reversed());
        int hIndex = 0;
        for (int i = 0; i < researchPapers.size(); i++) {
            ResearchPaper paper = researchPapers.get(i);
            double citationCount = Integer.parseInt(paper.getCitation());
            if (citationCount >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
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
}

