package workAtTech.dynamicProgramming.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] input1 = { 10, 20, 2, 5, 3, 8, 8, 25, 6 };

        System.out.println(getLengthOfLIS(input1));
    }

    private static int getLengthOfLIS(int[] A) {
        int[] table = new int[A.length];
        Arrays.fill(table, 1);

        for (int i = A.length - 1; i > -1; i--) {
            for (int j = i - 1; j > -1; j--) {
                if (A[i] > A[j]) {
                    table[i] = Math.max(table[i], 1 + table[j]);
                }
            }
        }
        
        return Arrays.stream(table).max().getAsInt();
    }

    // private static List<Integer> getLis(List<Integer> nums) {

    //     List<Integer> temp = new ArrayList<>(nums.get(0));
        
    //     List<Integer> Lis = getLis(nums.subList(1, nums.size()));
        
    // }
 }
