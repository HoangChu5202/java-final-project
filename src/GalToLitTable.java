package src;
public class GalToLitTable {
    public static void main(String args[]) {
        double liters;
        int gallons, counter;
        
        counter = 0;
        for (gallons = 1; gallons <= 100; gallons++) {
            liters = gallons * 3.7854; // convert to liters
            // System.out.println(gallons + " gallons is " +
            //         liters + " liters.");
            System.out.printf("%d gallons is %.3f liters.\n", gallons, liters);
            counter++;

            // every 10th line, print a blank line
            if (counter == 10) {
                System.out.println();
                counter = 0; // reset the line counter
            }
        }
    }

}
