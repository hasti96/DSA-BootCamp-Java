package recursion.lecture;

public class SumOfDigit {
    
    public static void main(String args[]) {
        System.out.println(sumOfDigit(1342));
    }

    public static int sumOfDigit(int digit) {
        if(digit == 0) {
            return 0;
        }
        
        int a = digit/10;
        int b = digit%10;

        return b + sumOfDigit(a);
    }
}
