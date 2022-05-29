package workAtTech.stringAndTries;

public class LongestPalindromeInString {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("mississippi"));
        System.out.println(longestPalindrome("abc"));
        System.out.println(longestPalindrome("avcccvbgf"));
        System.out.println(longestPalindrome("abcdc"));
        System.out.println(longestPalindrome("a"));

    }

    public static String longestPalindrome(String s) {
        if (s != null && s.length() <= 1)
            return s;

        int len = 0, start = 0, end = 0, len1 = 0, len2 = 0;

        for (int i = 0; i < s.length(); i++) {
            len1 = expandAroundCenter(s, i, i);
            len2 = expandAroundCenter(s, i, i + 1);

            len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        if(start == end) return s.substring(0, 1);
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
