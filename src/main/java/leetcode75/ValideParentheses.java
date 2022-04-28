package leetcode75;

import java.util.Map;
import java.util.Stack;

/**
 * @see -> https://leetcode.com/problems/valid-parentheses/
 */
public class ValideParentheses {

    public static void main(String[] argv) {
        System.out.println(isValid("{}{}[]"));
    }

    public static boolean isValid(String s) {
        Stack<String> paren = new Stack<>();

        Map<String, String> bracket = Map.of("(", ")", "[", "]", "{", "}");

        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));

            if (bracket.containsKey(temp)) {
                paren.push(temp);
                System.out.println(temp);
            } else {

                if (paren.isEmpty() || !bracket.get(paren.pop()).equals(temp)) {
                    return false;
                }
            }
        }

        return paren.isEmpty();
    }
}
