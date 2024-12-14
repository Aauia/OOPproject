package Education;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import User.Researcher;
import java.time.LocalDate;

// Enum to specify citation format
enum Format {
    PLAIN_TEXT, BIBTEX;
}

public class ResearchPaper {

    private String title;
    private List<Researcher> authors;
    private List<ResearchPaper> references;
    private String citations;
    private List<String> keywords;
    private String category;      // Category of the paper (e.g., AI, Data Science)
    private boolean isApproved;   // Paper approval status
    private boolean isNew;
    private LocalDate publishingDate; // Publishing date of the paper

    // Constructor
    public ResearchPaper(String title, String category, LocalDate publishingDate, String citations) {
        this.title = title;
        this.category = category;
        this.publishingDate = publishingDate;
        this.citations = citations;
        this.isApproved = false;
        this.isNew = true;
        authors = new ArrayList<>();
        references = new ArrayList<>();
        keywords = new ArrayList<>();
    }

    // Methods
    public String getCitation() {
        return this.citations;
    }

    public String getTitle() { return title; }

    public String getCategory() { return category; }

    public boolean isApproved() { return isApproved; }

    public boolean isNew() { return isNew; }

    public LocalDate getPublishingDate() { return publishingDate; }

    public void markAsViewed() {
        this.isNew = false;
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

    // Method to get citation in specified format
    public String getCitation(Format f) {
        switch (f) {
            case PLAIN_TEXT:
                return getPlainTextCitation();
            case BIBTEX:
                return getBibTeXCitation();
            default:
                throw new IllegalArgumentException("Unsupported format: " + f);
        }
    }

    // Helper method to generate plain text citation
    private String getPlainTextCitation() {
        StringBuilder plainText = new StringBuilder();
        plainText.append("Title: ").append(title).append("\n");
        plainText.append("Authors: ");
        for (int i = 0; i < authors.size(); i++) {
            plainText.append(authors.get(i).getName());
            if (i < authors.size() - 1) plainText.append(", ");
        }
        plainText.append("\nCategory: ").append(category);
        plainText.append("\nPublishing Date: ").append(publishingDate);
        return plainText.toString();
    }

    // Helper method to generate BibTeX citation
    private String getBibTeXCitation() {
        StringBuilder bibtex = new StringBuilder();
        bibtex.append("@article{\n");
        bibtex.append("  title={").append(title).append("},\n");
        bibtex.append("  author={");
        for (int i = 0; i < authors.size(); i++) {
            bibtex.append(authors.get(i).getName());
            if (i < authors.size() - 1) bibtex.append(" and ");
        }
        bibtex.append("},\n");
        bibtex.append("  category={").append(category).append("},\n");
        bibtex.append("  year={").append(publishingDate.getYear()).append("}\n");
        bibtex.append("}");
        return bibtex.toString();
    }
}
