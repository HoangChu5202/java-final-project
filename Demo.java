import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch;
        double n = 5;
        System.out.println(n);
        System.out.print("Enter a letter: ");
        ch = scanner.nextLine().charAt(0);
        while (true) {
            if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)){
                break;
            } else {
                System.out.println("Error");
                System.out.print("Enter a letter: ");
                ch = scanner.nextLine().charAt(0);
            }
            
        }
        if (ch >= 65 && ch <= 90){
            ch += 32;
        } else if (ch >= 97 && ch <= 122) {
            ch -= 32;
        }
        System.out.println("The letter is: " + ch);
        scanner.close();
    }
}
