package User;

import java.util.Comparator;

import Education.ResearchPaper;

public abstract class ResearcherDecorator implements Researchable {
    protected Researchable decoratedResearcher;

    public ResearcherDecorator(Researchable researcher) {
        this.decoratedResearcher = researcher;
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        decoratedResearcher.printPapers(comparator);
    }

    @Override
    public int calculateHIndex() {
        return decoratedResearcher.calculateHIndex();
    }

}
