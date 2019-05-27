package romannumerals;

public class Roman {

    private static final int[]    VALUES  = { 1000, 900,  500, 400,  100, 90,   50,  40,   10,  9,    5,   4,    1   };
    private static final String[] SYMBOLS = { "M",  "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public static String To(int number) throws IllegalArgumentException {
        if (number == 0) throw new IllegalArgumentException("There is no zero in Roman numerals.");

        var romanNumber = new StringBuilder();

        while (number > 0) {

            for(int i = 0;i < VALUES.length;i++){
                if ((number / VALUES[i]) < 1) continue;

                number -= VALUES[i];
                romanNumber.append(SYMBOLS[i]);
                break;
            }
        }

        return romanNumber.toString();
    }
}