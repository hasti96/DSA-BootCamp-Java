package array.medium;

/**
 * Q-> https://leetcode.com/problems/spiral-matrix-ii
 */

public class SpiralMatrix_II {

    public static void main(String[] args) {
        SetMatrixZeroes.print2dArr(generateMatrix(3));
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;

        int left = 0; int right = n-1;
        int top = 0; int bottom = n-1;

        int d = 0;

        while (left <= right && top <= bottom) {

            if( d == 0 ) { //left to right
                for(int i = left; i <= right; i++, num++) {
                    result[top][i] = num;
                }
                top++; d = 1;
            } else if ( d == 1 ) { // top to down
                for (int i = top; i <= bottom; i++, num++) {
                    result[i][right] = num;
                }
                right--; d = 2;
            } else if( d == 2 ) { //right to left
                for (int i = right; i >= left ; i--, num++) {
                    result[bottom][i] = num;
                }
                bottom--; d = 3;
            } else if( d == 3 ) { // bottom to top
                for (int i = bottom; i >= top ; i--, num++) {
                    result[i][left] = num;
                }
                left++; d = 0;
            }
        }

        return result;
    }
}
