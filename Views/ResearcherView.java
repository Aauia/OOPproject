package Views;

import User.Researcher;
import Education.ResearchPaper;
import Education.ResearchProject;
import Main.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResearcherView {
    private final Scanner scanner = new Scanner(System.in);
    private final Researcher researcher;

    public ResearcherView(Researcher researcher) {
        this.researcher = researcher;
    }
    public ResearcherView() {
		this.researcher = new Researcher();
    	
    }

    public void run() {
        while (true) {
            System.out.println("\nResearcher Menu:");
            System.out.println("1. Add Research Paper");
            System.out.println("2. Add Research Project");
            System.out.println("3. Print All Research Papers");
            System.out.println("4. Print My Research Papers");
            System.out.println("5. Calculate H-Index");
            System.out.println("6. Print Research Projects");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addResearchPaper();
                case 2 -> addResearchProject();
                case 3 -> printResearchPapers();
                case 4 -> printMyResearchPapers();
                case 5 -> System.out.println("H-Index: " + calculateHIndex());
                case 6 -> printResearchProjects();
                case 7 -> {
                    save();
                    System.out.println("Exiting Researcher Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
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

        ResearchPaper paper = new ResearchPaper(title, category, citations);
        paper.addAuthor(researcher);

        Data.INSTANCE.addResearchPaper(paper);
        save();
        System.out.println("Research paper added.");
    }

    private void addResearchProject() {
        System.out.print("Enter project topic: ");
        String topic = scanner.nextLine();

        ResearchProject project = new ResearchProject(topic);

        // Add published papers
        System.out.println("\nAvailable Research Papers:");
        List<ResearchPaper> availablePapers = Data.INSTANCE.getResearchPapers();
        if (availablePapers.isEmpty()) {
            System.out.println("No available research papers.");
        } else {
            for (int i = 0; i < availablePapers.size(); i++) {
                System.out.println((i + 1) + ". " + availablePapers.get(i).getTitle());
            }

            System.out.print("Enter number of papers to add: ");
            int numPapers = scanner.nextInt();
            scanner.nextLine(); // consume newline
            for (int i = 0; i < numPapers; i++) {
                System.out.print("Enter paper number: ");
                int paperChoice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (paperChoice > 0 && paperChoice <= availablePapers.size()) {
                    project.addPublishedPaper(availablePapers.get(paperChoice - 1));
                } else {
                    System.out.println("Invalid paper choice.");
                }
            }
        }

        // Add participants
        System.out.println("\nAvailable Researchers:");
        List<Researcher> availableResearchers = Data.INSTANCE.getResearchers();
        if (availableResearchers.isEmpty()) {
            System.out.println("No available researchers.");
        } else {
            for (int i = 0; i < availableResearchers.size(); i++) {
                System.out.println((i + 1) + ". " + availableResearchers.get(i).getName());
            }

            System.out.print("Enter number of participants to add: ");
            int numParticipants = scanner.nextInt();
            scanner.nextLine(); // consume newline
            for (int i = 0; i < numParticipants; i++) {
                System.out.print("Enter participant number: ");
                int participantChoice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (participantChoice > 0 && participantChoice <= availableResearchers.size()) {
                    Researcher selectedParticipant = availableResearchers.get(participantChoice - 1);
                    project.addParticipant(selectedParticipant);
                } else {
                    System.out.println("Invalid participant choice.");
                }
            }
        }

        Data.INSTANCE.addResearchProject(project);
        save();
        System.out.println("Research project added.");
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
        List<ResearchPaper> myPapers = new ArrayList<>();
        for (ResearchPaper paper : Data.INSTANCE.getResearchPapers()) {
            if (paper.getAuthors().contains(researcher)) {
                myPapers.add(paper);
            }
        }
        return myPapers;
    }
    private int calculateHIndex() {
        // Получаем только статьи текущего исследователя
        List<ResearchPaper> myPapers = getMyResearchPapers();

        // Извлекаем количество цитирований для каждой статьи и сортируем в порядке убывания
        List<Integer> citationCounts = myPapers.stream()
                .map(ResearchPaper::getNumberOfCitations)
                .sorted((a, b) -> b - a)
                .toList();

        int hIndex = 0;
        // Рассчитываем H-индекс
        for (int i = 0; i < citationCounts.size(); i++) {
            if (citationCounts.get(i) >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }


    private void printResearchProjects() {
        System.out.println("\nResearch Projects:");
        List<ResearchProject> projects = Data.INSTANCE.getResearchProjects();
        if (projects.isEmpty()) {
            System.out.println("No research projects found.");
        } else {
            for (ResearchProject project : projects) {
                System.out.println("Topic: " + project.getTopic());
                System.out.println("Participants: " + project.getParticipants());
                System.out.println("Papers: " + project.getPublishedPapers());
                System.out.println("---------------------------");
            }
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
    public void showResearcherMenu() {
        while (true) {
            System.out.println("\nResearcher Menu:");
            System.out.println("1. Add Research Paper");
            System.out.println("2. Add Research Project");
            System.out.println("3. Print All Research Papers");
            System.out.println("4. Print My Research Papers");
            System.out.println("5. Calculate H-Index");
            System.out.println("6. Print Research Projects");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addResearchPaper();
                case 2 -> addResearchProject();
                case 3 -> printResearchPapers();
                case 4 -> printMyResearchPapers();
                case 5 -> System.out.println("H-Index: " + calculateHIndex());
                case 6 -> printResearchProjects();
                case 7 -> {
                    save();
                    System.out.println("Exiting Researcher Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
