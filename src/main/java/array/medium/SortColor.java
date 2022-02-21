package array.medium;

public class SortColor {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;

        for(int i=0; i < nums.length; i++) {
            if (nums[i] == 0) count_0++;
            else if(nums[i] == 1) count_1++;
            else count_2++;
        }

        int j =0;
        while (count_0 >0) {
            nums[j] = 0;
            count_0--;j++;
        }

        while (count_1 >0) {
            nums[j] = 1;
            count_1--;j++;
        }

        while (count_2 >0) {
            nums[j] = 2;
            count_2--;j++;
        }
    }
}
