package recursion.freecodecamp.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

 @SuppressWarnings("All")
public class AllConstruct {
    
    private static Map<String, List<List<String>>> cache = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(allConstruct( "abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c")));
        System.out.println(allConstruct( "purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));

        System.out.println("==============================================================================");

        System.out.println(allConstructWithMemo( "abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c")));
        System.out.println(allConstructWithMemo( "purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
    }

    public static List<List<String>> allConstruct(String target, List<String> wordBank) {

        if(target.equals("")) {
            List<String> temp = new ArrayList<>();
            List<List<String>> retVal = new ArrayList<>();
            retVal.add(temp);
            return retVal;
        }
        
        List<List<String>> ans = null;

        for (int i = 0; i < wordBank.size(); i++) {
            if(target.indexOf(wordBank.get(i)) == 0) {
                String suffix = target.substring(wordBank.get(i).length());
                List<List<String>> temp = allConstruct(suffix, wordBank);
                if(temp != null) {
                    if(ans == null) {
                        ans = new ArrayList<>();
                    }

                    for (List<String> list : temp) {
                        list.add(wordBank.get(i)); 
                        ans.add(list);
                    }
                }
            }
        }

        return ans;
    }

    public static List<List<String>> allConstructWithMemo(String target, List<String> wordBank) {

        if(cache.containsKey(target)) return cache.get(target);

        if(target.equals("")) {
            List<String> temp = new ArrayList<>();
            List<List<String>> retVal = new ArrayList<>();
            retVal.add(temp);
            return retVal;
        }
        
        List<List<String>> ans = null;

        for (int i = 0; i < wordBank.size(); i++) {
            if(target.indexOf(wordBank.get(i)) == 0) {
                String suffix = target.substring(wordBank.get(i).length());
                List<List<String>> temp = allConstruct(suffix, wordBank);
                if(temp != null) {
                    if(ans == null) {
                        ans = new ArrayList<>();
                    }

                    for (List<String> list : temp) {
                        list.add(wordBank.get(i)); 
                        ans.add(list);
                    }
                }
            }
        }

        cache.put(target, ans);
        return ans;
    }
}
