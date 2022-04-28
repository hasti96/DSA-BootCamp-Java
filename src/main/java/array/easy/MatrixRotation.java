package array.easy;

/**
 * 23. https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation
 */
public class MatrixRotation {

    public static void main(String[] args) {
        int[][] input = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] target = new int[][] {{7,4,1}, {8,5,2}, {9,6,3}};

        System.out.println(findRotation(input, target));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0; i < 4; i++) {
            rotate90(mat);
            if(check(mat, target)) {
                return true;
            }
        }

        return false;
    }

    public static void rotate90(int[][] input) {
        int m = input.length;
        int n = input[0].length;

        for(int i=0; i < m; i++) {
            for(int j=0; j < i; j++) {
                int temp = input[i][j];
                input[i][j] = input[j][i];
                input[j][i] = temp;
            }
        }

        int a = 0; int b=n-1;
        while(a < b) {
            for(int i=0; i<m; i++) {
                int temp = input[i][a];
                input[i][a] = input[i][b];
                input[i][b] = temp;
            }
            a++;b--;
        }
    }

    public static boolean check(int[][] mat, int[][] target) {
        int m = mat.length;
        int n = mat[0].length;

        for(int i=0; i < m; i++) {
            for(int j=0; j< n; j++) {
                if(mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
