package bitwise.lecture;

public class SetBits {
    public static void main(String[] args) {
        int n = 1523;
        int count = 0;

        System.out.println(Integer.toBinaryString(n));

        while(n > 0) {
            count++;
            n = n & (n-1);
        }

        System.out.println(count);
    }
}
