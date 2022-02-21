package sort.lecture;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        Arrays.stream(sort(arr)).forEach(e -> System.out.print(e + " "));
    }

    public static int[] sort(int[] arr) {
        int i = 0;

        while(i < arr.length) {
            if(arr[i] == i + 1) {
                i++;
            } else {
                swap(arr, i, arr[i]-1);
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
