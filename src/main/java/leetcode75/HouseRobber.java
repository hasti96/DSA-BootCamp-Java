package leetcode75;

import java.util.HashMap;
import java.util.Map;

/**
 * Q.42 -> https://leetcode.com/problems/house-robber/
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

    private static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};

        System.out.println(rob(arr, arr.length-1));
    }

    public static int rob(int[] input, int i) {

        if(cache.containsKey(i)) {
            return cache.get(i);
        }

        if(i < 0) {
            return 0;
        }

        int temp = Math.max(input[i] + rob(input, i-2), rob(input, i-1));

        cache.put(i, temp);
        
        return cache.get(i);
    }
}
