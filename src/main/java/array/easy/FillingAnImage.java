package array.easy;

public class FillingAnImage {
    public static void main(String[] args) {

    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int row = image.length;
        int col = image[0].length;

        for(int i = 0; i < row; i++) {
            int start = 0;
            int end = col - 1;

            while (start < end) {
                int temp = image[i][start];
                image[i][start] = image[i][end];
                image[i][end] = temp;

                image[i][start] = 1 - image[i][start];
                image[i][end] = 1 - image[i][end];

                start++;end--;
            }

            if(col % 2 != 0) {
                image[i][start] = 1 - image[i][start];
            }
        }

        return image;
    }
}
