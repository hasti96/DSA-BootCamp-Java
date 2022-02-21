package sort.leetCode.hard;

/**
 * Q1. https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    public static void main(String[] args) {

    }

    public static int firstMissingPositive(int[] nums) {
        int[] sortArr = cyclicSort(nums);

        int i;
        for(i=0; i < sortArr.length; i++) {
            if(i != sortArr[i] - 1) {
                return i+1;
            }
        }

        return i+1;
    }

    public static int[] cyclicSort(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correctIdx = arr[i] - 1;
            if(correctIdx > -1 && correctIdx < arr.length &&
                    arr[i] != arr[correctIdx]) {

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
