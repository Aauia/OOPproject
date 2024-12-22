package Education;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String content;
    private LocalDate datePublished;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
        this.datePublished = LocalDate.now();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDate: " + datePublished + "\nContent: " + content + "\n";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        News news = (News) obj;
        return Objects.equals(title, news.title) &&
               Objects.equals(content, news.content) &&
               Objects.equals(datePublished, news.datePublished);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, datePublished);
    }
}