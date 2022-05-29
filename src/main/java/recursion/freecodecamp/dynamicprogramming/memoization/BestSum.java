package recursion.freecodecamp.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("All")
public class BestSum {
    
    private static Map<Integer, List<Integer>> cache = new HashMap<>();
    public static void main(String[] args) {
        int[] input1 = {5,3,4,7};
        int[] input2 = {2, 3, 5};
        int[] input3 = {1, 4, 5};
        int[] input4 = {1,2,5,25};

        System.out.println(bestSumwithMemo(7, input1));cache.clear();
        System.out.println(bestSumwithMemo(8, input2));cache.clear();
        System.out.println(bestSumwithMemo(8, input3));cache.clear();
        System.out.println(bestSumwithMemo(100, input4));cache.clear();
    } 

    private static List<Integer> bestSum(int target, int[] numbers) {
        
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        List<Integer> shortestCombination = null;

        for(int i=0; i < numbers.length; i++) {
            int remainder = target - numbers[i];
            List<Integer> ans = bestSum(remainder, numbers);

            if(ans != null) {
                ans.add(numbers[i]);
                if(shortestCombination == null || shortestCombination.size() > ans.size()) {
                    shortestCombination = ans;
                } 
            }
        }
        
        return shortestCombination;
    }

    private static List<Integer> bestSumwithMemo(int target, int[] numbers) {
        
        if(cache.containsKey(target)) return cache.get(target);
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        List<Integer> shortestCombination = null;

        for(int i=0; i < numbers.length; i++) {
            int remainder = target - numbers[i];
            List<Integer> ans = bestSum(remainder, numbers);

            if(ans != null) {
                ans.add(numbers[i]);
                if(shortestCombination == null || shortestCombination.size() > ans.size()) {
                    shortestCombination = ans;
                } 
            }
        }
        
        cache.put(target, shortestCombination);
        return shortestCombination;
    }
}
