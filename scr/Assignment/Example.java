package scr.Assignment;
public class Example {
    public static void main(String[] args) {
        String name1 = "Hoang";
        String name2 = "Hoang";

        int heightInInches = 75,
                minHeightToRide = 45;
        if (heightInInches >= minHeightToRide) {
            System.out.println("You can ride the rollercoaster");
        }

        if (name1.equals(name2)) {
            System.out.println("We have 2 Hoang!");
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        for (int i = 10; i > 0; i--){
            System.out.println(i);
        }

        int x = 5, y = 0;
        try {
            System.out.println(x / y);
        } catch(ArithmeticException e){
            System.out.println("Cannot divide by 0!");
        }
    }
}