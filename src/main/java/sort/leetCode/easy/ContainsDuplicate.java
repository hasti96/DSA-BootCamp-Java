package sort.leetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> ans = new HashSet<>();

        for(int num: nums) {
            if(ans.contains(num)) {
                return true;
            } else {
                ans.add(num);
            }
        }

        return false;
    }
}
