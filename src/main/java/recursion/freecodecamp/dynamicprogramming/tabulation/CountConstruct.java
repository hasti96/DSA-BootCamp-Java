package recursion.freecodecamp.dynamicprogramming.tabulation;

import java.util.Arrays;
import java.util.List;

public class CountConstruct {

    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println(countConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println(countConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(countConstruct("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
        
    }

    public static int countConstruct(String targetString, List<String> wordBank) {
        int[] table = new int[targetString.length() + 1];

        Arrays.fill(table, 0);

        table[0] = 1;

        for (int i = 0; i < table.length; i++) {
            if (table[i] > 0) {
                for (String word : wordBank) {
                    int endStringIndex = i + word.length();

                    if(endStringIndex < table.length &&
                    targetString.substring(i, endStringIndex).equals(word) ) {
                        
                        table[endStringIndex] += table[i];
                    }
                }
            }

        }

        return table[targetString.length()];

    }
}
