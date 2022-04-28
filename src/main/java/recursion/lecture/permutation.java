package recursion.lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class permutation {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3);
//        List<List<Integer>> result = new ArrayList<>();
//        permutationOfArr(arr, result, 0);
//        System.out.println(result);

        List<Integer> permutation = new ArrayList<>();

        boolean[] bPosition = new boolean[arr.size()];
        Arrays.fill(bPosition, false);

        permutationOfArr1(permutation, arr, bPosition);
    }

    public static void permutationOfArr(List<Integer> arr, List<List<Integer>> result, int position) {

        if(position == arr.size() - 1) {
            result.add(new ArrayList<>(arr));
            return;
        }

        for(int i = position; i < arr.size(); i++) {
            Collections.swap(arr, position, i);
            permutationOfArr(arr, result, position + 1);
            Collections.swap(arr, position, i);
        }
    }

    public static void permutationOfArr1(List<Integer> permutation, List<Integer> elements, boolean[] position) {
        if(permutation.size() == elements.size()) {
            System.out.println(permutation);
            return;
        }

        for(int i = 0; i < elements.size(); i++) {
            if(position[i]) {
                continue;
            }

            position[i] = true;
            permutation.add(elements.get(i));

            permutationOfArr1(permutation, elements, position);

            permutation.remove(permutation.size() - 1);
            position[i] = false;
        }
    }
}
