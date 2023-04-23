package flyweight;

import java.util.ArrayList;
import java.util.List;

public class Number {

    private List<Digit> digits = new ArrayList<>();

    public Number(String numStr) {

        for (char c: numStr.toCharArray()) {
            int n = Character.getNumericValue(c);
            Digit digit = DigitFactory.getDigit(n);
            digits.add(digit);
        }
    }

    public void print() {
        for (Digit digit: digits) {
            digit.print();
            System.out.println();
        }
    }
}
