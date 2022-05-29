package workAtTech.backtracking.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        List<String> temp = combinationList("", "8");
        temp.sort(Comparator.naturalOrder());
        System.out.println(temp);
    }

    public static void combination(String down, String input) {
        if (input.isEmpty()) {
            System.out.println(down);
            return;
        }

        int digit = input.charAt(0) - '0';

        int start = (digit - 2) * 3;
        int end = start + 3;

        if(digit == 8 || digit == 9) {
            start++;
        } 

        if(digit == 7 || digit == 9) {
            end++;
        }

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            combination(down + ch, input.substring(1));
        }
    }

    public static List<String> combinationList(String down, String input) {
        if (input.isEmpty()) {
            List<String> temp = new ArrayList<>();
            temp.add(down);
            return temp;
        }

        List<String> allcomb = new ArrayList<>();

        int digit = input.charAt(0) - '0';

        int start = (digit - 2) * 3;
        
        if(digit == 8 || digit == 9) {
            start++;
        } 

        int end = start + 3;

        if(digit == 7 || digit == 9) {
            end++;
        }

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            allcomb.addAll(combinationList(down + ch, input.substring(1)));
        }

        return allcomb;
    }
}
