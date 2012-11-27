/*
**
** Daniel Engel 2012
**
*/

public class ConvertNumber {

    public static void main(String[] args) {
        
        int i = Integer.parseInt(args[0]);
        
        System.out.println("Numerical: " + i + "\n");
        
	// individual numbers go up to 19, then 
	// need tens, hundreds, and thousands.
        if (i == 0) {
            System.out.println("Range: 0");
        } else if (isBetween(i, 1, 19)) {
            System.out.println("Range: 01-19");
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
