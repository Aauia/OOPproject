package User;

import java.util.List;
import java.util.Observable;

import Education.*;
public class Librarian extends Employee {

    private Book book;
    private Integer quantity;
    private Library library;

    public Librarian(String login, String password, String name, String surname, String middleName,
                     LocalDate dateOfBirth, Gender gender, String nationality, Integer phoneNumber,
                     String email, FamilyStatuses familyStatus, String corporateEmail,
                     double salary, String timeOfExperience, boolean isResearcher,
                     Book book, Integer quantity, Library library) {
        super(login, password, name, surname, middleName, dateOfBirth, gender, nationality, phoneNumber,
              email, familyStatus, corporateEmail, salary, timeOfExperience, isResearcher);
        this.book = book;
        this.quantity = quantity;
        this.library = library;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Book seeBookInfo() {
        return this.book;
    }

    public boolean isBookAvailable() {
        return this.quantity > 0;
    }

    public void addBooksToLibrary(int quantityToAdd) {
        this.quantity += quantityToAdd;
    }

    public boolean issueBook() {
        if (isBookAvailable()) {
            this.quantity--;
            return true;
        } else {
            System.out.println("Book is not available.");
            return false;
        }
    }

    public void returnBook() {
        this.quantity++;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "book=" + book +
                ", quantity=" + quantity +
                ", library=" + library +
                "} " + super.toString();
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}

