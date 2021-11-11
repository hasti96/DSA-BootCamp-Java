package array.medium;


/**
 * Q1. https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class FirstAndLastPositionOfElementOfArray {

    public static void main(String[] args) {
        int[] input = new int[] {0,1,2,3,4,5,6,7,8,9,10};
        int[] ans = searchRange(input, 6);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    public static  int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};

        ans[0] = binarySearch(nums, target, true);
        if(ans[0] != -1) {
            ans[1] = binarySearch(nums, target, false);
        }
        return ans;
    }

    public static int binarySearch(int[] input, int target, boolean startIndex) {
        int start = 0;
        int end = input.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (input[mid] == target) {
                ans = mid;
                if(startIndex) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }

            } else if (input[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static int binarySearch(int[] input, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start / 2);

            if (input[mid] == target) {
                return mid;
            } else if (input[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
