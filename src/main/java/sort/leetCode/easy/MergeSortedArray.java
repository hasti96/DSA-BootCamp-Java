package sort.leetCode.easy;

/**
 * Q2. https://leetcode.com/problems/merge-sorted-array/
 */

public class MergeSortedArray {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i > -1 && j > -1) {
            if(nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }

        while(j>-1) {
            nums1[k--] = nums2[j--];
        }

    }
}
