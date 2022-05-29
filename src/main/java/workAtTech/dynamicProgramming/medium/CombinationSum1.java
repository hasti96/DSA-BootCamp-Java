package workAtTech.dynamicProgramming.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static void main(String[] args) {
        int[] input = {1,2};
        System.out.println(combinationSum(input, 4));
    }

    public static List<List<Integer>> combinationSum(int[] A, int val) {
	    if(val == 0) {
            List<Integer> temp = new ArrayList<>();
            List<List<Integer>> temp2 = new ArrayList<>();
            temp2.add(temp);
            return temp2;
        };

        if(val < 0) return null;

        List<List<Integer>> allCombination = new ArrayList<>();

        for(int i=0; i < A.length; i++) {
            List<List<Integer>> retVal = combinationSum(A, val-A[i]);
            if(retVal != null) {
                for(List<Integer> list: retVal) {
                    list.add(A[i]);
                }
                allCombination.addAll(retVal);        
            }
            
        }

        return allCombination;
	}
}
