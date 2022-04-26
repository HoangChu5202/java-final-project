package src;

import java.util.Scanner;

/**
 * Long And Latitude
 */
public class LongAndLatitude {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String choice = "yes";
        double latitude = 0, longtitude = 0,
            farthestNorth = -91, farthestSouth = 91,
            farthestWest = 181, farthestEast = -181;
        do {
            latitude = getLatitude(in);
            longtitude = getLongtitude(in);

            farthestNorth = farthestNorth > latitude? farthestNorth : latitude;
            farthestSouth = farthestSouth < latitude? latitude : farthestSouth;
            farthestEast = farthestEast > longtitude? farthestEast : longtitude;
            farthestWest = farthestWest < longtitude? longtitude : farthestWest;

            System.out.println("Farthest North: " + farthestNorth);
            System.out.println("Farthest South: " + farthestSouth);
            System.out.println("Farthest East: " + farthestEast);
            System.out.println("Farthest West: " + farthestWest);
            choice = InputUtility.validateUserString("Would you like to enter another location?", in, "Yes", "Y", "No", "N"); 
        } while (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y"));

        in.close();
    }

    public static double getLongtitude(Scanner in) {
        double value = -1;
        boolean needed = true;
        while (needed) {
            value = InputUtility.getDouble("Please enter the longtitude", in);
            if (value > 180 || value < -180) {
                UIUtility.showErrorMessage("Invalid Longtitude", in);
            } else {
                needed = false;
            }
        }
        return value;
    }

    public static double getLatitude(Scanner in) {
        double value = -1;
        boolean needed = true;
        while (needed) {
            value = InputUtility.getDouble("Please enter the latitude", in);
            if (value > 90 || value < -90) {
                UIUtility.showErrorMessage("Invalid Latitude", in);
            } else {
                needed = false;
            }
        }
        return value;
    }
}