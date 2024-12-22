package Views;

import Education.Journal;
import Education.ResearchPaper;
import Education.ResearchProject;
import Main.Data;
import Main.UserSession;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ResearcherView {
    private final Scanner scanner = new Scanner(System.in);

    public ResearcherView() {
        // Получаем текущего пользователя из сессии
        UserSession userSession = UserSession.getInstance();
        
        // Проверяем, если пользователь не залогинен
        if (!userSession.isLoggedIn()) {
            System.out.println("No user is logged in.");
            return;
        }
        
        // Получаем email текущего пользователя
        String currentUserEmail = userSession.getLoggedInEmail();
        
       
    }

    public void showResearcherMenu() {
        while (true) {  // Start an infinite loop to keep showing the menu until exit is chosen
            System.out.println("Researcher Menu:");
            System.out.println("1. Add Research Paper");
            System.out.println("2. Add Research Project");
            System.out.println("3. Print All Research Papers");
            System.out.println("4. Print My Research Papers");
            System.out.println("5. Calculate H-Index");
            System.out.println("6. Print Research Projects");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addResearchPaper();
                    break;
                case 2:
                    addResearchProject();
                    break;
                case 3:
                    printResearchPapers();
                    break;
                case 4:
                    printMyResearchPapers();
                    break;
                case 5:
                    calculateHIndex();
                    break;
                case 6:
                    printResearchProjects();
                    break;
                case 7:
                    System.out.println("Exiting Researcher Menu...");
                    return; // Exit the method and return control to the previous menu
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }


    private void addResearchPaper() {
        System.out.print("Enter paper title: ");
        String title = scanner.nextLine();
        System.out.print("Enter paper category: ");
        String category = scanner.nextLine();
        System.out.print("Enter number of citations: ");
        int citations = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Получаем email текущего пользователя
        UserSession userSession = UserSession.getInstance();
        String currentUserEmail = userSession.getLoggedInEmail();

        // Создаем исследовательскую работу без создания объекта Researcher
        ResearchPaper paper = new ResearchPaper(title, category, citations);
        paper.addAuthor(currentUserEmail); // Используем email текущего пользователя как автора

        Data.INSTANCE.addResearchPaper(paper);
        
        Journal journal = findJournalByCategory(category);
        if (journal != null) {
            journal.publish(paper);
            System.out.println("Research paper added and published in the journal: " + journal.getName());
        } else {
            System.out.println("No journal found for the category: " + category);
        }
        save();
    }
    
    private Journal findJournalByCategory(String category) {
        // Find the journal by category, assuming there is a list of journals
        List<Journal> journals = Data.INSTANCE.getJournals();
        for (Journal journal : journals) {
            // Assuming a journal can have multiple categories, you can modify this logic
            if (journal.getName().equalsIgnoreCase(category)) {
                return journal;
            }
        }
        return null; // Return null if no journal was found for the category
    }

    private void addResearchProject() {
        System.out.print("Enter project topic: ");
        String topic = scanner.nextLine();

        System.out.print("Enter number of papers to add: ");
        int numberOfPapers = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Выводим доступные исследовательские работы
        List<ResearchPaper> papers = Data.INSTANCE.getResearchPapers();
        System.out.println("Available Research Papers:");
        for (int i = 0; i < papers.size(); i++) {
            System.out.println((i + 1) + ". " + papers.get(i).getTitle());
        }

        // Выбираем исследовательские работы для добавления в проект
        for (int i = 0; i < numberOfPapers; i++) {
            System.out.print("Enter paper number: ");
            int paperNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (paperNumber > 0 && paperNumber <= papers.size()) {
                ResearchProject project = new ResearchProject(topic);
                project.addPublishedPaper(papers.get(paperNumber - 1)); // Добавляем выбранную работу в проект
                Data.INSTANCE.addResearchProject(project);
                System.out.println("Research project added.");
            } else {
                System.out.println("Invalid paper number.");
            }
        }

        save();
    }

    private void printResearchPapers() {
        System.out.println("\nAll Research Papers:");
        List<ResearchPaper> papers = Data.INSTANCE.getResearchPapers();
        if (papers.isEmpty()) {
            System.out.println("No research papers found.");
        } else {
            for (ResearchPaper paper : papers) {
                System.out.println("Title: " + paper.getTitle() + ", Category: " + paper.getCategory()
                        + ", Citations: " + paper.getCitations() + ", Authors: " + paper.getAuthors());
            }
        }
    }

    private void printMyResearchPapers() {
        System.out.println("\nMy Research Papers:");
        List<ResearchPaper> myPapers = getMyResearchPapers();
        if (myPapers.isEmpty()) {
            System.out.println("No research papers found.");
        } else {
            for (ResearchPaper paper : myPapers) {
                System.out.println("Title: " + paper.getTitle() + ", Category: " + paper.getCategory()
                        + ", Citations: " + paper.getCitations());
            }
        }
    }

    private List<ResearchPaper> getMyResearchPapers() {
        UserSession userSession = UserSession.getInstance();
        String currentUserEmail = userSession.getLoggedInEmail();

        List<ResearchPaper> myPapers = Data.INSTANCE.getResearchPapers();
        myPapers.removeIf(paper -> !paper.getAuthors().contains(currentUserEmail)); // Убираем работы, где текущий пользователь не автор

        return myPapers;
    }

    private void calculateHIndex() {
        // Для простоты можно добавить функциональность для вычисления H-индекса (например, на основе количества цитирований)
        System.out.println("Calculating H-Index...");
        // Реализация расчета H-индекса
    }

    private void printResearchProjects() {
        System.out.println("\nResearch Projects:");
        List<ResearchProject> projects = Data.INSTANCE.getResearchProjects();
        for (ResearchProject project : projects) {
            System.out.println("Topic: " + project.getTopic());
            System.out.println("Participants: " + project.getParticipants());
            System.out.println("Papers: " + project.getPublishedPapers());
        }
    }

    private void save() {
        try {
            Data.write();
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
