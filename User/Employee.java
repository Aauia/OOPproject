package User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Education.Request;
public abstract class Employee extends Person {
	private static final long serialVersionUID = 1L;
	private double salary;
    private String timeOfExperience;
    private ArrayList<Request> requests;
    private Set<EmployeeResearcher> employeeResearchers;

    public Employee(String login, String password, String name, String surname, String middleName,
                    LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber, String email,
                    FamilyStatuses familyStatus, String corporateEmail, double salary,
                    String timeOfExperience) {
        super(login, password, name, surname, middleName, dateOfBirth, gender, nationality, phoneNumber, email,
                familyStatus, corporateEmail);
        this.salary = salary;
        this.timeOfExperience = timeOfExperience;
        this.requests = new ArrayList<>(); 
        this.employeeResearchers = new HashSet<>(); 
    } 
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }
        this.salary = salary;
    }
    public String getTimeOfExperience() {
        return timeOfExperience;
    }

    public void setTimeOfExperience(String timeOfExperience) {
        this.timeOfExperience = timeOfExperience;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

    public Set<EmployeeResearcher> getEmployeeResearchers() {
        return employeeResearchers;
    }

    public void setEmployeeResearchers(Set<EmployeeResearcher> employeeResearchers) {
        this.employeeResearchers = employeeResearchers;
    }
    public void addRequest(Request request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null.");
        }
        this.requests.add(request);
    }

    public void addEmployeeResearcher(EmployeeResearcher researcher) {
        if (researcher == null) {
            throw new IllegalArgumentException("EmployeeResearcher cannot be null.");
        }
        this.employeeResearchers.add(researcher);
    }
    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", timeOfExperience='" + timeOfExperience + '\'' +
                ", requests=" + requests +
                ", employeeResearchers=" + employeeResearchers +
                "} " + super.toString();
    }
}
