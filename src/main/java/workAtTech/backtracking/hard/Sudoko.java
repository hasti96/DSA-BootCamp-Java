package workAtTech.backtracking.hard;

public class Sudoko {
    public static void main(String[] args) {
        char[][] board = 
        {   {'2', '5', '.', '.', '.', '3', '.', '.', '.' },
            {'.', '.', '.', '.', '.', '.', '2', '7', '.' },
            {'8', '7', '.', '.', '.', '6', '4', '.', '.' },
            {'.', '2', '.', '.', '.', '8', '1', '9', '3' },
            {'.', '1', '5', '.', '4', '.', '8', '.', '.' },
            {'.', '.', '.', '1', '.', '.', '.', '.', '4' },
            {'.', '.', '.', '7', '3', '4', '.', '.', '.' },
            {'.', '.', '.', '6', '.', '.', '.', '.', '9' },
            {'.', '6', '4', '.', '.', '9', '.', '5', '8' } };
        
        printBoard(board);
        System.out.println(isValidSudoku(board));
        System.out.println(solve(board, 0, 0));
        printBoard(board);
    }

    public static boolean solve(char[][] board, int row, int col) {
        if(col == board[0].length) {
            col = 0;
            row++;

            if(row == board.length) {
                return true;
            }
        }

        if(board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        for(int i=1; i < 10; i++) {
            char input = (char) ('0' + i);

            if(checkValue(board, row, col, input)) {
                board[row][col] = input;
                if(solve(board, row, col+1)) {
                    return true;
                }
            }
            
        }

        board[row][col] = '.';
        return false;
    }

    private static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') {
                    if(!checkValue(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean checkValue(char[][] board, int row, int col, char in) {
        for(int i=0; i < board.length; i++) {
            if(col == i) continue;

            if(board[row][i] == in) {
                return false;
            }
        }

        for(int i=0; i < board.length; i++) {

            if(row == i) continue;

            if(board[i][col] == in) {
                return false;
            }
        }

        int left = (col / 3) * 3;
        int right = left + 3;

        int top = (row / 3) * 3;
        int down = top + 3;

        for(int i= top; i < down; i++) {
            for(int j = left; j < right; j++) {
                if(row == i && col == j) continue;

                if(board[i][j] == in) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard(char[][] board) {
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
