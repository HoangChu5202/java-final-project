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
        String str1 = InputUtility.getString("Enter a string", in);
        method_ex2(str1);
        String str2 = InputUtility.getString("Enter another string", in);
        method_ex2(str2);
        if (str1.compareTo(str2) < 0) {
            System.out.println(str1 + " comes alphabetically before " + str2);
        } else {
            System.out.println(str2 + " comes alphabetically before " + str1);
        }
    }

    private void method_ex2(String str)
    {
        System.out.println("**Static**");
        System.out.println("Length: " + str.length());
        String subStr;
        try {
            subStr = str.substring(0,3);
        } catch (IndexOutOfBoundsException e) {
            subStr = str.substring(0);
        }
        System.out.println("First 3 characters: " + subStr);
        System.out.println("Last character: " + str.substring(str.length()-1));
        System.out.println("Contains the letter i: " + str.contains("i"));
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("Is a palindrome: " + isPalindrome(str));
        System.out.println();
    }
    private boolean isPalindrome(String str)
    {
        boolean result = false;
        String s = "";
        for (char chr : str.toCharArray()) {
            if (chr != 32)
            {
              s += String.valueOf(chr) + ","; 
            }
        }
        String[] strArr = s.split(",");
        int count = strArr.length - 1;

        for (int i = 0; i <= strArr.length / 2; i++) {
            if (strArr[i].equalsIgnoreCase(strArr[count]))
            {
                result = true;
            } else {
                result = false;
                break;
            }
            count--;
        }
        return result;
    }
}
