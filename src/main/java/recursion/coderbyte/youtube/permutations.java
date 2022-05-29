package recursion.coderbyte.youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * [[a, b, c], 
 *  [b, a, c], 
 *  [b, c, a], 
 *  [a, c, b], 
 *  [c, a, b], 
 *  [c, b, a]]
 */

public class permutations {
    
    public static void main(String[] args) {
        System.out.println(permutaion(Arrays.asList("a", "b", "c")));
        System.out.println(permutaion(Arrays.asList("a", "b", "c", "d")));
    }

    public static List<List<String>> permutaion(List<String> elements) {
        if(elements.size() == 0) return new ArrayList<>(new ArrayList<>());
        String firstElement = elements.get(0);
        List<String> restOfString = elements.subList(1, elements.size());

        List<List<String>> permsWithoutFirst = permutaion(restOfString);

        if(permsWithoutFirst.size() == 0) {
            List<String> temp = new ArrayList<String>();
            temp.add(firstElement);
            permsWithoutFirst.add(temp);
            return permsWithoutFirst;
        }

        List<List<String>> allPermutation = new ArrayList<>();

        permsWithoutFirst.forEach( perm -> {
            for(int i=0; i <= perm.size(); i++) {
                List<String> temp = new ArrayList<>(perm.size()+1);
                temp.addAll(perm.subList(0, i));
                temp.add(firstElement);
                temp.addAll(perm.subList(i, perm.size()));

                allPermutation.add(temp);
            }
        });

        return allPermutation;
    }
}
