package sort.leetCode.medium;

import java.util.Arrays;

/**
 * Q1. https://leetcode.com/problems/find-the-duplicate-number
 */

public class DuplicateNumber {

    public static void main(String[] args) {

        int[] arr = {3,1,3,4,2};
        Arrays.stream(cyclicSort(arr)).forEach(e -> System.out.print(e + " "));
        System.out.println("\n" + findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        int[] sortedArr = cyclicSort(nums);

        for(int i=0; i < sortedArr.length; i++) {
            if(sortedArr[i]-1 != i && sortedArr[i] < sortedArr.length) {
                return sortedArr[i];
            }
        }

        return -1;
    }

    public static int[] cyclicSort(int[] arr) {
        int i = 0;

        while(i < arr.length) {
            int correctIdx = arr[i] - 1;

            if(i != correctIdx && arr[i] != arr[correctIdx]) {
                swap(arr, i, correctIdx);
            } else {
                i++;
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
