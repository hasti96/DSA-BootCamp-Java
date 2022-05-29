package workAtTech.backtracking.medium;

import java.util.*;

public class StringPermutation {
    public static void main(String[] args) {
        // System.out.println(permutation("abc"));
        // List<String> output = permutation("123");
        // output.sort(Comparator.naturalOrder());
        // System.out.println(output);
    }

    public static List<String> permutation(String input) {
        List<String> allpermutation = new ArrayList<>();

        if(input.length() == 1) {
            allpermutation.add(input);
            return allpermutation;
        }
		
		String firstElement = input.substring(0, 1); 
		List<String> list = permutation(input.substring(1));
        
        list.forEach(e -> {
            for(int i=0; i <= e.length(); i++) {
                String temp = e.substring(0, i) + firstElement + e.substring(i, e.length());
                allpermutation.add(temp);
            }
        });        

        return allpermutation;
    }

}
