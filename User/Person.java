package User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import Education.*;

public abstract class Person implements Serializable, Observer {
    
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
    protected String name;
    private String surname;
    private String middleName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String nationality;
    private Integer phoneNumber;
    private String email;
    private FamilyStatuses familyStatus;
    private String corporateEmail;
    private Map<Book, LocalDate> borrowedBooks;
    
    public Person(String login, String password, String name, String surname, String middleName,
            LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber,
            String email,FamilyStatuses familyStatus, String corporateEmail) {
    this.login = login;
    this.password = password;
    this.name = name;
    this.surname = surname;
    this.middleName = middleName;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.nationality = nationality;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.familyStatus = familyStatus;
    this.corporateEmail = corporateEmail;
    this.borrowedBooks = new HashMap<>();
    }
    
    public Person() {
    	this.borrowedBooks = new HashMap<>();
    	}

	public String getLogin() {
    	return login;
    }
    public void setLogin(String login) {
    	this.login=login;
    }
    public String getPassword() {
    	return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FamilyStatuses getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(FamilyStatuses familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getCorporateEmail() {
        return corporateEmail;
    }

    public void setCorporateEmail(String corporateEmail) {
        this.corporateEmail = corporateEmail;
    }
    
    public Map<Book, LocalDate> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Borrow a book
    public void borrowBook(Book book) {
    	 if (this.borrowedBooks == null) {
    	        this.borrowedBooks = new HashMap<>(); // Initialize if null
    	    }
    	 if (book.getQuantity() > 0) {
    	        borrowedBooks.put(book, LocalDate.now().plusMonths(6)); // Set due date 6 months later
    	    } else {
    	        System.out.println("Sorry, the book is out of stock.");
    	    }
    	 }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
    public void resetBorrowedBooks() {
        borrowedBooks.clear();  // Clears the borrowed books list/map
    }

    public void viewBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has not borrowed any books.");
        } else {
            System.out.println("My Borrowed Books:");
            for (Map.Entry<Book, LocalDate> entry : borrowedBooks.entrySet()) {
                System.out.println(" - " + entry.getKey().getTitle() + " (Due: " + entry.getValue() + ")");
            }
        }
    }
    
    public boolean login(String password) {
        return this.password.equals(password);
    }
    public void logOut() {
    	
    }

	@Override
	public String toString() {
		return "Person [login=" + login + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", middleName=" + middleName + ", dateOfBirth=" + dateOfBirth + ", nationality=" + nationality
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", familyStatus=" + familyStatus
				+ ", corporateEmail=" + corporateEmail + "]";
	}
	
	@Override
	public void update(ResearchPaper paper) {
		// TODO Auto-generated method stub
		
	}
    
}