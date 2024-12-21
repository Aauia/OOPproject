package Education;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import User.Student;
import User.Teacher;

public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer complainID;
    private String complainText;
    private String complainSenderEmail; // Email отправителя
    private String complainGuilty;
    private UrgencyLevel levelOfUrgency;
    private StatusInfo status;
    private List<Student> complainedTo; // Список студентов, на которых подана жалоба

    // Конструкторы
    public Complaint() {
        this.complainedTo = new ArrayList<>(); // Инициализация списка студентов
    }

    public Complaint(Integer complainID, String complainText, Teacher complainSender, String complainSenderEmail,
                     String complainGuilty, UrgencyLevel levelOfUrgency, StatusInfo status) {
        this.complainID = complainID;
        this.complainText = complainText;
        this.complainSenderEmail = complainSenderEmail;
        this.complainGuilty = complainGuilty;
        this.levelOfUrgency = levelOfUrgency;
        this.status = status;
        this.complainedTo = new ArrayList<>(); // Инициализация списка студентов
    }

    // Getter и Setter методы
    public Integer getComplainID() {
        return this.complainID;
    }

    public void setComplainID(Integer complainID) {
        this.complainID = complainID;
    }

    public String getComplainText() {
        return this.complainText;
    }

    public void setComplainText(String complainText) {
        this.complainText = complainText;
    }


    public String getComplainSenderEmail() {
        return this.complainSenderEmail;
    }

    public void setComplainSenderEmail(String complainSenderEmail) {
        this.complainSenderEmail = complainSenderEmail;
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

    public void setComplaintSeriousness(UrgencyLevel levelOfUrgency) {
        this.levelOfUrgency = levelOfUrgency;
    }

    public StatusInfo getStatus() {
        return this.status;
    }

    public void setStatus(StatusInfo status) {
        this.status = status;
    }

    public List<Student> getComplainedTo() {
        return this.complainedTo;
    }

    public void setComplainedTo(List<Student> complainedTo) {
        this.complainedTo = complainedTo;
    }


    public String sendComplaintToStudents(List<Student> students) {
        StringBuilder result = new StringBuilder("Complaint Sent to Students: ");
        // Перебираем список студентов, которым отправляется жалоба
        for (Student student : students) {
            result.append(student.getName()).append(" (ID: ").append(student.getStudentId()).append("), ");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint that = (Complaint) o;
        return Objects.equals(getComplainID(), that.getComplainID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComplainID());
    }

    @Override
    public String toString() {
        return "Complaint [complainID=" + complainID + ", complainText=" + complainText +  ", complainSenderEmail=" + complainSenderEmail + ", complainGuilty=" + complainGuilty
                + ", levelOfUrgency=" + levelOfUrgency + ", status=" + status + ", complainedTo=" + complainedTo + "]";
    }
}




