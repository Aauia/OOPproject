package User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Education.Complaint;
import Education.Request;
import Education.StatusInfo;

public class Dean extends Employee {
	private static final long serialVersionUID = 1L;
	private List<Request> requests;  
    private List<Complaint> complaints;  

    public Dean(String login, String password, String name, String surname, String middleName, 
                LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber, 
                String email, FamilyStatuses familyStatus, String corporateEmail, 
                double salary, String timeOfExperience, boolean isResearcher) {
        super(login, password, name, surname, middleName, dateOfBirth, gender, nationality, phoneNumber, 
              email, familyStatus, corporateEmail, salary, timeOfExperience, isResearcher);
        this.complaints = new ArrayList<>(); 
        this.requests = new ArrayList<>(); 
        
        if (isResearcher) {
            this.setAsResearcher(true); 
        }
    }


    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public void addComplaint(Complaint complaint) {
        if (complaint == null) {
            throw new IllegalArgumentException("Complaint cannot be null.");
        }
        this.complaints.add(complaint);
    }

    public void approveRequest(StatusInfo status) {
        if (status != null) {
            for (Request req : requests) {
                req.setStatus(status);  
            }
        } else {
            System.out.println("Invalid status.");
        }
    }

    public void viewComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints available.");
        } else {
            for (Complaint complaint : complaints) {
                System.out.println("Complaint: " + complaint.toString());
            }
        }
    }

    public void addRequest(Request request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null.");
        }
        this.requests.add(request);
    }

    public void viewRequests() {
        if (requests.isEmpty()) {
            System.out.println("No requests available.");
        } else {
            for (Request request : requests) {
                System.out.println("Request: " + request.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Dean{" +
                "requests=" + requests +
                ", complaints=" + complaints +
                "} " + super.toString();
    }

    @Override
    public void update(Observable o, Object arg) {
     
    }
}
