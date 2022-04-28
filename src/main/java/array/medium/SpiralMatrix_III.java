package array.medium;

/**
 * Q-> https://leetcode.com/problems/spiral-matrix-iii
 */

public class SpiralMatrix_III {

    public static void main(String[] args) {

    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int totalElements = rows*cols;
        int[][] result = new int[totalElements][2];
        int count = 0;
        int d = 0;

        int left = rStart; int right = rStart;
        int top = cStart; int bottom = cStart;

        while ( count < totalElements ) {

            if( d == 0 ) { // left to right
                for(int i=left; i <= right; i++) {
                    if(checkCoordinate(top, i, rows, cols)) {
                        result[count][0] = top;
                        result[count++][1] = i;
                    }
                }
                left--; d=1; right++;

            } else if( d == 1 ) { // top to bottom
                for(int i=top; i <= bottom; i++) {
                    if(checkCoordinate(i, right, rows, cols)) {
                        result[count][0] = i;
                        result[count++][1] = right;
                    }
                }
                top--; d = 2; bottom++;

            } else if( d == 2 ) { // right to left
                for(int i=right; i <= left; i--) {
                    if(checkCoordinate(bottom, i, rows, cols)) {
                        result[count][0] = bottom;
                        result[count++][1] = i;
                    }
                }
                right++; d = 3; left--;

            } else if( d == 3 ) { // bottom to top
                for(int i=bottom; i <= top; i--) {
                    if(checkCoordinate(top, i, rows, cols)) {
                        result[count][0] = i;
                        result[count++][1] = left;
                    }
                }
                bottom++; d = 0; top--;

            }
        }
        return result;
    }

    public static boolean checkCoordinate(int i, int j, int rows, int cols) {
        return i > -1 && i < rows && j > -1 && j < cols;
    }
}