package Education;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResearchPaper implements Serializable{

	private static final long serialVersionUID = 1L;
	private String title;
    private List<String> authors;
    private List<String> references;
    private List<String> citations;
    private int numberOfCitations;
    private List<String> keywords;
    private String category;
    private LocalDate publishDate;

    // Constructor
    public ResearchPaper(String title, String category,int numberOfCitations) {
    	this.title = title;
        this.category = category;
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
    public LocalDate getpublishDate() {
		return publishDate;
	}

	public void setpublishDates(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	

	// Methods
    public List<String> getCitation() {
        // Return citation details (simplified example)
        return this.citations;
    }
    
    public String getTitle() { return title; }
    public String getCategory() { return category; }

   
    public void addReference(String paper) {
        references.add(paper);
    }

    public void addKeyword(String keyword) {
        keywords.add(keyword);
    }
    
    public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
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
				+ citations + ", keywords=" + keywords + ", category=" + category + "]";
	}

	public void addAuthor(String currentUserEmail) {
		authors.add(currentUserEmail);
		
	}


	
}