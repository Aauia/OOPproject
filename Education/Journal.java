package Observer;

import java.util.*;

import Education.ResearchPaper;

public class Journal {
    private String name;
    private List<ResearchPaper> papers;  // List of all papers published in the journal
    private Set<User> subscribers;  // Set of subscribed users
    private Map<User, Set<String>> unreadNotifications;  // User -> Set of unread paper titles

    public Journal(String name) {
        this.name = name;
        this.papers = new ArrayList<>();
        this.subscribers = new HashSet<>();
        this.unreadNotifications = new HashMap<>();
    }

    // Subscribe a user to the journal
    public void subscribe(User user) {
        subscribers.add(user);
        unreadNotifications.put(user, new HashSet<>());  // Initialize unread notifications for the user
        System.out.println(user.getName() + " subscribed to journal: " + name);
    }

    // Unsubscribe a user from the journal
    public void unsubscribe(User user) {
        subscribers.remove(user);
        unreadNotifications.remove(user);  // Remove the user's unread notifications when unsubscribed
        System.out.println(user.getName() + " unsubscribed from journal: " + name);
    }

    // Publish a new paper and notify subscribed users
    public void publish(ResearchPaper paper) {
        papers.add(paper);  // Add the paper to the journal's collection
        System.out.println("Paper \"" + paper.getTitle() + "\" added to journal: " + name);

        // Notify subscribed users about the new paper by adding it to their unread notifications
        for (User user : subscribers) {
            unreadNotifications.get(user).add(paper.getTitle());  // Add paper title to unread list
        }
    }

    // Getter methods
    public String getName() { return name; }
    public List<ResearchPaper> getPapers() { return papers; }

    // Check if user is subscribed to the journal
    public boolean isSubscribed(User user) {
        return subscribers.contains(user);
    }

    // Retrieve unread notifications for a user
    public Set<String> getUnreadNotifications(User user) {
        return unreadNotifications.getOrDefault(user, new HashSet<>());
    }

    // Mark a paper as viewed by removing it from unread notifications
    public void markPaperAsViewed(User user, String paperTitle) {
        Set<String> unreadPapers = unreadNotifications.get(user);
        if (unreadPapers != null) {
            unreadPapers.remove(paperTitle);  // Remove the paper from unread notifications
        }
    }
}