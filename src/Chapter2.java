package src;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class Chapter2 implements TaskHandler {
    @Override
    public void handleTask(Scanner in) {
        int choice = 0;
        while (true) {
            String menuTitle = "Chapter 2 Menu";
            String prompt = "Select an exercise";
            String[] menuOptions = {
                "Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4"
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
                    exercise4(in);
                    break;
            }
            UIUtility.pressEnterToContinue(in);
        }
        System.out.println("\nExiting Chapter 2 Menu.");
    }

    public void exercise1(Scanner in) {
        UIUtility.showMenuTitle("Exercise 1");
        int num = InputUtility.getInt("Enter a number: ", in);
        boolean isEven = num % 2 == 0? true : false;
        if (isEven == true) {
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
    }

    public void exercise2(Scanner in) {
        UIUtility.showMenuTitle("Exercise 2");
        BigDecimal number = InputUtility.getBigdecimal("Please input a decimal number", in);
        BigDecimal oneHundred = new BigDecimal("100");
        BigDecimal num = number.setScale(0, RoundingMode.DOWN);
        System.out.println(num);
        System.out.println((number.subtract(num)).multiply(oneHundred).setScale(0, RoundingMode.HALF_UP));
    }

    public void exercise3(Scanner in) {
        UIUtility.showMenuTitle("Exercise 3");
        for (int i = 2; i <= 100; i++) {
            int count = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count <= 1) {
                System.out.print(i + " ");
            }
        }
    }

    public void exercise4(Scanner in) {
        UIUtility.showMenuTitle("Exercise 4");
        //Code here
        final int SECOND_IN_MINUTE = 60, 
                MINUTE_IN_HOUR = 60, 
                HOUR_IN_DAY = 24;
        int minutes = 0, hours = 0, days = 0;
        int seconds = InputUtility.getInt("Enter a number for second", in);

        days = seconds / (SECOND_IN_MINUTE * MINUTE_IN_HOUR * HOUR_IN_DAY);
        seconds -= days * (SECOND_IN_MINUTE * MINUTE_IN_HOUR * HOUR_IN_DAY);

        hours = seconds / (MINUTE_IN_HOUR * SECOND_IN_MINUTE);
        seconds -= hours * (MINUTE_IN_HOUR * SECOND_IN_MINUTE);

        minutes = seconds / SECOND_IN_MINUTE;
        seconds -= minutes * SECOND_IN_MINUTE;

        System.out.println("Days: " + days);
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.println("Seconds: " + seconds);
    }
}

