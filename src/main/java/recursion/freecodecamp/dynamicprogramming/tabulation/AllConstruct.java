package recursion.freecodecamp.dynamicprogramming.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function ' allConstruct(target, wordBank) ' that accepts
 * a target string and an array of strings.
 * ================================================================
 * 
 * The Function should return a 2D array containing all of the ways
 * that the target can be constructed by concatenating elements of
 * the 'wordBank' array. Each element of the 2D array should represent
 * one combination that constructs the target.
 * 
 * ================================================================
 * 
 * you may reuse elemets of ' wordBank ' as many times as needed.
 */

public class AllConstruct {

    public static void main(String[] args) {
        System.out.println(allConstruct( "abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c")));
        System.out.println(allConstruct( "purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println(allConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
    }

    public static List<List<String>> allConstruct(String targetString, List<String> wordBank) {        
        List<List<List<String>>> table = new ArrayList<>();

        for (int i = 0; i < targetString.length() + 1; i++) {
            table.add(null);
        }

        List<List<String>> index0List = new ArrayList<>();
        index0List.add(new ArrayList<>());

        table.set(0, index0List);

        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) != null) {

                for (String word : wordBank) {
                    int endStringIndex = i + word.length();

                    if (endStringIndex < table.size()
                        && targetString.substring(i, endStringIndex).equals(word)) {

                        if(table.get(endStringIndex) == null) {
                            table.set(endStringIndex, new ArrayList<>());
                        }
                        
                        List<List<String>> temp = new ArrayList<>();
                        table.get(i).forEach( e -> 
                            temp.add(new ArrayList<>(e)));
                        
                        temp.forEach(e -> e.add(word));
                        
                        table.get(endStringIndex).addAll(temp);
                    }
                }
            }
        }

        return table.get(targetString.length());
    }
}
