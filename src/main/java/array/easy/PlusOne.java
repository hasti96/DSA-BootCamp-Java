package array.easy;

public class PlusOne {
    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        int carry = 0;
        int arrLen = digits.length;

        for(int i=arrLen-1; i >= 0; i--) {
            if(i == arrLen-1) {
                digits[i] = digits[i] + carry + 1;
            } else {
                digits[i] = digits[i] + carry;
            }

            if(digits[i] > 9) {
                carry = 1;
                digits[i] = 0;
            } else {
                carry = 0;
            }
        }

        if(carry > 0) {
            int[] result = new int[arrLen+1];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }

}
