package recursion.freecodecamp.dynamicprogramming.tabulation;

import java.util.Arrays;
import java.util.List;

public class CanConstruct {

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println(canConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(canConstruct("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList(
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee")));
    }

    public static boolean canConstruct(String targetString, List<String> wordBank) {

        boolean[] table = new boolean[targetString.length() + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for (int i = 0; i < table.length; i++) {
            if (table[i]) {
                for (int j = 0; j < wordBank.size(); j++) {
                    int endStringIndex = i + wordBank.get(j).length();

                    if (endStringIndex < table.length && targetString.substring(i, endStringIndex).equals(wordBank.get(j))) {
                        table[endStringIndex] = true;  
                    }
                }
            }
        }

        return table[targetString.length()];
    }
}
