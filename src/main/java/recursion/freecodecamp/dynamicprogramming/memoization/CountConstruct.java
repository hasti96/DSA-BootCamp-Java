package recursion.freecodecamp.dynamicprogramming.memoization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * =================================================================
 * Write a function countConstruct(target, wordBank) that accepts
 *  a ' target ' string and an array of strings.
 * =================================================================
 * The function should return the number of ways that the target can 
 * be constructed by concatenating elements of the 'wordBank' array.
 * =================================================================
 * You may reuse elements of wordBank as many times as needed.
 * =================================================================
 */

public class CountConstruct {
    
    private static Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println(countConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));

        System.out.println(countConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(countConstruct("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
        // System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
        System.out.println("============================================================================================================");
        System.out.println(countConstructWithMemo("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));cache.clear();
        System.out.println(countConstructWithMemo("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));cache.clear();
    
        System.out.println(countConstructWithMemo("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));cache.clear();
        System.out.println(countConstructWithMemo("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));cache.clear();
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
    }

    public static int countConstruct(String target, List<String> wordBank) {

        if(target.equals("")) return 1; 

        int count = 0;

        for (int i = 0; i < wordBank.size(); i++) {
            if(target.indexOf(wordBank.get(i)) == 0) {
                String suffix = target.substring(wordBank.get(i).length());
                count += countConstruct(suffix, wordBank);
            }
        }

        return count;
    }

    public static int countConstructWithMemo(String target, List<String> wordBank) {
        
        if(cache.containsKey(target)) return cache.get(target);
        if(target.equals("")) return 1;
        
        int count = 0;

        for (int i = 0; i < wordBank.size(); i++) {
            if(target.indexOf(wordBank.get(i)) == 0) {
                String suffix = target.substring(wordBank.get(i).length());
                count += countConstructWithMemo(suffix, wordBank);
            }
        }
        
        cache.put(target, count);
        return count;
    }
}
