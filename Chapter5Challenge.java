import java.util.Scanner;
import java.util.Arrays;
public class Chapter5Challenge implements TaskHandler {
    @Override
    public void handleTask(Scanner in) {
        int choice = 0;
        while (true) {
            String menuTitle = "Chapter 5 Challenge Menu";
            String prompt = "Select an exercise";
            String[] menuOptions = {
                    "Task 1", "Task 2", "Task 3", "Task 4", "Task 5",
                    "Task 6", "Task 7"
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, in);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            switch (choice) {
                case 1:
                    task1(in);
                    break;
                case 2:
                    task2(in);
                    break;
                case 3:
                    task3(in);
                    break;
                case 4:
                    task4(in);
                    break;
                case 5:
                    task5(in);
                    break;
                case 6:
                    task6(in);
                    break;
                case 7:
                    task7(in);
                    break;
            }
            UIUtility.pressEnterToContinue(in);
        }
        System.out.println("\nExiting Chapter 5 Challenge Menu.");
    }
    
    public Integer[] getRandomIntegerArray() {
        int min = 5;
        int max = 10;
        int randomSize = min + (int) (Math.random() * ((max - min) + 1));
        Integer[] list = new Integer[randomSize];
        for (int i = 0; i < randomSize; i++) {
            list[i] = (int)(Math.random() * 10);
        }
        return list;
    }

    public void task1(Scanner in) {
        UIUtility.showMenuTitle("Task 1");
        Integer[] list = getRandomIntegerArray();
        System.out.println("Original list: " + Arrays.toString(list));
        int index = InputUtility.getIntInRange("Update value at index", 0, list.length, in);
        int swapNum = InputUtility.getInt("Enter an integer", in);
        list[index] = swapNum;
        System.out.println("Modified list: " + Arrays.toString(list));
    }

    public void task2(Scanner in) {
        UIUtility.showMenuTitle("Task 2");
        Integer[] list = getRandomIntegerArray();
        System.out.println("Original list: " + Arrays.toString(list));
        Integer[] newList = new Integer[list.length+1];
        Integer temp;
        int index = InputUtility.getIntInRange("Insert value at index", 0, list.length, in);
        int num = InputUtility.getInt("Enter an integer", in);
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        newList[newList.length-1] = num;
        temp = newList[index];
        newList[index] = newList[newList.length-1];
        newList[newList.length-1] = temp;
        System.out.println("Modified list: " + Arrays.toString(newList));
    }

    public void task3(Scanner in) {
        UIUtility.showMenuTitle("Task 3");
        Integer[] list = getRandomIntegerArray();
        System.out.println("Original list: " + Arrays.toString(list));
        int index = InputUtility.getIntInRange("Delete value at index", 0, list.length, in);
        list[index] = null;
        System.out.println("Modified list: " + Arrays.toString(list));
    }

    public void task4(Scanner in) {
        UIUtility.showMenuTitle("Task 4");
        Integer[] list = getRandomIntegerArray();
        System.out.println("Original list: " + Arrays.toString(list));
        int index = InputUtility.getIntInRange("Swap value at index", 0, list.length, in);
        int indexSwap = InputUtility.getIntInRange("With the value at index", 0, list.length, in);
        Integer temp = list[index];
        list[index] = list[indexSwap];
        list[indexSwap] = temp;
        System.out.println("Modified list: " + Arrays.toString(list));
    }

    public void task5(Scanner in) {
        UIUtility.showMenuTitle("Task 5");
        Integer[] list = getRandomIntegerArray();
        System.out.println("Original list: " + Arrays.toString(list));
        
        Integer[] newList = new Integer[list.length];
        newList[0] = list[list.length-1];
        for (int i = 1; i < list.length; i++) {
            newList[i] = list[i-1];
        }

        System.out.println("Modified list: " + Arrays.toString(newList));
    }

    public void task6(Scanner in) {
        UIUtility.showMenuTitle("Task 6");
        Integer[] list = getRandomIntegerArray();
        System.out.println("Original list: " + Arrays.toString(list));
        
        Integer[] newList = new Integer[list.length];
        newList[newList.length-1] = list[0];
        for (int i = 0; i < list.length-1; i++) {
            newList[i] = list[i+1];
        }

        System.out.println("Modified list: " + Arrays.toString(newList));
    }

    public void task7(Scanner in) {
        UIUtility.showMenuTitle("Task 7");
        Integer[] list = getRandomIntegerArray();
        System.out.println("Original list: " + Arrays.toString(list));
        
        Integer[] newList = new Integer[list.length];
        int index = 0;
        for (int i = list.length-1; i >= 0 ; i--) {
            newList[index] = list[i];
            index++;
        }

        System.out.println("Modified list: " + Arrays.toString(newList));
    }
}

