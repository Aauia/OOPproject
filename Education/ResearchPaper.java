package Education;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import User.Researcher;

public class ResearchPaper implements Serializable{

	private static final long serialVersionUID = 1L;
	private String title;
    private List<Researcher> authors;
    private List<String> references;
    private List<String> citations;
    private int numberOfCitations;
    private List<String> keywords;
    private String category;      // Category of the paper (e.g., AI, Data Science)
    private boolean isApproved;   // Paper approval status
    private boolean isNew;

    // Constructor
    public ResearchPaper(String title, String category,int numberOfCitations) {
    	this.title = title;
        this.category = category;
        this.isApproved = false;
        this.isNew = true;
        this.numberOfCitations=numberOfCitations;
        authors = new ArrayList<>();
        references = new ArrayList<>();
        citations = new ArrayList<>();
        keywords = new ArrayList<>();
    }

    public int getNumberOfCitations() {
		return numberOfCitations;
	}

	public void setNumberOfCitations(int numberOfCitations) {
		this.numberOfCitations = numberOfCitations;
	}

	// Methods
    public List<String> getCitation() {
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

    public void addReference(String paper) {
        references.add(paper);
    }

    public void addKeyword(String keyword) {
        keywords.add(keyword);
    }
    
    public List<Researcher> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Researcher> authors) {
		this.authors = authors;
	}

	public List<String> getReferences() {
		return references;
	}

	public void setReferences(List<String> references) {
		this.references = references;
	}

	public List<String> getCitations() {
		return citations;
	}

	public void setCitations(List<String> citations) {
		this.citations = citations;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
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

	public void addCitation(String citation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "ResearchPaper [title=" + title + ", authors=" + authors + ", references=" + references + ", citations="
				+ citations + ", keywords=" + keywords + ", category=" + category + ", isApproved=" + isApproved
				+ ", isNew=" + isNew + "]";
	}
	
}
