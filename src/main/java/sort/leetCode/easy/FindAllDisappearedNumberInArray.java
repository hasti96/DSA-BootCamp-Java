package sort.leetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Q2.-> https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
/**
 * Q2. https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
 */
public class FindAllDisappearedNumberInArray {

    public static void main(String[] args) {

        int[] arr = {4,3,2,7,8,2,3,1};
        Arrays.stream(customCyclicSort(arr)).forEach(e -> System.out.print(e + " "));
        System.out.println("\n" + findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> retVal = new ArrayList<>();

        int[] sortedArray = customCyclicSort(nums);
        int i = 0;
        for(i=0; i < sortedArray.length; i++) {
            if(i != sortedArray[i]-1) {
                retVal.add(i+1);
            }
        }
        return retVal;
    }

    public static int[] customCyclicSort(int[] arr) {
        int i = 0;

        while(i < arr.length) {
            if(arr[i] - 1 == i || arr[i] - 1 > arr.length-1) {
                i++;
            } else {
                if(arr[i] - 1 < arr.length && arr[i] != arr[arr[i]-1]) {
                    swap(arr, i, arr[i]-1);
                } else {
                    i++;
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
