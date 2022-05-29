package recursion.freecodecamp.dynamicprogramming.tabulation;

import java.util.Arrays;

/**
 * Write a function canSun(targetSum, numbers) that takes in a
 * targetSum and an array of numbers as arguments
 * 
 * The function should return a boolean indicating whether or not it 
 * is possible to generate the targetSum using numbers from the array.easy
 * 
 * You may use an element of the array as many times as needed
 * 
 * you nay assume that all the input numbers are non-negative
 */

public class CanSum {
    
    public static void main(String[] args) {
        int[] arr1 = {5,3,4, 7};
        int[] arr2 = {2, 3};
        int[] arr3 = {2, 3, 5};
        int[] arr4 = {7, 14};

        System.out.println(canSum(7, arr1));
        System.out.println(canSum(7, arr2));
        System.out.println(canSum(8, arr3));
        System.out.println(canSum(300, arr4));

    }

    private static boolean canSum(int targetSum, int[] elements) {

        boolean[] table = new boolean[targetSum+1];

        Arrays.fill(table, false);

        table[0] = true;

        for(int i=0; i < table.length ; i++) {
            if(table[i]) {
                for(int j=0; j < elements.length; j++) {
                    int index = i+elements[j];
                    if(index < table.length) {
                        table[index] = true;
                    }
                }
            }
        }

        return table[targetSum];
    }
}
