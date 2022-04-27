package src.final_assignment.controller;

import java.util.Scanner;

import src.final_assignment.model.Library;
import src.utilities.UIUtility;

public class MainFinal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;  
        Library library = new Library();
        while (true) {
            String menuTitle = "Main Menu";
            String prompt = "Select an option";
            String[] menuOptions = {
                "Add a new book"
                , "View all books"
                , "Sort books by title"
                , "Update a book"
                , "Remove a book"
                , "Move a book to a new location"
                , "Swap locations of two books"
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            switch (choice) {
                case 1:
                    library.addBook(scanner);
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
            }
            UIUtility.pressEnterToContinue(scanner);
        }
       System.out.println("\nProgram complete. Goodbye.\n");
       scanner.close();
    }   
}
