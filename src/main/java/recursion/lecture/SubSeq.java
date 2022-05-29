package recursion.lecture;

import java.util.ArrayList;
import java.util.List;

public class SubSeq {
    public static void main(String[] args) {
        System.out.println(subsequence("", "abc"));
    }

    public static void subseq(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subseq(p+ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    public static List<String> subsequence(String p, String up) {
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        List<String> left = subsequence(p+ch, up.substring(1));
        List<String> right = subsequence(p, up.substring(1));
        List<String> allComb = new ArrayList<>();
        allComb.addAll(left);
        allComb.addAll(right);

        return allComb;
        
        
    }
}
