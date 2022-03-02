package book;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class randomLetterGame {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        char answer = (char)ThreadLocalRandom.current().nextInt(65, 91);
        char guess;
        while (true) {
            System.out.print("Guess a letter: ");
            guess = scanner.nextLine().toUpperCase().charAt(0);
            if (guess == answer) {
                System.out.println("That's correct!!!");
                break;
            } else {
                if (guess < answer){
                    System.out.println("Incorrect. Go higher");
                } else {
                    System.out.println("Incorrect. Go lower");
                }
            }
        }
        scanner.close();
    }
}
