package recursion.freecodecamp;

public class Palindrome {
    
    public static void main(String[] args) {
        System.out.println(checkPalString("raceacar"));
    }

    public static boolean checkPalString(String input) {
        if(input.length() <= 1) {
            return true;
        }

        if(input.charAt(0) == input.charAt(input.length() - 1)) {
            return checkPalString(input.substring(1, input.length() - 1));
        }

        return false;
    }
}
