package workAtTech.stringAndTries;

public class ReverseWordInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("yoda is a jedi"));
    }

    public static String reverseWords(String s) {
        int len = s.length();
        char[] ans = new char[len];

        for (int i = len - 1, j = 0; i > -1; i--, j++) {
            ans[j] = s.charAt(i);
        }

        for (int i = 0, j = 0; i < len; i++) {
            if (ans[i] == ' ') {
                reverseCharArray(ans, j, i-1);
                j = i+1;
            }

            if(i == len - 1) {
                reverseCharArray(ans, j, i);  
            }
        }

        return new String(ans);
    }

    public static void reverseCharArray(char[] input, int i, int j) {
        while (i <= j) {
            char ch = input[i];
            input[i] = input[j];
            input[j] = ch;

            i++;
            j--;
        }
    }
}
