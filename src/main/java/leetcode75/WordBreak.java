package leetcode75;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList(
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] table = new boolean[s.length() + 1];
        Arrays.fill(table, false);

        table[0] = true;

        for (int i = 0; i < table.length; i++) {
            if (table[i]) {
                for (String word : wordDict) {
                    int index = i + word.length();

                    if (index < table.length && s.substring(i, index).equals(word)) {
                        table[index] = true;
                    }
                }
            }
        }

        return table[s.length()];
    }
}
