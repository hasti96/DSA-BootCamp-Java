package array.medium;

/**
 *  Q.04 https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        print2dArr(input);
        setZeroes(input);
        print2dArr(input);
    }

    /**
     * Approach : In-Place Hashing.
     *
     *  Steps:
     *      1. Initialize firstRow and firstCol to false. These two variables will store the status of the first row and first column.
     *      2. Now use the first row and first column as your hash which stores the status of that row and column.
     *      3. Now iterate over the matrix and for every A[i][j] == 0, set A[i][0] = 0 and col[0][j] = 0.
     *      4. Now update the values of the matrix except first row and first column to 0 if A[i][0] = true or A[0][i] = true for A[i][j].
     *      5. Now update the values of the first row and first column.
     *
     *  Complexity:
     *      Time Complexity: Checking the first row and first column + Traversing and updating the matrix + Updating first row and first column.
     *      = O(M) + O(N) + O(M*N) + O(M) + O(N)
     *      = O(M*N)
     *
     *  Space Complexity: O(1)
     */
    public static void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i < n; i++) {
            if(matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        for(int i=0; i < m; i++) {
            if(matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRow) {
            for(int i=0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if(firstCol) {
            for(int i=0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    /**
     * Approach :Using Hash Table
     *
     *    1. Create 2 Hash Tables row and col respectively of size M and N.
     *    2. Now initialize all the values of row[] and col[] to false.
     *    3. Now iterate over the matrix and for every A[i][j] == 0, set row[i] = true and col[j] = true.
     *    4. After completion of step 3, again iterate through matrix A and for any A[i][j], if row[i] or col[j] is true then update A[i][j] to 0.
     *
     *    Complexity Analysis :
     *        Time Complexity: Creating and filling values in 2 Hash Tables + Traversing the matrix + Updating the matrix
     *        = O(N+M) + O(N*M) + O(N*M)
     *        = O(N*M)
     *
     *    Space Complexity: O(M + N), for storing hash tables.
     */
    public static void setZeroesUsingHashTable(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

       boolean[] rows = new boolean[m];
       boolean[] col = new boolean[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    if(!rows[i]) {
                        rows[i] = true;
                    }

                    if (!col[j]) {
                        col[j] = true;
                    }
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rows[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void print2dArr(int[][] inputs) {
        System.out.println("==========================");
        int m = inputs.length;
        int n = inputs[1].length;

        for(int i=0; i<m; i++) {
            System.out.print("[");
            for(int j=0; j<n; j++) {
                System.out.print(inputs[i][j] + " ");
            }
            System.out.println("]");
        }
        System.out.println("==========================");
    }
}
