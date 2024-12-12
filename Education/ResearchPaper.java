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
    private String category;      // Category of the paper (e.g., AI, Data Science)
    private boolean isApproved;   // Paper approval status
    private boolean isNew;

    // Constructor
    public ResearchPaper(String title, String category) {
    	this.title = title;
        this.category = category;
        this.isApproved = false;
        this.isNew = true;
        authors = new ArrayList<>();
        references = new ArrayList<>();
        citations = new ArrayList<>();
        keywords = new ArrayList<>();
    }

    // Methods
    public List<ResearchPaper> getCitation() {
        // Return citation details (simplified example)
        return this.citations;
    }
    
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public boolean isApproved() { return isApproved; }
    public boolean isNew() { return isNew; }

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
