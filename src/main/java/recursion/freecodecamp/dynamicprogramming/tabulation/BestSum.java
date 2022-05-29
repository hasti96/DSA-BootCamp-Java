package recursion.freecodecamp.dynamicprogramming.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function bestSum(targetSum, numbers) that takes in a
 * targetSum and an array of numbers as argumnets
 * 
 * The function should return an array containing the shortest
 * combination of numbers that add up to exactly the targetSum
 * 
 * If there is a tie for the shortest combination, you may return
 * any one of the shortest
 */

public class BestSum {

    public static void main(String[] args) {

        System.out.println(bestSum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(bestSum(8, Arrays.asList(2, 3, 5)));
        System.out.println(bestSum(8, Arrays.asList(1, 4, 5)));
        System.out.println(bestSum(100, Arrays.asList(1, 2, 5, 25)));
        System.out.println(bestSum(100, Arrays.asList(1, 2, 5, 50)));

    }

    public static List<Integer> bestSum(int targetSum, List<Integer> numbers) {

        List<List<Integer>> table = new ArrayList<>();

        for (int i = 0; i < targetSum + 1; i++) {
            table.add(null);
        }

        table.set(0, new ArrayList<>());

        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) != null) {

                for (int j = 0; j < numbers.size(); j++) {
                    int index = i + numbers.get(j);

                    if (index < table.size()) {
                        List<Integer> temp = new ArrayList<>();

                        temp.addAll(table.get(i));
                        temp.add(numbers.get(j));

                        if (table.get(index) == null || 
                            (table.get(index) != null && table.get(index).size() > temp.size())) {
                            table.set(index, temp);
                        }
                    }
                }
            }
        }

        return table.get(targetSum);
    }
}
