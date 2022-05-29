package workAtTech.backtracking.medium;

public class PalindromePartition {
    public static void main(String[] args) {
        palindrome("", "abcc");
    }

    public static void palindrome(String down,String input) {
        if(isValidPalindrom(down))
            System.out.println(down + ", " + input);

        if(input.isEmpty()) {
            // System.out.println(down);
            return;
        }

        String firstString = input.substring(0, 1);

        
        // palindrome(down, input.substring(1));
        palindrome(down+firstString, input.substring(1));
    }

    public static boolean isValidPalindrom(String input) {
        if(input.length() == 0) return false;
        if(input.length() == 1) return true;

        int start = 0;
        int end = input.length() - 1;

        while(start < end) {
            if(input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++; end--;
        }

        return true;
    }
}
