/*
**
** Daniel Engel 2012
**
** GitHub URL: http://github.com/dengel/ConvertNumber
**
*/

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class ConvertNumber {

    // Map individual numbers.
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
    }};

    // Map all tens.
    private static final Map<Integer, String> TENS = new Hashtable<Integer, String>() {
        {
        put(1, "twenty");
        put(2, "thirty");
        put(3, "forty");
        put(4, "fifty");
        put(5, "sixty");
        put(6, "seventy");
        put(7, "eighty");
        put(8, "ninety");
    }};

    public static void main(String[] args) {

        // Easier for quick testing to produce a rand number.
        int i = args.length > 0 ? Integer.parseInt(args[0]) : getRandom();

        System.out.println("Numerical: " + i + "\n");

        if (i == 0) {
            System.out.println("Exception: zero\n");
        } else {
            System.out.println("Textual: " + convertNumber(i) + "\n");
        }

        System.exit(0);
        
    }

    // individual numbers go up to 19, then 
    // need tens, hundreds, and thousands.
    public static String convertNumber(int i) {

        String retval = "";

        if (i == 0) {
            retval = "";
        } else if (isBetween(i, 1, 19)) {
            retval = BASE.get(i);
        } else if (isBetween(i, 20, 99)) {
            retval = TENS.get(i / 10 - 1) + " " + convertNumber(i % 10);
        } else if (isBetween(i, 100, 999)) {
            retval = convertNumber(i / 100) + " hundred " + convertNumber(i % 100);
        } else if (isBetween(i, 1000, 999999)) {
            retval = "not yet";
        }

        return retval.replaceAll("\\s+", " ");

    }

    // TODO: See if a SWITCH with CASE ranges is possible.
    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    // Return random number within range.
    private static int getRandom() {

        Random rand = new Random();
        int min = 0;
        int max = 99;

        return rand.nextInt(max - min + 1) + min;
    }


}
