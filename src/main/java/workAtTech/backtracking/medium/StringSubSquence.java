package workAtTech.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class StringSubSquence {
    public static void main(String[] args) {
        System.out.println(subseq("", "abc"));
    }

    public static List<String> subseq(String str, String input) {
        if(input.isEmpty()) {
            List<String> temp = new ArrayList<>();
            temp.add(str);
            return temp;
        }

        char ch = input.charAt(0);

        List<String> allSubSeq = new ArrayList<>();
        List<String> left = subseq(str + ch, input.substring(1));
        List<String> right = subseq(str, input.substring(1));

        allSubSeq.addAll(left);allSubSeq.addAll(right);

        return allSubSeq;
    }
}
