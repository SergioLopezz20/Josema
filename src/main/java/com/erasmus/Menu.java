package com.erasmus;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<University> universities;

    public Menu(List<University> universities) {
        this.universities = universities;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Select ETSISI subjects");
            System.out.println("2. View destination universities with convalidable subjects");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    selectEtsisiSubjects(scanner);
                    break;
                case 2:
                    viewDestinationUniversities();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void selectEtsisiSubjects(Scanner scanner) {
        System.out.print("Enter ETSISI subject: ");
        String etsisiSubject = scanner.nextLine();
        System.out.println("Selected ETSISI subject: " + etsisiSubject);
        // Add logic to handle selected ETSISI subject
    }

    private void viewDestinationUniversities() {
        System.out.println("Destination universities with convalidable subjects:");
        for (University university : universities) {
            System.out.println("University: " + university.getName() + ", Country: " + university.getCountry());
            for (Subject subject : university.getSubjects()) {
                System.out.println("  Destination Subject: " + subject.getName() + ", ETSISI Subject: " + subject.getEtsisiSubject() + ", Procede: " + subject.getProcede());
            }
        }
    }
}
