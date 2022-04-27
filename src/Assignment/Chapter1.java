package src.Assignment;
import java.util.Scanner;
public class Chapter1 implements TaskHandler {
    @Override
    public void handleTask(Scanner in) {
        int choice = 0;
        while (true) {
            String menuTitle = "Chapter 1 Menu";
            String prompt = "Select an exercise";
            String[] menuOptions = {
                "Exercise 1", "Exercise 2", "Exercise 3", "Sample Exercise"
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
                case 4:
                    sampleExercise(in);
                    break;
            }
            UIUtility.pressEnterToContinue(in);
        }
        System.out.println("\nExiting Chapter 1 Menu.");
    }

    public void exercise1(Scanner in) {
        UIUtility.showMenuTitle("Exercise 1");
        double num1 = InputUtility.getDouble("Enter a number: ", in);
        double num2 = InputUtility.getDouble("Enter another number: ", in);
        System.out.println("Largest number is: " + (num1 >= num2? num1 : num2));
    }

    public void exercise2(Scanner in) {
        UIUtility.showMenuTitle("Exercise 2");
        double num1 = InputUtility.getDouble("Enter a number: ", in);
        double num2 = InputUtility.getDouble("Enter another number: ", in);
        System.out.printf("The average is: %.1f%n", (num1 + num2)/2);
    }

    public void exercise3(Scanner in) {
        UIUtility.showMenuTitle("Exercise 3");
        double radius = InputUtility.getDouble("Enter the radius: ", in);
        System.out.printf("Circumference: %.2f%n", (2*radius*Math.PI));
        System.out.printf("Area: %.2f%n", (Math.pow(radius, 2)*Math.PI));
    }

    public void sampleExercise(Scanner in) {
        UIUtility.showMenuTitle("Sample Exercise");
        // Sample code here
        String name = InputUtility.getString("What is your name?", in);
        System.out.printf("%nHello, %s!%n", name);

        int favNum = InputUtility.getInt("What is your favorite number?", in);
        System.out.printf("%nYour favorite number is %d%n", favNum);

        int age = InputUtility.getIntInRange("What is your age?", 0, 120, in);
        System.out.printf("%nYou are %d years old.%n", age);

        String favFood = InputUtility.validateUserString("What is your favorite food?", in, new String[] {"Pizza", "Sushi", "Ice Cream"});
        if (favFood.toLowerCase().equals("pizza")){
            System.out.println("I like pizza too!");
        } else if (favFood.toLowerCase().equals("sushi")) {
            System.out.println("I don't like that :((");
        } else {
            System.out.println("It's too cold for that");
        }
    }
}
