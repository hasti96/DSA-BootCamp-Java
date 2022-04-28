package recursion.lecture;

public class fibonacci {

    public static void main(String[] argv) {
        System.out.println(fibonacciNum(8));
    }

    public static int fibonacciNum(int number) {
        if(number <= 1) {
            return number;
        }

        return fibonacciNum(number - 2) + fibonacciNum(number - 1);
    }
}
