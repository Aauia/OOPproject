package User;

import java.io.Serializable;
import java.util.Comparator;

import Education.ResearchPaper;

public abstract class ResearcherDecorator implements Researchable, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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