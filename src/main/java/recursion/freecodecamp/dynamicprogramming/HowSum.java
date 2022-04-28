package recursion.freecodecamp.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    
    private static Map<Integer, List<Integer>> cache = new HashMap<>(); 

    @SuppressWarnings("all")
    public static void main(String[] args) {
        int[] input1 = {5,3,4,7};
        int[] input2 = {7, 14};
        int[] input3 = {2, 4};
        int[] input4 = {7, 14};

        System.out.println(findSum(300, input4));
    }

    public static List<Integer> findSum(int target, int[] elements) {
            
        List<Integer> ans = null;

        if(target == 0) {
            return new ArrayList<>();
        }

        if(target < 0) {
            return null;
        }

        for(int i=0; i < elements.length; i++) {
            int remainder = target - elements[i];
            ans = findSum(remainder, elements);
            if(ans != null) {
               ans.add(elements[i]);
               return ans;
            }
        }

        return null;

    }

    public static List<Integer> findSumUsingMemo(int target, int[] elements) {
        
        if(cache.containsKey(target)) return cache.get(target);
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        List<Integer> ans = null;

        for(int i=0; i < elements.length; i++) {
            int remainder = target - elements[i];
            ans = findSum(remainder, elements);
            if(ans != null) {
               ans.add(elements[i]);
               cache.put(target, ans);
               return cache.get(target);
            }
        }

        cache.put(target, null);
        return null;

    }
}
