package recursion.freecodecamp.dynamicprogramming.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function howSum(targetSum, numbers) that takes in a targetSum and an
 * array of numbers as arguments.
 * 
 * The function should return an array containing any combination of elements
 * that add up to exactly the targetSum
 * 
 * If there is no combination that adds up to the targetSum, then return null
 * 
 * If there are multiple combination possible, you may return any single one;
 * 
 */

public class HowSum {
    
    public static void main(String[] args) {
        
        System.out.println(howSum(7, Arrays.asList(2, 3)));
        System.out.println(howSum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(howSum(7, Arrays.asList(2, 4)));        
        System.out.println(howSum(8, Arrays.asList(2, 3, 5)));
        System.out.println(howSum(300, Arrays.asList(7, 14)));
    }

    public static List<Integer> howSum(int targetSum, List<Integer> numbers) {
        List<List<Integer>> table = new ArrayList<>(targetSum + 1);

        for (int i = 0; i < targetSum+1; i++) {
            table.add(null);   
        }
        
        table.set(0, new ArrayList<>());

        for(int i=0; i < table.size(); i++) {
            if(table.get(i) != null) {

                for(int j=0; j < numbers.size(); j++) {
                    int index = i + numbers.get(j);

                    if(index < table.size()) {
                        List<Integer> temp =  new ArrayList<>();

                        temp.addAll(table.get(i));
                        temp.add(numbers.get(j));
                        table.set(index, temp);
                    }
                }
            }
        }

        return table.get(targetSum);
    } 
}
