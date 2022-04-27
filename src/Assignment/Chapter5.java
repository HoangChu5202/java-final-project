package src.Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Chapter5 implements TaskHandler{
    @Override
    public void handleTask(Scanner in) {
        int choice = 0;
        while (true) {
            String menuTitle = "Chapter 5 Menu";
            String prompt = "Select an exercise";
            String[] menuOptions = {
                    "Exercise 1", "Exercise 2"
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, in);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            switch (choice) {
                case 1:
                    exercise1(in);
                    break;
                case 2:
                    exercise2(in);
                    break;
            }
            UIUtility.pressEnterToContinue(in);
        }
        System.out.println("\nExiting Chapter 5 Menu.");
    }

    private void exercise1(Scanner in) {
        ArrayList<Integer> odd = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();
        Integer num;
        String input = "";
        System.out.println("Enter some number, type S to stop:");
        while (!input.equalsIgnoreCase("S")) {
            input = in.nextLine();
            try {
                num = Integer.parseInt(input);
            } catch (Exception e) {
                if (!input.equalsIgnoreCase("S")) {
                    continue;
                }
                else {
                    break;
                }
            }
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        System.out.println("Even number: "+ even);
        System.out.println("Odd number: "+ odd);
    }

    private void exercise2(Scanner in) {
        
    }
}
