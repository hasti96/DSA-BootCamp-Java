package recursion.freecodecamp.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstruct {
    
    private static Map<String, Boolean> cache = new HashMap<>();
    public static void main(String[] args) {
        
        System.out.println(canConstructWithMemo("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));cache.clear();
        System.out.println(canConstructWithMemo("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));cache.clear();
        System.out.println(canConstructWithMemo("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));cache.clear();
        System.out.println(canConstructWithMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList(
            "e", 
            "ee", 
            "eee", 
            "eeee", 
            "eeeee",
            "eeeeee"
            )));cache.clear();
    }

    public static boolean canConstruct(String target, List<String> wordBank) {
        
        if(target.equals("")) return true;

        for (int i = 0; i < wordBank.size(); i++) {
            if(target.indexOf(wordBank.get(i)) == 0) {
                if(canConstruct(target.substring(wordBank.get(i).length()), wordBank)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean canConstructWithMemo(String target, List<String> wordBank) {
        
        if(cache.containsKey(target)) return cache.get(target);
        if(target.equals("")) return true;

        for (int i = 0; i < wordBank.size(); i++) {
            if(target.indexOf(wordBank.get(i)) == 0) {
                String suffix = target.substring(wordBank.get(i).length());
                boolean isPossibleToContruct = canConstructWithMemo(suffix, wordBank);
                if(isPossibleToContruct) {
                    cache.put(suffix, true);
                    return true;
                }
            } 
        }

        cache.put(target, false);
        return cache.get(target);
    }
}