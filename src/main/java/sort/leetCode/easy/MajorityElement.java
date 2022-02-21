package sort.leetCode.easy;

/**
 *  Q3. -> https://leetcode.com/problems/majority-element
 */

public class MajorityElement {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer Value = null;

        for(int num: nums) {
            if(count == 0) {
                Value = num;
            }
            count += Value == num ? 1 : -1;
        }

        return Value;
    }
}
