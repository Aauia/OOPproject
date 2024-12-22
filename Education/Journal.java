package Education;

import java.io.Serializable;
import java.util.*;
import User.Person;
import User.Subject;

public class Journal implements Serializable, Subject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private List<ResearchPaper> papers;
    private Set<Person> subscribers;

    public Journal(String name) {
        this.name = name;
        this.papers = new ArrayList<>();
        this.subscribers = new HashSet<>();
    }

    public void subscribe(Person person) {
        subscribers.add(person);
    }
    
    public void unsubscribe(Person person) {
        subscribers.remove(person);
    }

    public boolean isSubscribed(Person person) {
        return subscribers.contains(person);
    }

    public void publish(ResearchPaper paper) {
        papers.add(paper);
        for (Person person : subscribers) {
            person.update(paper);
        }
    }

    public List<ResearchPaper> getPapers() {
        return papers;
    }

    public String getName() {
        return name;
    }
}