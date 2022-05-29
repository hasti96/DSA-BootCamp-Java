package workAtTech.dynamicProgramming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    
    public static void main(String[] args) {
        System.out.println(subSets(Arrays.asList(4, 4, 4, 1, 4)));
        // int[] arr = { 1, 3, 3 };

        // Arrays.asList(arr);
    }

    public static List<List<Integer>> subSets(List<Integer> A) {
        if (A.size() == 0) {
            List<Integer> temp = new ArrayList<>();
            List<List<Integer>> temp2 = new ArrayList<>();

            temp2.add(temp);
            return temp2;
        }

        List<Integer> firstElement = new ArrayList<>();
        firstElement.add(A.get(0));

        List<List<Integer>> restSubSet = subSets(A.subList(1, A.size()));
        List<List<Integer>> restSubSet1 = new ArrayList<>();
        
        restSubSet.stream().forEach(e -> {
            if (e.size() > 0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(firstElement.get(0));
                temp.addAll(e);

                if(!restSubSet.contains(temp)) {
                    restSubSet1.add(temp);
                }
                
            }
        });

        restSubSet.add(firstElement);
        
        restSubSet.addAll(restSubSet1);

        return restSubSet;
    }


}
