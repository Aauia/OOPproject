package Education;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import User.Researcher;

public class ResearchPaper {
	
	private String title;
    private List<Researcher> authors;
    private List<ResearchPaper> references;
    private List<ResearchPaper> citations;
    private List<String> keywords;

    // Constructor
    public ResearchPaper() {
        authors = new ArrayList<>();
        references = new ArrayList<>();
        citations = new ArrayList<>();
        keywords = new ArrayList<>();
    }

    // Methods
    public String getCitation() {
        // Return citation details (simplified example)
        return "Citation format placeholder";
    }

    public void addAuthor(Researcher author) {
        authors.add(author);
    }

    public void addReference(ResearchPaper paper) {
        references.add(paper);
    }

    public void addKeyword(String keyword) {
        keywords.add(keyword);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearchPaper that = (ResearchPaper) o;
        return Objects.equals(title, that.title) &&
               Objects.equals(authors, that.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors);
    }
}
