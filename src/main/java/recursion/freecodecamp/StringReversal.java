package recursion.freecodecamp;

public class StringReversal {
    public static void main(String[] argv) {
        String input = "Hastimal";

        System.out.println(reverseString(input));
    }

    public static String reverseString(String input) {
        if(input.length() <= 0 ) {
            return input;
        }
        
        return reverseString(input.substring(1)) + input.charAt(0);
    }
}
