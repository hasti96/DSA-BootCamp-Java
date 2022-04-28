package recursion.freecodecamp.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    private static Map<Integer, Boolean> cache = new HashMap<>();

    public static void main(String[] argv) {
        // int[] input1 = {5,3,4,7};
        int[] input2 = {7, 14};

        System.out.println(canSum(300, input2));
    }

    public static boolean canSum(int target, int[] input) {

        if(cache.containsKey(target)) {
            return cache.get(target);
        }

        if(target == 0) return true;
        if(target < 0) return false;

        for (int i = 0; i < input.length; i++) {
            int remainder = target - input[i];

            if (canSum(remainder, input)) {
                cache.put(target, true);
                return true;
            }
        }

        cache.put(target, false);
        return false;
    }
}
