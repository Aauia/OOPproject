package Views;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Education.Complaint;
import Education.Request;
import Education.StatusInfo;
import Main.Data;

public class DeanView {
    private final Scanner in = new Scanner(System.in);

    // Display all complaints
    public void showComplaints() {
        List<Complaint> complaints = Data.INSTANCE.getComplaints();
        if (complaints.isEmpty()) {
            System.out.println("No complaints available.");
            return;
        }
        for (int i = 0; i < complaints.size(); i++) {
            System.out.println((i + 1) + ") " + complaints.get(i));
        }
    }

    // Approve a complaint
    public void approveComplaint() {
        System.out.println("Select complaint to approve by number:");
        showComplaints();
        int index = in.nextInt() - 1;
        if (index < 0 || index >= Data.INSTANCE.getComplaints().size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Complaint complaint = Data.INSTANCE.getComplaints().get(index);
        complaint.setStatus(StatusInfo.APPROVED);
        System.out.println("Complaint approved: " + complaint);
    }

    // Disapprove a complaint
    public void disapproveComplaint() {
        System.out.println("Select complaint to disapprove by number:");
        showComplaints();
        int index = in.nextInt() - 1;
        if (index < 0 || index >= Data.INSTANCE.getComplaints().size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Complaint complaint = Data.INSTANCE.getComplaints().get(index);
        complaint.setStatus(StatusInfo.REJECTED);
        System.out.println("Complaint disapproved: " + complaint);
    }

    // Display all requests
    public void showRequests() {
        List<Request> requests = Data.INSTANCE.getRequests();
        if (requests.isEmpty()) {
            System.out.println("No requests available.");
            return;
        }
        for (int i = 0; i < requests.size(); i++) {
            System.out.println((i + 1) + ") " + requests.get(i));
        }
    }

    // Approve a request
    public void approveRequest() {
        System.out.println("Select request to approve by number:");
        showRequests();
        int index = in.nextInt() - 1;
        if (index < 0 || index >= Data.INSTANCE.getRequests().size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Request request = Data.INSTANCE.getRequests().get(index);
        request.setStatus(StatusInfo.APPROVED);
        System.out.println("Request approved: " + request);
    }

    // Disapprove a request
    public void disapproveRequest() {
        System.out.println("Select request to disapprove by number:");
        showRequests();
        int index = in.nextInt() - 1;
        if (index < 0 || index >= Data.INSTANCE.getRequests().size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Request request = Data.INSTANCE.getRequests().get(index);
        request.setStatus(StatusInfo.REJECTED);
        System.out.println("Request disapproved: " + request);
    }

    // Menu for dean actions
    public void run() {
        try {
            System.out.println("Welcome, Dean!");

            menu:
            while (true) {
                System.out.println("What do you want to do?\n1) Show complaints\n2) Approve complaint\n3) Disapprove complaint\n4) Show requests\n5) Approve request\n6) Disapprove request\n7) Exit");
                int choice = in.nextInt();

                switch (choice) {
                    case 1:
                        showComplaints();
                        break;
                    case 2:
                        approveComplaint();
                        break;
                    case 3:
                        disapproveComplaint();
                        break;
                    case 4:
                        showRequests();
                        break;
                    case 5:
                        approveRequest();
                        break;
                    case 6:
                        disapproveRequest();
                        break;
                    case 7:
                        System.out.println("Goodbye, Dean!");
                        break menu;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
            e.printStackTrace();
        }
    }
}
