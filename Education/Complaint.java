package Education;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import User.Dean;
import User.Student;
import User.Teacher;

public class Complaint {
    
    private Integer complainCode;
    private String complainText;
    private Teacher complainSender;
    private String complainGuilty;
    private UrgencyLevel levelOfUrgency;
    private List<Student> complainedTo;
    private Set<Student> students;
    private Set<Teacher> teachers;
    private Dean dean;
    
    
    // Getter and Setter Methods
    
    public Integer getComplainCode() {
        return this.complainCode;
    }
    
    public void setComplainCode(Integer complainCode) {
        this.complainCode = complainCode;
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
        return complainCode != null ? complainCode : -1;
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
        return Objects.equals(complainCode, that.complainCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(complainCode);
    }
}
