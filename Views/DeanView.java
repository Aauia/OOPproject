package Views;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Education.*;
import Main.*;
import User.*;

public class DeanView {
    private final Scanner in = new Scanner(System.in);
    private static final String DATA_FILE = "data.ser";

    // Save data to file

    private void save() throws IOException {
        Data.write();
    }

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

    public void addComplaint(String currentUserEmail) {
        System.out.println("Enter complaint details:");

        System.out.println("Enter complaint text:");
        String complainText = in.nextLine();

        System.out.println("Enter guilty party:");
        String complainGuilty = in.nextLine();

        System.out.println("Enter urgency level (LOW, MEDIUM, HIGH):");
        String urgencyInput = in.nextLine();
        UrgencyLevel levelOfUrgency = UrgencyLevel.valueOf(urgencyInput.toUpperCase());

        System.out.println("Enter number of students complained to:");
        int studentCount = in.nextInt();
        in.nextLine(); // consume the newline

        List<Student> complainedTo = new ArrayList<>(); // Список студентов, на которых будет подана жалоба

        // Отображаем список студентов для выбора
        System.out.println("Select students by their ID:");
        List<Student> allStudents = Data.INSTANCE.getStudents(); // Получаем всех студентов
        for (int i = 0; i < allStudents.size(); i++) {
            Student student = allStudents.get(i);
            System.out.println((i + 1) + ") ID: " + student.getStudentId() + " Name: " + student.getName());
        }

        // Пользователь вводит ID студентов, на которых он хочет подать жалобу
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Enter student number (1 to " + allStudents.size() + ") to complain about:");
            int studentNumber = in.nextInt();
            in.nextLine(); // consume the newline

            if (studentNumber >= 1 && studentNumber <= allStudents.size()) {
                Student selectedStudent = allStudents.get(studentNumber - 1);
                complainedTo.add(selectedStudent); // Добавляем студента в список complainedTo
            } else {
                System.out.println("Invalid student number. Please try again.");
                i--; // Повторим ввод для этого студента
            }
        }

        if (currentUserEmail == null || currentUserEmail.isEmpty()) {
            System.out.println("Error: No user is logged in. Cannot create complaint.");
            return;
        }

        // Создаем новый объект жалобы
        Complaint newComplaint = new Complaint();
        newComplaint.setComplainID(Data.INSTANCE.generateComplaintID()); // Генерация уникального ID
        newComplaint.setComplainSenderEmail(currentUserEmail); // Устанавливаем email текущего пользователя как отправителя
        newComplaint.setComplainText(complainText);
        newComplaint.setComplainGuilty(complainGuilty);
        newComplaint.setComplaintSeriousness(levelOfUrgency);
        newComplaint.setComplainedTo(complainedTo); // Устанавливаем список студентов
        newComplaint.setStatus(StatusInfo.IN_PROGRESS); // Статус по умолчанию - IN_PROGRESS

        // Добавляем жалобу в список жалоб
        Data.INSTANCE.getComplaints().add(newComplaint);
        System.out.println("Complaint added successfully with ID: " + newComplaint.getComplainID());
    }




    public void addRequest(String currentUserEmail) {
        System.out.println("Enter request details:");

        String deanName = "Dean";
        System.out.println("Enter request type (e.g., DORM_REQUEST, X_REQUEST, INQUIRY):");
        String requestTypeInput = in.nextLine();
        RequestType requestType = RequestType.valueOf(requestTypeInput.toUpperCase());

        System.out.println("Enter additional attribute for the request:");
        String additionalAttribute = in.nextLine();

        System.out.println("Enter request ID:");
        int requestID = in.nextInt();
        in.nextLine(); // consume the newline

        if (currentUserEmail == null || currentUserEmail.isEmpty()) {
            System.out.println("Error: No user is logged in. Cannot create request.");
            return;
        }

        StatusInfo status = StatusInfo.IN_PROGRESS;

        Request newRequest = new Request(requestID, status, deanName, requestType, additionalAttribute, currentUserEmail);
        Data.INSTANCE.getRequests().add(newRequest);
        System.out.println("Request added and status set to IN_PROGRESS!");
    }



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

  
    public void run() {
    // Load data at the beginning
        try {
            System.out.println("Welcome, Dean!");

            menu:
            while (true) {
                System.out.println("What do you want to do?\n1) Show complaints\n2) Approve complaint\n3) Disapprove complaint\n4) Show requests\n5) Approve request\n6) Disapprove request\n7) Add complaint\n8) Add request\n9) Exit");
                int choice = in.nextInt();
                in.nextLine(); // consume the newline

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
                        String loggedInEmail = UserSession.getInstance().getLoggedInEmail();
                        if (loggedInEmail != null) {
                            addComplaint(loggedInEmail); // Передаем email авторизованного пользователя в метод addComplaint
                        } else {
                            System.out.println("Error: No user is logged in. Cannot create a complaint.");
                        }
                        break;

                    case 8:
                        String currentUserEmail = UserSession.getInstance().getLoggedInEmail();
                        if (currentUserEmail != null) {
                            addRequest(currentUserEmail);
                        } else {
                            System.out.println("Error: No user is logged in. Cannot create a request.");
                        }
                        break;

                    case 9:
                        save(); // Save data before exiting
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
