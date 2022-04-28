package recursion.lecture;

public class reverseNumber {

    public static void main(String[] args) {
        System.out.println(reverseNum(1342, 0));
    }

    public static int reverseNum(int num, int result) {

        if(num == 0) {
            return result;
        }

        int q = num / 10;
        int r = num % 10;

        result = (result * 10) + r;

        return reverseNum(q, result);

    }
}
