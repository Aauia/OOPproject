package Views;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import Main.Data;
import Main.UserSession;
import User.*;
import Education.*;

public class BaseView {
    private final String login;
    private final String password;
    private static Person user; // Declare the user object

    // Constructor
    public BaseView(String login, String password) throws IOException {
        this.login = login;
        this.password = password;

        // Authenticate user and show the respective view
        this.user = Data.findUserByLoginAndPassword(login, password);
        if (user != null) {
            if (user instanceof Admin) {
                showAdmin(user);
            } else if (user instanceof Student) {
                showStudent(user);
            }
               else if (user instanceof Teacher) {
                    showTeacher(user);
               } 
               else if (user instanceof Librarian) {
                   try {
					showLibrarian(user);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               }
               else if (user instanceof Dean) {
            	   showDean(user);
               }
               else if (user instanceof Manager) {
            	   showManager(user);
               }
            
                
            } 
         else {
            System.out.println("Invalid login or password.");
        }
    }

    // Getter for user
    public Person getUser() {
        return user;
    }

    // Create instances of AdminView and StudentView
    private static final adminView adminView1 = new adminView(); // Corrected to AdminView
    private static final StudentView studentView = new StudentView();
    private static final TeacherView teacherView = new TeacherView();
    private static final LibrarianView librarianView = new LibrarianView();
    private static final DeanView deanView = new DeanView();
    private static final ResearcherView researcherView = new ResearcherView();
    private static final ManagerView managerView = new ManagerView();

    // Base menu for common options
    public static void showBaseMenu() {
        System.out.println("1. Manage Researchers");
        System.out.println("2. Manage Journals");
        System.out.println("3. Manage News");
        System.out.println("4. Manage Books");
        
    }

    // Show Admin menu
    public void showAdmin(Person user) {
        showBaseMenu(); // Common options
        System.out.println("5. Manage Students");
        System.out.println("6. Exit");
        handleAdminChoice();
    }

    // Show Student menu
    public void showStudent(Person user) {
        showBaseMenu(); // Common options
        System.out.println("5. View Courses");
        System.out.println("6. Exit");
        handleStudentChoice();
    }

    // Show Teacher menu
    public void showTeacher(Person user) {
        showBaseMenu(); // Common options
        System.out.println("5. Manage Classes");
        System.out.println("6. Exit");
        handleTeacherChoice();
    }
    public static void showLibrarian(Person user) throws IOException {
        showBaseMenu();
        System.out.println("5. Librarian Menu");
        System.out.println("6. Exit");
        handleLibrarianChoice(user);
    }
    
    public static void showDean(Person user) throws IOException {
        showBaseMenu();
        System.out.println("5. Dean Menu");
        System.out.println("6. Exit");
        handleDeanChoice(user);
    }
    
    public static void showManager(Person user) throws IOException {
        showBaseMenu();
        System.out.println("5. Manager Menu");
        System.out.println("6. Exit");
        handleManagerChoice(user);
    }
    
    private static final Scanner scanner = new Scanner(System.in);
      
    // Admin choice handler
    private void handleAdminChoice() {
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
            	 if (UserSession.getInstance().isResearcher()) {
            		 researcherView.showResearcherMenu(); // Если пользователь исследователь, показываем меню
                 } else {
                     System.out.println("Access denied. You are not a researcher.");
                     break;
                 }
                 break;
            case 2:
            	manageJournals(user);
                break;
            case 3:
            	viewNews();
            	break;
            case 4 : 
            	libraryMenu(user);
			try {
				showLibrarian(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            	break;
            	
            case 5:
                try {
                    adminView1.run(); // Call AdminView's run method
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                System.out.println("Exiting Admin Menu...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                showAdmin(user);
        }
    }
    
    private static void handleManagerChoice(Person user) {
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
            	 if (UserSession.getInstance().isResearcher()) {
            		 researcherView.showResearcherMenu(); // Если пользователь исследователь, показываем меню
                 } else {
                     System.out.println("Access denied. You are not a researcher.");
                     break;
                 }
                 break;
            case 2:
            	manageJournals(user);
                break;
            case 3:
            	viewNews();
            	break;
            case 4 : 
            	libraryMenu(user);
			try {
				showLibrarian(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            	break;
            	
            case 5:
                try {
                    managerView.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                System.out.println("Exiting Admin Menu...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
			try {
				showManager(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    // Student choice handler
    private void handleStudentChoice() {
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
            	 if (UserSession.getInstance().isResearcher()) {
            		 researcherView.showResearcherMenu(); // Если пользователь исследователь, показываем меню
                 } else {
                     System.out.println("Access denied. You are not a researcher.");
                 }
            case 2:
            	manageJournals(user);
                break;
            case 3:
            	viewNews();
                break;
            case 4 : 
            	libraryMenu(user);
			try {
				showLibrarian(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            	break;
            case 5:
                System.out.println("Manage courses");
                try {
                    studentView.menu((Student) user); // Pass the correct object here
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                System.out.println("Exiting Student Menu...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                showStudent(user);
        }
    }

    // Teacher choice handler
    private void handleTeacherChoice() {

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
            	 if (UserSession.getInstance().isResearcher()) {
            		 researcherView.showResearcherMenu(); // Если пользователь исследователь, показываем меню
                 } else {
                     System.out.println("Access denied. You are not a researcher.");
                 }
            case 2:
            	manageJournals(user);
                break;
            case 3:
            	viewNews();
                break;
            case 4 : 
            	libraryMenu(user);
			try {
				showLibrarian(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            	break;
            case 5:
                System.out.println("Managing Classes");
                try {
                	teacherView.menu((Teacher) user); // Pass the correct object here
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                break;
            case 6:
                System.out.println("Exiting Teacher Menu...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                showTeacher(user);
        }
    }


    private static void handleLibrarianChoice(Person user) throws IOException {
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
            	 if (UserSession.getInstance().isResearcher()) {
            		 researcherView.showResearcherMenu(); // Если пользователь исследователь, показываем меню
                 } else {
                     System.out.println("Access denied. You are not a researcher.");
                 }
            case 2:
            	manageJournals(user);
            	break;
            case 3:
            	viewNews();
            	break;
            case 4:
            	libraryMenu(user);
            	showLibrarian(user);
            	break;
            case 5:
			try {
				try {
					librarianView.run();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            case 6:
            	exitMenu();
            	break;
            default:
            	invalidChoice(() -> {
					try {
						showLibrarian(user);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
        }
    }
    private static void handleDeanChoice(Person user) throws IOException {
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
            	 if (UserSession.getInstance().isResearcher()) {
            		 researcherView.showResearcherMenu(); // Если пользователь исследователь, показываем меню
                 } else {
                     System.out.println("Access denied. You are not a researcher.");
                 }
            case 2:
            	manageJournals(user);
            	break;
            case 3:
            	viewNews();
            	break;
            case 4:
            	libraryMenu(user);
            	break;
            case 5:
			try {
				try {
					deanView.run();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            default:
            	invalidChoice(() -> {
					try {
						showLibrarian(user);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
        }
        }
    
 // Adding the new Journal-related options in the "Managing Journals" section.
    private static void manageJournals(Person user) {
        System.out.println("\n=== Journals ===");
        List<Journal> journals = Data.INSTANCE.getJournals(); // Fetch the list of journals

        if (journals.isEmpty()) {
            System.out.println("No journals are available.");
        } else {
            for (int i = 0; i < journals.size(); i++) {
                System.out.println((i + 1) + ". " + journals.get(i).getName());
            }
            System.out.println("Enter the number of the journal to manage, or 0 to return to the main menu:");
            int journalChoice = scanner.nextInt();
            if (journalChoice == 0) {
                return; // Exit back to the main menu
            }

            if (journalChoice > 0 && journalChoice <= journals.size()) {
                Journal selectedJournal = journals.get(journalChoice - 1);
                manageJournalSubscriptions(user, selectedJournal);
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void manageJournalSubscriptions(Person user, Journal journal) {
        // Check if the user is already subscribed
        if (journal.isSubscribed(user)) {
            System.out.println("You are already subscribed to the " + journal.getName() + " journal.");
            System.out.println("1. View Papers");
            System.out.println("2. Unsubscribe");
            System.out.println("3. Exit to Main Menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewPapers(journal);
                    break;
                case 2:
                    journal.unsubscribe(user);
                    System.out.println("You have unsubscribed from " + journal.getName() + ".");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
                    manageJournalSubscriptions(user, journal);
            }
        } else {
            System.out.println("You are not subscribed to the " + journal.getName() + " journal.");
            System.out.println("1. Subscribe");
            System.out.println("2. Exit to Main Menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    journal.subscribe(user);
                    System.out.println("You have subscribed to " + journal.getName() + ".");
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
                    manageJournalSubscriptions(user, journal);
            }
        }
    }

    private static void viewPapers(Journal journal) {
        System.out.println("\n=== " + journal.getName() + " Papers ===");
        List<ResearchPaper> papers = journal.getPapers();

        if (papers.isEmpty()) {
            System.out.println("No papers available in this journal.");
        } else {
            for (ResearchPaper paper : papers) {
                System.out.println(paper.getTitle() + " by " + paper.getAuthors());
            }
        }

        System.out.println("1. Return to Journal Management");
        System.out.println("2. Exit to Main Menu");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageJournalSubscriptions(user, journal);
                break;
            case 2:
                return;
            default:
                System.out.println("Invalid choice, try again.");
                viewPapers(journal);
        }
    }

    
    private static void viewNews() {
        System.out.println("Displaying News...");
        Data.INSTANCE.getNewsList().forEach(System.out::println);
    }

    private static void libraryMenu(Person loggedInPerson) {
        System.out.println("Library Menu...");
        // Call library-related functionality
        boolean exitLibraryMenu = false;

        while (!exitLibraryMenu) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. View Library");
            System.out.println("2. My Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Report Lost Book");
            System.out.println("6. Back to Main Menu");
            System.out.println();
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewLibrary();
                    break;
                case 2:
                    myBooks(loggedInPerson);
                    break;
                case 3:
                    borrowBook(loggedInPerson);
                    break;
                case 4:
                    returnBook(loggedInPerson);
                    break;
                case 5:
                    reportLostBook(loggedInPerson);
                    break;
                case 6:
                    exitLibraryMenu = true;
                    break;
                case 7:
                	resetLibrary(loggedInPerson);
                	break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void viewLibrary() {
        System.out.println("\n=== Library Books ===");
        Vector<Book> books = Data.INSTANCE.getBooks();

        if (books.isEmpty()) {
            System.out.println("No books are available in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
    }

    private static void myBooks(Person loggedInPerson) {
        System.out.println("\n=== My Borrowed Books ===");
        if (loggedInPerson.getBorrowedBooks() == null || loggedInPerson.getBorrowedBooks().isEmpty()) {
            System.out.println("You have not borrowed any books.");
        } else {
            loggedInPerson.viewBorrowedBooks();
        }
    }
    private static void resetLibrary(Person loggedInPerson) {
            loggedInPerson.resetBorrowedBooks();
        
    }

    private static void borrowBook(Person user) { 
        System.out.print("Enter the title of the book you want to borrow: ");
        String bookTitle = scanner.nextLine();

        Book book = findBook(bookTitle);
        if (book != null && book.getQuantity() > 0) {
        	user.borrowBook(book);
            book.borrow();

            System.out.println("You have successfully borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, this book is currently unavailable.");
        }
    }


    private static void returnBook(Person loggedInPerson) {
        System.out.print("Enter the title of the book you want to return: ");
        String bookTitle = scanner.nextLine();

        Book book = findBook(bookTitle);
        if (book != null && loggedInPerson.getBorrowedBooks().containsKey(book)) {
            loggedInPerson.returnBook(book);
            book.returnBook();
            System.out.println("You have successfully returned the book: " + book.getTitle());
        } else {
            System.out.println("You do not have this book.");
        }
    }

    private static void reportLostBook(Person loggedInPerson) {
        System.out.print("Enter the title of the lost book: ");
        String bookTitle = scanner.nextLine();

        Book book = findBook(bookTitle);
        if (book != null && loggedInPerson.getBorrowedBooks().containsKey(book)) {
            loggedInPerson.returnBook(book);
            double fine = book.getPrice() * 2;
            System.out.println("The book has been marked as lost. Fine: $" + fine);
        } else {
            System.out.println("You do not have this book.");
        }
    }


    private static Book findBook(String bookTitle) {
        for (Book book : Data.INSTANCE.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                return book;
            }
        }
        return null;
    }


    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void invalidChoice(Runnable retryMenu) {
        System.out.println("Invalid choice. Try again.");
        retryMenu.run();
    }
    private static void exitMenu() {
        System.out.println("Exiting... Goodbye!");
    }
    
}
