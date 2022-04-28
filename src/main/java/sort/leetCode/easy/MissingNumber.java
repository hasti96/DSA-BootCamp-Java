package sort.leetCode.easy;

import java.util.Arrays;

/**
 * Q1. https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    public static void main(String[] args) {

        int[] arr = {6,5,4,3,2,1,0};
        Arrays.stream(customCyclicSort(arr)).forEach(e -> System.out.print(e + " "));
        System.out.println("\n" + missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        int[] sortedArray = customCyclicSort(nums);
        int i = 0;
        for(i=0; i < sortedArray.length; i++) {
            if(i != sortedArray[i]) {
                return i;
            }
        }
        return i;
    }

    public static int[] customCyclicSort(int[] arr) {
        int i = 0;

        while(i < arr.length) {
            if(arr[i] == i || arr[i] > arr.length-1) {
                i++;
            } else {
                if(arr[i] < arr.length) {
                    swap(arr, i, arr[i]);
                }
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
