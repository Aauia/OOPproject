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
    private Map<Person, Set<String>> unreadNotifications;

    public Journal(String name) {
        this.name = name;
        this.papers = new ArrayList<>();
        this.subscribers = new HashSet<>();
        this.unreadNotifications = new HashMap<>();
    }

    public void subscribe(Person person) {
        subscribers.add(person);
        unreadNotifications.putIfAbsent(person, new HashSet<>());
        System.out.println(person.getName() + " has subscribed to " + name);
    }
    
    public void unsubscribe(Person person) {
        subscribers.remove(person);
        unreadNotifications.remove(person);
        System.out.println(person.getName() + " has unsubscribed from " + name);
    }

    public boolean isSubscribed(Person person) {
        return subscribers.contains(person);
    }

    public void publish(ResearchPaper paper) {
        papers.add(paper);
        for (Person person : subscribers) {
            unreadNotifications.get(person).add(paper.getTitle());
        }
        System.out.println("Paper \"" + paper.getTitle() + "\" published in " + name);
    }

    // New method: Mark all papers as viewed for a specific person
    public void markAllPapersAsViewed(Person person) {
        if (unreadNotifications.containsKey(person)) {
            unreadNotifications.get(person).clear();
        }
    }

    public Set<String> getUnreadNotifications(Person person) {
        return unreadNotifications.getOrDefault(person, new HashSet<>());
    }

    public List<ResearchPaper> getPapers() {
        return papers;
    }

    public String getName() {
        return name;
    }
}