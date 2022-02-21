package sort.leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        Arrays.stream(cyclicSort(arr)).forEach(e -> System.out.print(e + " "));
        System.out.println("\n" + findDuplicates(arr));

    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> retVal = new ArrayList<>();

        int[] sortedArray = cyclicSort(nums);
        int i;
        for(i=0; i < sortedArray.length; i++) {
            if(i != sortedArray[i]-1) {
                retVal.add(sortedArray[i]);
            }
        }
        return retVal;
    }

    public static int[] cyclicSort(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correctIdx = arr[i] - 1;

            if(arr[i] != arr[correctIdx]) {
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
