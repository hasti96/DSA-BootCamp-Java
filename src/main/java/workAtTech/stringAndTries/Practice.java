package workAtTech.stringAndTries;

public class Practice {
    public static void main(String[] args) {
        drive("", "aacabdkacaa");   
    }

    public static void drive(String down, String s) {

        if(isValidPalindrom(down)) {
            System.out.print(down + ", ");
            return;
        }
        
        for(int i=1; i < s.length(); i++) {
            drive(down, s.substring(i));
            drive(down + s.substring(0, i), s.substring(i));
        }
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
