/*
**
** Daniel Engel 2012
**
*/

import java.util.Hashtable;
import java.util.Map;

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

    public static void main(String[] args) {

        int i = Integer.parseInt(args[0]);

        System.out.println("Numerical: " + i + "\n");

        // individual numbers go up to 19, then 
        // need tens, hundreds, and thousands.
        if (i == 0) {
            System.out.println("Range: 0");
        } else if (isBetween(i, 1, 19)) {
            System.out.println("Textual: " + BASE.get(i));
        } else if (isBetween(i, 20, 99)) {
            System.out.println("Range: 20-99");
        } else if (isBetween(i, 100, 999)) {
            System.out.println("Range: 100-999");
        } else if (isBetween(i, 1000, 999999)) {
            System.out.println("Range: 1000-999999");
        }

        System.exit(0);
        
    }

    // TODO: See if a SWITCH with CASE ranges is possible.
    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

}
