package Education;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import User.Person;

public class ResearchProject {

    // Attributes
    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Person> participants;

    // Constructor
    public ResearchProject(String topic) {
        this.topic = topic;
        this.publishedPapers = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    // Getters and Setters
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    // Methods
    public void addPublishedPaper(ResearchPaper paper) {
        if (paper != null) {
            publishedPapers.add(paper);
        }
    }

    public void addParticipant(Person person) {
        if (person != null) {
            participants.add(person);
        }
    }

    public void displayPublishedPapers() {
        System.out.println("Published Papers for Project: " + topic);
        for (ResearchPaper paper : publishedPapers) {
            System.out.println(" - " + paper.getCitation()); 
        }
    }

    /**
     * Displays all participants in the project.
     */
    public void displayParticipants() {
        System.out.println("Participants in Project: " + topic);
        for (Person participant : participants) {
            System.out.println(" - " + participant.getName()); 
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearchProject that = (ResearchProject) o;
        return Objects.equals(topic, that.topic) &&
               Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, participants);
    }
}
