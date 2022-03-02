package book;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Modular_division {
    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal("10");
        BigDecimal num2 = new BigDecimal("3");
        BigDecimal result;
        try {
            result = num1.divide(num2);
        } catch (ArithmeticException e){
            result = num1.divide(num2, 5, RoundingMode.HALF_UP);
        }
        System.out.println(result);
        BigDecimal rem = num1.remainder(num2);
        System.out.println(rem);
    }
    
}