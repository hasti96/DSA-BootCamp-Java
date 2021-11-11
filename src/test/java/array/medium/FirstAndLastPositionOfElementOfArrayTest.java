package array.medium;

import org.junit.Assert;
import org.junit.Test;

public class FirstAndLastPositionOfElementOfArrayTest {

    @Test
    public void binarySearch() {
        int[] input = {0,1,2,3,4,5,6,7,8,9,10};
        Assert.assertEquals(6, FirstAndLastPositionOfElementOfArray.binarySearch(input, 0, input.length-1, 6));
    }

    @Test
    public void searchRange() {
        int[] input = new int[] {0,1,2,3,4,5,6,6,6,6,7,8,9,10};
        int[] ans = FirstAndLastPositionOfElementOfArray.searchRange(input, 6);

        Assert.assertEquals(6, ans[0]);
        Assert.assertEquals(9, ans[1]);

        input = new int[] {0};
        ans = FirstAndLastPositionOfElementOfArray.searchRange(input, 0);

        Assert.assertEquals(0, ans[0]);
        Assert.assertEquals(0, ans[1]);
    }
}
