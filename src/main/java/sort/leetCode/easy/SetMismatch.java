package sort.leetCode.easy;

/**
 * Q3. https://leetcode.com/problems/set-mismatch
 */
public class SetMismatch {

    public static void main(String[] args) {

    }

    public int[] findErrorNums(int[] nums) {
        int[] sortedArr = cyclicSort(nums);
        int[] retVal = new int[2];

        for(int i=0; i < sortedArr.length; i++) {
            if(i != sortedArr[i] - 1) {
                retVal[0] = sortedArr[i];
                retVal[1] = i+1;

                return retVal;
            }
        }

        return retVal;
    }

    private static int[] cyclicSort(int[] arr) {
        int i=0;

        while (i < arr.length) {
            int correctIdx = arr[i] - 1;

            if(arr[i] != arr[correctIdx]) {
                swap(arr, i , correctIdx);
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
