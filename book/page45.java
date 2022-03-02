package book;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class page45 {
    public static void main(String[] args) {
        BigDecimal r = new BigDecimal("4");
        BigDecimal h = new BigDecimal("5");
        BigDecimal pi = new BigDecimal(Math.PI);
        BigDecimal v = pi.multiply(r).multiply(r).multiply(h);
        BigDecimal vRound = v.setScale(3, RoundingMode.HALF_UP);
        System.out.println("Volume is " + vRound);
    }
}
