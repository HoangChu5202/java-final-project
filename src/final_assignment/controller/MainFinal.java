package src.final_assignment.controller;

import java.util.Scanner;

import src.final_assignment.model.CardHolder;
import src.final_assignment.utililties.*;

public class MainFinal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;  
        CardHolder cardHolder = new CardHolder();
        while (true) {
            String menuTitle = "Main Menu";
            String prompt = "Select an option";
            String[] menuOptions = {
                "Add a new card"
                , "View all cards"
                , "Sort cards by card's name"
                , "Update a card"
                , "Remove a card"
                , "Move a card to a new location"
                , "Swap location of two cards"
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            switch (choice) {
                case 1:
                    cardHolder.addCard(scanner);
                    break;
                case 2:
                    cardHolder.showAllCards();
                    break;
                case 3:
                    
                    break;
                case 4:
                    cardHolder.updateCard(scanner);
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