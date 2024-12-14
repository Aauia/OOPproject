package Education;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import User.Dean;
import User.Student;
import User.Teacher;

public class Complaint {
    
    private Integer complainID;
    private String complainText;
    private Teacher complainSender;
    private String complainGuilty;
    private UrgencyLevel levelOfUrgency;
    private List<Student> complainedTo;
    private StatusInfo status;
    // Getter and Setter Methods
    
    public Integer complainID() {
        return this.complainID;
    }
    
    public void setComplainCode(Integer complainID) {
        this.complainID = complainID;
    }
    
    public String getComplainText() {
        return this.complainText;
    }
    
    public void setComplainText(String complainText) {
        this.complainText = complainText;
    }
    
    public Teacher getComplainSender() {
        return this.complainSender;
    }
    
    public void setComplainSender(Teacher complainSender) {
        this.complainSender = complainSender;
    }
    
    public String getComplainGuilty() {
        return this.complainGuilty;
    }
    
    public void setComplainGuilty(String complainGuilty) {
        this.complainGuilty = complainGuilty;
    }
    
    public UrgencyLevel getComplaintSeriousness() {
        return this.levelOfUrgency;
    }
    
    public void setComplaintSeriousness(UrgencyLevel complaintSeriousness) {
        this.levelOfUrgency = complaintSeriousness;
    }
    
    public List<Student> getComplainedTo() {
        return this.complainedTo;
    }
    
    public void setComplainedTo(List<Student> complainedTo) {
        this.complainedTo = complainedTo;
    }

    // Operations (Example placeholders for methods)
    
    public String getSender() {
        return complainSender != null ? complainSender.toString() : "Unknown Sender";
    }
    
    public int getCode() {
        return complainID != null ? complainID : -1;
    }
    
    public String getGuilty() {
        return complainGuilty != null ? complainGuilty : "Unknown";
    }
    
    public String writeText() {
        return "Complaint Text: " + complainText;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint that = (Complaint) o;
        return Objects.equals(complainID(), that.complainID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(complainID());
    }

	public void setStatus(StatusInfo approved) {
		this.status=approved;
		
	}
}
