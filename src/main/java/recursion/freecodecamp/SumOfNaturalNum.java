package recursion.freecodecamp;

public class SumOfNaturalNum {
    public static void main(String[] args) {
        System.out.println(sumOfNums(4));
    }

    private static int sumOfNums(int a) {
        if(a <= 1) {
            return a;
        }

        return sumOfNums(a - 1) + a;
    }
}
