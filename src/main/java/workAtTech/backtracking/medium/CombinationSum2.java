package workAtTech.backtracking.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] A = new int[] { 10, 1, 2, 7, 6, 1, 5 };
        // int[] A = new int[] { 1, 2, 3};
        List<Integer> input = new ArrayList<>();
        for (int a : A)
            input.add(a);
        input.sort(Comparator.naturalOrder());

        // combinationSum(new ArrayList<>(), input, 8);
        System.out.println(combinationSumList(new ArrayList<>(), input, 8));
    }

    public static List<List<Integer>> combinationSumList(List<Integer> down, List<Integer> input, int target) {
        if (target == 0) {
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(down);
            return temp;
        }

        if (target < 0 || input.isEmpty()) {
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>(down);
        List<List<Integer>> left = combinationSumList(temp, input.subList(1, input.size()), target);
        
        if(left != null) {
            ans.addAll(left);
        }

        Integer firstNum = input.get(0);
        if (firstNum <= target) {
            temp.add(firstNum);
            List<List<Integer>> right = combinationSumList(temp, input.subList(1, input.size()), target - firstNum);

            if(right != null) {
                right.stream().filter( e-> !ans.contains(e)).forEach(e->ans.add(e));              
            }
        }


        return ans;
    }

    public static void combinationSum(List<Integer> down, List<Integer> input, int target) {
        if (target == 0) {
            System.out.println(down);
            return;
        }

        if (target < 0 || input.isEmpty()) {
            return;
        }

        Integer firstNum = input.get(0);

        List<Integer> temp = new ArrayList<>(down);
        combinationSum(temp, input.subList(1, input.size()), target);
        
        if (firstNum <= target) {
            temp.add(firstNum);
            combinationSum(temp, input.subList(1, input.size()), target - firstNum);
        }
    }

    public static List<List<Integer>> combinationSum(int[] input, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());


        for (int i = 0; i < input.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            ans.forEach( e-> temp.add(new ArrayList<>(e)));

            for(List<Integer> list : temp) {
                list.add(input[i]);
            }

            ans.addAll(temp);
        }

        return ans;
    }
}
