import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scanner2 {
    public static Scanner2 scanner = new Scanner2();
    private Scanner inputLocal;

    private static String truthy[] = { "1", "verdadeiro", "true", "truthy", "sim", "yes", "please", "y", "s", "ss" };
    private static String falsy[] = { "0", "falso", "false", "falsy", "não", "nao", "no", "stop", "n", "nn" };

    public Scanner2() {
        inputLocal = new Scanner(System.in);
    }
    
    public Scanner2(InputStream source) {
        inputLocal = new Scanner(source);
    }

    public static boolean isTruthy(String value) {
        value = value.trim().toLowerCase();

        for (String truthyValue : truthy) {
            if (truthyValue.equals(value))
                return true;
        }

        return false;
    }
    
    public static boolean isFalsy(String value) {
        value = value.trim().toLowerCase();

        for (String falsyValue : falsy) {
            if (falsyValue.equals(value))
                return true;
        }

        return false;
    }

    public String nextStringInt() {
        String value = nextLine();
        value = value.replaceAll("[^\\d-]", "");
        boolean isPositive = !value.startsWith("-");
        value = value.replaceAll("\\D", "");

        if (!isPositive)
            value = "-" + value;

        return value;
    }

    public String nextStringUnsignedInt() {
        String value = nextLine();
        value = value.replaceAll("\\D", "");
        return value;
    }

    public String nextStringDecimal() {
        String value = nextLine();
        value = value.replace(',', '.').replaceAll("[^\\d\\.-]", "").replaceAll("^\\.-", "-.");

        boolean isPositive = !value.startsWith("-");
        value = value.replace("-", "");

        value = value.replaceAll("^\\.", "0.");

        if (value.endsWith("."))
            value = value.substring(0, value.length() - 1);

        if (value.contains("."))
            value = value.substring(0, value.indexOf('.')) + '.' + value.substring(value.indexOf('.'), value.length()).replace(".", "");

        if (!isPositive)
            value = "-" + value;

        return value;
    }
    
    public String nextStringUnsignedDecimal() {
        String value = nextLine();
        value = value.replace(',', '.').replaceAll("[^\\d\\.]", "").replaceAll("^\\.", "0.");

        if (value.endsWith("."))
            value = value.substring(0, value.length() - 1);

        if (value.contains("."))
            value = value.substring(0, value.indexOf('.')) + '.' + value.substring(value.indexOf('.'), value.length()).replace(".", "");

        return value;
    }

    public String nextLine() {
        boolean validInput;
        String value;

        do {
            validInput = true;
            value = inputLocal.nextLine().trim();
            if (value.isEmpty())
                validInput = false;
        } while (!validInput);

        return value;
    }

    public String nextLine(String regex) {
        String value = nextLine();

        if (!Pattern.matches(regex, value))
            throw new IllegalArgumentException("A string fornecida não corresponde ao REGEX solicitado.");

        return value;
    }

    public String next() {
        boolean validInput;
        String value;

        do {
            validInput = true;
            value = nextLine();
            if (value.isEmpty())
                validInput = false;
        } while (!validInput);

        return value.split(" ")[0];
    }

    public String next(String regex) {
        String value = next();

        if (!Pattern.matches(regex, value))
            throw new IllegalArgumentException("A string fornecida não corresponde ao REGEX solicitado.");

        return value;
    }

    public Character nextChar() {
        boolean validInput;
        String value;

        do {
            validInput = true;
            value = next();
            if (value.isEmpty())
                validInput = false;
        } while (!validInput);

        return value.charAt(0);
    }

    public char nextChar(String regex) {
        char value = nextChar();

        if (!Pattern.matches(regex, Character.toString(value)))
            throw new IllegalArgumentException("O caractere fornecido não corresponde ao REGEX solicitado.");

        return value;
    }




    public int nextInt() {
        return Integer.parseInt(nextStringInt());
    }

    public int nextInt(int minValue) {
        int value = nextInt();

        if (value < minValue)
            throw new IllegalArgumentException("O número fornecido está abaixo do valor mínimo solicitado.");

        return value;
    }

    public int nextInt(int minValue, int maxValue) {
        int value = nextInt(minValue);

        if (value > maxValue)
            throw new IllegalArgumentException("O número fornecido está acima do valor máximo solicitado.");

        return value;
    }

    public int nextUnsignedInt() {
        return Integer.parseInt(nextStringUnsignedInt());
    }




    public long nextLong() {
        return Long.parseLong(nextStringInt());
    }

    public long nextLong(long minValue) {
        long value = nextLong();

        if (value < minValue)
            throw new IllegalArgumentException("O número fornecido está abaixo do valor mínimo solicitado.");

        return value;
    }

    public long nextLong(long minValue, long maxValue) {
        long value = nextLong(minValue);

        if (value > maxValue)
            throw new IllegalArgumentException("O número fornecido está acima do valor máximo solicitado.");

        return value;
    }

    public long nextUnsignedLong() {
        return Long.parseLong(nextStringUnsignedDecimal());
    }




    public byte nextByte() {
        return Byte.parseByte(nextStringInt());
    }

    public byte nextByte(byte minValue) {
        byte value = nextByte();

        if (value < minValue)
            throw new IllegalArgumentException("O número fornecido está abaixo do valor mínimo solicitado.");

        return value;
    }

    public byte nextByte(byte minValue, byte maxValue) {
        byte value = nextByte(minValue);

        if (value > maxValue)
            throw new IllegalArgumentException("O número fornecido está acima do valor máximo solicitado.");

        return value;
    }

    public byte nextUnsignedByte() {
        return Byte.parseByte(nextStringUnsignedInt());
    }




    public float nextFloat() {
        return Float.parseFloat(nextStringDecimal());
    }

    public float nextFloat(float minValue) {
        float value = nextFloat();

        if (value < minValue)
            throw new IllegalArgumentException("O número fornecido está abaixo do valor mínimo solicitado.");

        return value;
    }

    public float nextFloat(float minValue, float maxValue) {
        float value = nextFloat(minValue);

        if (value > maxValue)
            throw new IllegalArgumentException("O número fornecido está acima do valor máximo solicitado.");

        return value;        
    }

    public float nextUnsignedFloat() {
        return Float.parseFloat(nextStringUnsignedDecimal());
    }




    public double nextDouble() {
        return Double.parseDouble(nextStringDecimal());
    }

    public double nextDouble(double minValue) {
        double value = nextDouble();

        if (value < minValue)
            throw new IllegalArgumentException("O número fornecido está abaixo do valor mínimo solicitado.");

        return value;
    }

    public double nextDouble(double minValue, double maxValue) {
        double value = nextDouble(minValue);
        
        if (value > maxValue)
            throw new IllegalArgumentException("O número fornecido está acima do valor máximo solicitado.");

        return value;
    }




    public boolean nextBoolean() {
        return isTruthy(next());
    }
}
