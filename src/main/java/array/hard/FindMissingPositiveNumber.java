package array.hard;


import java.util.*;

/**
 * Q1. https://leetcode.com/problems/first-missing-positive/
 */
public class FindMissingPositiveNumber {

    public static void main(String[] args) {
        int[] nums = {-1,1,4,3};
        firstMissingPositive(nums);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > 0) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }

        if(min-1 > 0) {
            return 1;
        } else {
            List<Boolean> arrayList = new ArrayList<Boolean>();
            for(int a: nums) {
                if(a > -1) {
                    arrayList.set(a%min, true);
                }
            }

            for(int i=0; i < arrayList.size(); i++) {
                if (!arrayList.get(i)) {
                    return i;
                }
            }

            return max+1;
        }
    }
}
