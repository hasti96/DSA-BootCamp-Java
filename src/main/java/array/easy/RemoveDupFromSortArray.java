package array.easy;

/**
 * Q2. https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

public class RemoveDupFromSortArray {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int idx = 1;

        for(int i=1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }
}
