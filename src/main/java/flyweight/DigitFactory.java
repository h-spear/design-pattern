package flyweight;

public class DigitFactory {

    private static Digit[] pool = new Digit[10];

    private DigitFactory() {
    }

    public static Digit getDigit(int n) {
        if (pool[n] == null) {
            String fileName = String.format("src/main/resources/digits/%d.txt", n);
            Digit digit = new Digit(fileName);
            pool[n] = digit;
        }
        return pool[n];
    }
}
