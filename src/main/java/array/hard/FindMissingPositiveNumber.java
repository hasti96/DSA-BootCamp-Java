package array.hard;

/**
 * Q1. https://leetcode.com/problems/first-missing-positive/
 */
public class FindMissingPositiveNumber {

    public static void main(String[] args) {
        int[] nums = {-1,-9,-7,1,4,3};
        firstMissingPositive(nums);
    }

    // we put every number at it's position i-1 (minus 1 because we don't need to wast position 0)
    //so num[i-1]=i
    // all those number <=0 or >n, just ignore them
    // and then we go over the array to find the smallest one nums[i-1]!=i, which means we did not find number i, that is the missing number
    // or the worst case, we find every number,than all the numbers all 1~n, so n+1 is the missing one
    public static int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;) {
            // any number too big or too small should be ignored
            // and those who has been standing in the right position, just leave them alone
            if(nums[i]>n || nums[i]<=0 ||nums[i]==i+1||nums[i]==nums[nums[i]-1]) {
                i++;
            } else{
                // if the good number is mis-located, correct it
                // tricky, don't increase index i, we might need to fix the new number t
                int k=nums[i];
                int t=nums[k-1];
                nums[k-1]=k;
                nums[i]=t;
            }
        }
        for(int i=0;i<n;i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }
        return n+1;
    }
}