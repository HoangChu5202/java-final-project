package scr.Assignment;
public class InchesToMetter {
    public static void main(String[] args) {
        double metter;
        int inch, counter;

        counter = 0;
        for (inch = 1; inch <= 144; inch++) {
            metter = inch * 0.0254;
            System.out.printf("%d inches is %.3f metter.\n", inch, metter);
            counter++;

            if (counter == 12){
                System.out.println();
                counter = 0;
            }
        }    
    }
}
