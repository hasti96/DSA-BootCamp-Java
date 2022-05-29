package workAtTech.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSum {
    public static void main(String[] args) {
        subsetSum(new ArrayList<>(), Arrays.asList(1, 3, 4, 9, 2), 13);
    }

    boolean subsetSumPossible(List<Integer> down, List<Integer> input, int target) {
        if (target == 0) {
            // System.out.println(down);
            return true;
        }

        if (target < 0 || input.isEmpty())
            return false;

        Integer firstElement = input.get(0);

        List<Integer> temp = new ArrayList<>(down);
        boolean left = subsetSumPossible(down, input.subList(1, input.size()), target);

        if (firstElement <= target && !left) {
            temp.add(firstElement);
            return subsetSumPossible(temp, input.subList(1, input.size()), target - firstElement);
        }

        return left;
    }

    public static void subsetSum(List<Integer> down, List<Integer> input, int target) {
        if (target == 0) {
            System.out.println(down);
            return;
        }

        if (target < 0 || input.isEmpty())
            return;

        Integer firstElement = input.get(0);

        List<Integer> temp = new ArrayList<>(down);
        subsetSum(down, input.subList(1, input.size()), target);

        if (firstElement <= target) {
            temp.add(firstElement);
            subsetSum(temp, input.subList(1, input.size()), target - firstElement);
        }
    }
}
