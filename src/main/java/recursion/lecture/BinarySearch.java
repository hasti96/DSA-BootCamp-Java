package recursion.lecture;

public class BinarySearch {
    
    public static void main(String[] argv) {
        int[] arr = {45, 50, 55, 63, 74, 85};

        System.out.println(binarySearch(85, arr, 0, 6));
    }

    public static int binarySearch(int num, int[] arr, int left, int right) {

        int mid = left +  ((right - left) / 2);

        if(arr[mid] == num) {
            return mid;
        } else if (num < arr[mid]) {
            right = mid;
        } else {
            left = mid;
        }

        return binarySearch(num, arr, left, right);
    }
}
