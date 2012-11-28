/*
 ** Daniel Engel 2012
 **
 ** Java
 **
 */

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class ConvertNumber {

    // Create a map hash to translate unique number base, tenths, and scale.
    private static final Map<Integer, String> BASE = new Hashtable<Integer, String>() {
        {
            put(0, "");
            put(1, "one");
            put(2, "two");
            put(3, "three");
            put(4, "four");
            put(5, "five");
            put(6, "six");
            put(7, "seven");
            put(8, "eight");
            put(9, "nine");
            put(10, "ten");
            put(11, "eleven");
            put(12, "twelve");
            put(13, "thirtheen");
            put(14, "fourteen");
            put(15, "fifteen");
            put(16, "sixteen");
            put(17, "seventeen");
            put(18, "eighteen");
            put(19, "nineteen");
            put(20, "twenty");
            put(30, "thirty");
            put(40, "forty");
            put(50, "fifty");
            put(60, "sixty");
            put(70, "seventy");
            put(80, "eighty");
            put(90, "ninety");
            put(100, "hundred");
            put(1000, "thousand");
            put(1000000, "million");
            put(1000000000, "billion");
        }
    };

    public static void main(String[] args) {

        int numeric = 0;
        String negative = "";

        // If an argument is given, use it. Otherwise produce a random number.
        numeric = args.length > 0 ? Integer.parseInt(args[0]) : getRandom();

        System.out.println("\nNumeric: " + numeric);

        // Account for negative numbers and flip it.
        if (numeric < 0) {
            negative = "negative ";
            numeric *= -1;
        }

        if (numeric == 0) {
            System.out.println("Textual: zero\n");
        } else {
            System.out.println("Textual: " + negative + convertNumber(numeric) + "\n");
        }

        System.exit(0);
    }

    // Recursive method to convert a numerical value into its textual equivalent.
    public static String convertNumber(int numeric) {

        String retval = "";
        int multiplier = 0;

        // Recursve condition block.
        if (isBetween(numeric, 0, 19)) {
            retval = BASE.get(numeric);
        } else if (isBetween(numeric, 20, 99)) {
            retval = BASE.get((numeric / 10) * 10) + " "
                    + convertNumber(numeric % 10);
        } else if (numeric > 99) {
            if (isBetween(numeric, 100, 999)) {
                multiplier = 100;
            } else if (isBetween(numeric, 1000, 999999)) {
                multiplier = 1000;
            } else if (isBetween(numeric, 1000000, 999999999)) {
                multiplier = 1000000;
            } else if (numeric >= 1000000000) {
                multiplier = 1000000000;
            }

            // Add scale value and continue.
            retval = convertNumber(numeric / multiplier) + " "
                    + BASE.get(multiplier) + " "
                    + convertNumber(numeric % multiplier);
        }

        // Collapse spaces and return string.
        return retval.replaceAll("\\s+", " ");

    }

    // Since Java does not have a native SWITCH with range CASE.
    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    // Easy way to test things, used if no argument is given.
    private static int getRandom() {
        Random rand = new Random();
        int max = 999999999;
        int min = max * -1;

        return rand.nextInt(max - min + 1) + min;
    }

}
