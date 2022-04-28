package array.medium;

/**
 * Q-> https://leetcode.com/problems/house-robber/
 */

public class HouseRobber {

    public static void main(String[] args) {

        int[] input = {2,7,9,3,1};
        System.out.println(rob(input));
    }

    public static int rob(int[] nums) {
        boolean isEven = true;
        int even = 0;
        int odd = 0;

        for(int i=0; i < nums.length; i++) {
            if(isEven) {
                even = even + nums[i];
                isEven = false;
            } else {
                odd = odd + nums[i];
                isEven = true;
            }
        }

        return even > odd ? even : odd;
    }

}
