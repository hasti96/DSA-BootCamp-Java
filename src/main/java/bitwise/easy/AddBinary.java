package bitwise.easy;

/**
 * 1. Add Binary : https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int m = a.length()-1;
        int n = b.length()-1;

        int carry = 0;

        while(m > -1 || n > -1) {

            int n1 = m > -1 ? a.charAt(m) - '0' : 0;
            int n2 = n > -1 ? b.charAt(n) - '0' : 0;

            int sum = n1 + n2 + carry;

            result.append(sum % 2);
            carry = sum / 2;

            m--;n--;
        }

        if(carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
