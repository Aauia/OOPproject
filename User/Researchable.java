package User;
import java.util.Comparator;
import Education.*;

public interface Researchable {
	 void printPapers(Comparator<ResearchPaper> c);
	 int calculateHIndex();
}