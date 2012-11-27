/*
**
** Daniel Engel 2012
**
*/

public class ConvertNumber {

    public static void main(String[] args) {
        
        int i = Integer.parseInt(args[0]);
        
        System.out.println("Numerical: " + i + "\n");
        
        if (i == 0) {
            System.out.println("Range: 0");
        } else if (isBetween(i, 1, 10)) {
            System.out.println("Range: 01-10");
        } else if (isBetween(i, 10, 20)) {
            System.out.println("Range: 10-20");
        } else if (isBetween(i, 20, 999)) {
            System.out.println("Range: 20-999");
        } else if (isBetween(i, 1000, 999999)) {
            System.out.println("Range: 1000-999999");
        }

        System.exit(0);
        
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

}
