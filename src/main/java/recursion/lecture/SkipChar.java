package recursion.lecture;

public class SkipChar {
    public static void main(String[] args) {
        System.out.println(skipChar("baaccad", "a"));
    }

    public static String skipChar(String input, String skipchar) {
        if(input.isEmpty()) return new String();

        if(skipchar.charAt(0) == input.charAt(0)) {
            return skipChar(input.substring(1), skipchar);
        } else {
            return input.charAt(0) + skipChar(input.substring(1), skipchar);
        }
    }
}
