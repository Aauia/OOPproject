package User;

import java.util.Comparator;
import Education.ResearchPaper;

public class ResearchPaperDateComparator implements Comparator<ResearchPaper>  {
	 @Override
	    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
	        return paper1.getDate().compareTo(paper2.getDate());
	    }

}
