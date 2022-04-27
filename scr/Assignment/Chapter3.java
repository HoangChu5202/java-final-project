package scr.Assignment;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Chapter3 implements TaskHandler {
    @Override
    public void handleTask(Scanner in) {
        int choice = 0;
        while (true) {
            String menuTitle = "Chapter 3 Menu";
            String prompt = "Select an exercise";
            String[] menuOptions = {
                    "Exercise 1", "Exercise 2", "Exercise 3"
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
                case 3:
                    exercise3(in);
                    break;
            }
            UIUtility.pressEnterToContinue(in);
        }
        System.out.println("\nExiting Chapter 3 Menu.");
    }

    public void exercise1(Scanner in) {
        UIUtility.showMenuTitle("Exercise 1");
        int num1, num2;
        boolean increase;
        System.out.println("Please enter two number:");
        num1 = InputUtility.getInt("Please enter the first number", in);
        num2 = InputUtility.getInt("Please enter the second number", in);
        increase = num1 < num2;
        if (num1 == num2)
        {
            System.out.println("There is no number between them!");
        } else 
        {
            if (increase == true)
            {
                for (int i = num1 + 1; i < num2; i++) {
                    if (i % 2 == 0)
                    {
                        System.out.print(i + " ");
                        if (i % num1 == 0) {break;}
                    }
                }
            } else
            {
                for (int i = num1 - 1; i > num2; i--) {
                    if (i % 2 == 0)
                    {
                        System.out.print(i + " ");
                        if (i % num2 == 0) {break;}
                    }
                }
            }
        }
    }

    public void exercise2(Scanner in) {
        UIUtility.showMenuTitle("Exercise 2");

        String userInput = "run";
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE,
                sum = 0, toNumber = 0;
        int count = 0;
        boolean run = true;

        System.out.println("Enter some numbers (enter \"S\" to stop): ");
        while (run == true)
        {
            userInput = in.nextLine();
            try {
                toNumber = Double.parseDouble(userInput);
                sum += toNumber;
                count++;
                max = max > toNumber? max : toNumber;
                min = min < toNumber? min : toNumber;
            } catch (Exception e) {
                run = !(userInput.equalsIgnoreCase("stop") || userInput.equalsIgnoreCase("s"));
            }
            
        }

        System.out.println("The sum is " + (int)sum);
        System.out.println("The count is " + count);
        System.out.printf("The average is: %.2f\n", (sum / count));
        System.out.println("The highest is: " + (int)max);
        System.out.println("The lowest is: " + (int)min);
    }

    public void exercise3(Scanner in) {
        UIUtility.showMenuTitle("Exercise 3");
        int num1 = ThreadLocalRandom.current().nextInt(1, 13),
            num2 = ThreadLocalRandom.current().nextInt(1, 13),
            attempt = 3, result = num1 * num2, userAnswer;
        
        System.out.println("What is " + num1 + " x " + num2 + "?");
        while (attempt > 0) 
        {
            userAnswer = InputUtility.getInt("Your answer is", in);
            if (userAnswer == result)
            {
                System.out.println("Correct!");
                break;
            } 
            else {
                attempt--;
                if (attempt > 0) {
                    System.out.println("Incorrect. You have " + attempt + " attempt remaining");
                }
                else {
                    System.out.println("Incorrect. The answer was " + result);
                }
            }
        }

    }
}
