package workAtTech.dynamicProgramming.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(comb(4, 2));
        System.out.println(comb(3, 3));
        System.out.println(comb(4, 1));
    }

    private static List<List<Integer>> comb(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for(int i =1; i <=n; i++) {
            num.add(i);
        }

        return combinations(new ArrayList<>(), n, k);
    }

    public static List<List<Integer>> combinations(List<Integer> nums, int n, int k) {
        if(nums.size() == k) {
            List<Integer> temp = new ArrayList<>(nums);
            List<List<Integer>> temp1 = new ArrayList<>();
            temp1.add(temp);
            return temp1;
        }

        List<List<Integer>> retList = new ArrayList<>();
        int startIndex = nums.size() == 0 ? 0 : nums.get(nums.size()-1).intValue();
        for(int i=startIndex; i < n; i++) {
            nums.add(i+1);
            retList.addAll(combinations(nums, n, k));
            nums.remove(nums.size()-1);     
        }

        return retList;
	}
}
