package Education;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import User.Person;
import User.Researcher;

public class ResearchProject implements Serializable{

	private static final long serialVersionUID = 1L;
	// Attributes
    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Researcher> participants;

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

    public List<Researcher> getParticipants() {
        return participants;
    }

    // Methods
    public void addPublishedPaper(ResearchPaper paper) {
        if (paper != null) {
            publishedPapers.add(paper);
        }
    }

    public void addParticipant(Researcher selectedParticipant) {
        if (selectedParticipant != null) {
            participants.add(selectedParticipant);
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
        for (Researcher participant : participants) {
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
