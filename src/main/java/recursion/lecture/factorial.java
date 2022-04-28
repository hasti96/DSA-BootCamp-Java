package recursion.lecture;

public class factorial {
    public static void main(String[] argv) {
        System.out.println(calFactorial(10));
    }

    public static int calFactorial(int n) {
        if(n == 1) {
            return 1;
        }

        return n * calFactorial(n-1);
    }
}
