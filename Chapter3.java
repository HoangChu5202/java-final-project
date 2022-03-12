import java.util.Scanner;

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

    }

    public void exercise3(Scanner in) {
        UIUtility.showMenuTitle("Exercise 3");

    }
}
