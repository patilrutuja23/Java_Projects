class SudokuSol {
    // Check if it's safe to place the number in the cell
    public static boolean isSafe(char[][] board, int row, int col, int num) 
    {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char) (num + '0')) 
            {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == (char) (num + '0')) 
            {
                return false;
            }
        }

        int srow = (row / 3) * 3;
        int scol = (col / 3) * 3;
        for (int i = srow; i < srow + 3; i++) 
        {
            for (int j = scol; j < scol + 3; j++) 
            {
                if (board[i][j] == (char) (num + '0')) 
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean helper(char[][] board, int row, int col) 
    {
        if (row == 9) 
        {
            return true; 
        }

        int newRow = row;
        int newCol = col + 1;
        if (newCol == 9) 
        {
            newRow++;
            newCol = 0;
        }

        if (board[row][col] != '.') 
        {
            return helper(board, newRow, newCol);
        }

        for (int num = 1; num <= 9; num++) 
        {
            if (isSafe(board, row, col, num)) 
            {
                board[row][col] = (char) (num + '0');
                if (helper(board, newRow, newCol)) 
                {
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false; 
    }

    public static void printBoard(char[][] board) 
    {
        for (int row = 0; row < 9; row++) 
        {
            for (int col = 0; col < 9; col++) 
            {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void sudokuSolver(char[][] board) 
    {
        if (helper(board, 0, 0)) 
        {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }
}

public class Sudoku {
    public static void main(String[] args) 
    {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        SudokuSol.sudokuSolver(board);
    }
}
