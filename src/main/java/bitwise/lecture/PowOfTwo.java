package bitwise.lecture;

/**
 * Q. Check if number is power of two.
 */
public class PowOfTwo {
    public static void main(String[] args) {
        int n = 0;
        boolean ans = n > 0 && (n & (n - 1)) == 0;
        System.out.println(ans);
    }
}
