package src;

import java.math.BigInteger;
import java.util.Scanner;


public class Chapter4 implements TaskHandler{
    @Override
    public void handleTask(Scanner in) {
        int choice = 0;
        while (true) {
            String menuTitle = "Chapter 4 Menu";
            String prompt = "Select an exercise";
            String[] menuOptions = {
                    "Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5",
                    "Exercise 6", "Exercise 7", "Exercise 8"
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
                case 5:
                    exercise5(in);
                    break;
                case 6:
                    exercise6(in);
                    break;
                case 7:
                    exercise7(in);
                    break;
                case 8:
                    exercise8(in);
                    break;
            }
            UIUtility.pressEnterToContinue(in);
        }
        System.out.println("\nExiting Chapter 4 Menu.");
    }

    private void exercise1(Scanner in) {
        Fraction fraction = new Fraction();
        System.out.println(fraction);
    }

    public void exercise2(Scanner in) {
        Fraction fraction = new Fraction(27, 6);
        System.out.println(fraction);
        System.out.println("Numerator is: " + fraction.getNumerator());
        System.out.println("Denominator is: " + fraction.getDenominator());

        fraction.setNumerator(30);
        fraction.setDenominator(45);
        System.out.println(fraction);
    }

    public void exercise3(Scanner in) {
        try {
            Fraction fraction = new Fraction(3, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Fraction fraction = new Fraction();
        try {
            fraction.setDenominator(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void exercise4(Scanner in) {
        System.out.println(Fraction.greatestCommonDivisor(75, 45));
        System.out.println(Fraction.greatestCommonDivisor(2, 4));
        System.out.println(Fraction.greatestCommonDivisor(5, 7));
    }

    public void exercise5(Scanner in) {
        Fraction fraction = new Fraction(75, 45);
        fraction = fraction.simplify();
        System.out.println(fraction);

        fraction = new Fraction(2, 4);
        fraction = fraction.simplify();
        System.out.println(fraction);

        fraction = new Fraction(5, 7);
        fraction = fraction.simplify();
        System.out.println(fraction);

        fraction = new Fraction(-2, 4);
        fraction = fraction.simplify();
        System.out.println(fraction);

        fraction = new Fraction(2, -4);
        fraction = fraction.simplify();
        System.out.println(fraction);

        fraction = new Fraction(-2, -4);
        fraction = fraction.simplify();
        System.out.println(fraction);
    }

    public void exercise6(Scanner in) {
        Fraction fraction = new Fraction(4, 1);
        System.out.println(fraction.mixedNumber());

        fraction = new Fraction(0, 4);
        System.out.println(fraction.mixedNumber());

        fraction = new Fraction(4, 4);
        System.out.println(fraction.mixedNumber());

        fraction = new Fraction(8, 4);
        System.out.println(fraction.mixedNumber());

        fraction = new Fraction(4, 8);
        System.out.println(fraction.mixedNumber());

        fraction = new Fraction(13, 5);
        System.out.println(fraction.mixedNumber());

        fraction = new Fraction(-13, 5);
        System.out.println(fraction.mixedNumber());

        fraction = new Fraction(13, -5);
        System.out.println(fraction.mixedNumber());

        fraction = new Fraction(-13, -5);
        System.out.println(fraction.mixedNumber());
    }

    public void exercise7(Scanner in) {
        Fraction fFraction = new Fraction(13, 5);
        Fraction sFraction = new Fraction(4, 8);
        Fraction result = fFraction.add(sFraction);
        System.out.println(result.mixedNumber());

        fFraction = new Fraction(- 13, -5);
        sFraction = new Fraction(13, -5);
        result = fFraction.add(sFraction);
        System.out.println(result.mixedNumber());
    }

    public void exercise8(Scanner in) {
        int fNumerator = InputUtility.getInt("Enter the first numerator", in);
        int fDenominator = InputUtility.getInt("Enter the first denominator", in);
        Fraction fFraction = new Fraction(fNumerator, fDenominator);

        int sNumerator = InputUtility.getInt("Enter the second numerator", in);
        int sDenominator = InputUtility.getInt("Enter the second denominator", in);
        Fraction sFraction = new Fraction(sNumerator, sDenominator);

        Fraction result = new Fraction();

        int choice = 0;
        while (true) {
            String menuTitle = "Add, Subtract, Multiply or Divide Fraction";
            String prompt = "Select what do you want to do";
            String[] menuOptions = {
                    "Add", "Subtract", "Multiply", "Divide"
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, in);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            switch (choice) {
                case 1:
                    result = fFraction.add(sFraction);
                    System.out.println();
                    System.out.println("Result:");
                    System.out.println(fFraction.mixedNumber() + " + " + sFraction.mixedNumber() + " = " + result.mixedNumber());
                    break;
                case 2:
                    result = fFraction.subtract(sFraction);
                    System.out.println();
                    System.out.println("Result:");
                    System.out.println(fFraction.mixedNumber() + " - " + sFraction.mixedNumber() + " = " + result.mixedNumber());
                    break;
                case 3:
                    result = fFraction.multiply(sFraction);
                    System.out.println();
                    System.out.println("Result:");
                    System.out.println(fFraction.mixedNumber() + " x " + sFraction.mixedNumber() + " = " + result.mixedNumber());
                    break;
                case 4:
                    result = fFraction.divide(sFraction);
                    System.out.println();
                    System.out.println("Result:");
                    System.out.println(fFraction.mixedNumber() + " : " + sFraction.mixedNumber() + " = " + result.mixedNumber());
                    break;
            }
            UIUtility.pressEnterToContinue(in);
        }
    }
}

class Fraction {
    public int numerator;
    public int denominator;

    public Fraction() {
        numerator = 1;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        validateDenominator(denominator);
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        validateDenominator(denominator);
        this.denominator = denominator;
    }

    private void validateDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
    }

    public static int greatestCommonDivisor(int num1, int num2) {
        BigInteger a = BigInteger.valueOf(num1);
        BigInteger b = BigInteger.valueOf(num2);
        BigInteger gcd = a.gcd(b);
        return gcd.intValue();
    }

    public Fraction simplify(){
        int simplifyNumerator = numerator;
        int simplifyDenominator = denominator;
        if (simplifyNumerator < 0 && simplifyDenominator < 0) {
            simplifyNumerator = Math.abs(simplifyNumerator);
            simplifyDenominator = Math.abs(simplifyDenominator);
        } else if (simplifyNumerator > 0 && simplifyDenominator < 0) {
            simplifyNumerator *= -1;
            simplifyDenominator = Math.abs(simplifyDenominator);
        }
        int divisor = greatestCommonDivisor(simplifyNumerator, simplifyDenominator);
        simplifyNumerator = simplifyNumerator / divisor;
        simplifyDenominator = simplifyDenominator / divisor;
        return new Fraction(simplifyNumerator, simplifyDenominator);
    }

    public String mixedNumber() {
        Fraction simplified = this.simplify();
        int simplifiedNumerator = simplified.getNumerator();
        int simplifiedDenominator = simplified.getDenominator();
        String result = simplifiedNumerator + "/" + simplifiedDenominator;
        if (simplifiedNumerator == 0) {
            result = "0";
        } else if (simplifiedDenominator == 1) {
            result = Integer.toString(simplifiedNumerator);
        } else if (simplifiedNumerator == simplifiedDenominator) {
            result = "1";
        } else if (Math.abs(simplifiedNumerator) > Math.abs(simplifiedDenominator)) {
            int num = simplifiedNumerator / simplifiedDenominator;
            int mixedNumerator = Math.abs(simplifiedNumerator % simplifiedDenominator);
            result = num + " " + mixedNumerator + "/" + simplifiedDenominator;
        }
        return result;
    }

    public Fraction add(Fraction other) {
        Fraction result = new Fraction();
        Fraction fFraction =  this.simplify(); // First fraction
        Fraction sFraction = other.simplify(); // Second Fraction
        result.setDenominator( fFraction.getDenominator() * sFraction.getDenominator() ); // time 2 denominator together
        result.setNumerator( (fFraction.getNumerator() * sFraction.getDenominator()) + 
                                    (sFraction.getNumerator() * fFraction.getDenominator()) );
        result = result.simplify();
        return result;
    }

    public Fraction subtract(Fraction other) {
        Fraction result = new Fraction();
        Fraction fFraction =  this.simplify(); // First fraction
        Fraction sFraction = other.simplify(); // Second Fraction
        result.setDenominator( fFraction.getDenominator() * sFraction.getDenominator() ); // time 2 denominator together
        result.setNumerator( (fFraction.getNumerator() * sFraction.getDenominator()) - 
                                    (sFraction.getNumerator() * fFraction.getDenominator()) );
        result = result.simplify();
        return result;
    }

    public Fraction multiply(Fraction other) {
        Fraction result = new Fraction();
        Fraction fFraction =  this.simplify(); // First fraction
        Fraction sFraction = other.simplify(); // Second Fraction
        result.setDenominator( fFraction.getDenominator() * sFraction.getDenominator() ); 
        result.setNumerator( fFraction.getNumerator() * sFraction.getNumerator() );
        result = result.simplify();
        return result;
    }

    public Fraction divide(Fraction other) {
        Fraction result = new Fraction();
        Fraction fFraction =  this.simplify(); // First fraction
        Fraction sFraction = other.simplify(); // Second Fraction
        result.setDenominator( fFraction.getDenominator() * sFraction.getNumerator() ); // time 2 denominator together
        result.setNumerator( fFraction.getNumerator() * sFraction.getDenominator() );
        result = result.simplify();
        return result;
    }

    @Override 
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }
}