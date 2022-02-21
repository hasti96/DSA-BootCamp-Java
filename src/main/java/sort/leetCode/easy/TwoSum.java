package sort.leetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Q1. https://leetcode.com/problems/two-sum
 */

public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        int[] retVal = new int[2];
        Map<Integer, Integer> diffMap = new HashMap<>();

        for(int i=0; i < nums.length; i++) {
            if(diffMap.containsKey(nums[i])) {
                retVal[0] = i;
                retVal[1] = diffMap.get(nums[i]);
            } else {
                int diffVal = target - nums[i];
                diffMap.put(diffVal, i);
            }
        }

        return retVal;
    }
}
