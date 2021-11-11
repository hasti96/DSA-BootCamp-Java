package array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Q2. https://leetcode.com/problems/spiral-matrix
 */
public class SpiralMatrixDisplay {

    public static void main(String[] args) {
        int[][] input = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};

        SetMatrixZeroes.print2dArr(input);

        System.out.println(spiralOrder(input));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n-1;
        int top = 0;
        int down = m-1;

        int d = 0;

        while(left <= right && top <= down) {

            if(d==0) //right
            {
                for(int i=left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;d=1;
            }
            else if(d==1) //down
            {
                for(int i=top; i<= down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--; d=2;
            }
            else if(d==2) // left
            {
                for(int i=right; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
                down--;d=3;
            }
            else if(d==3) // top
            {
                for(int i=down; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++; d=0;
            }
        }

        return ans;
    }
}
