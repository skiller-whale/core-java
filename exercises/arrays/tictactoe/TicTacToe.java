public class TicTacToe {
    public static void main(String[] args) {
        // TODO: Initialize the board with some values (e.g., 'X', 'O', and ' ')
        char[][] board;

        char winner = checkWinner(board);
        if (winner != ' ') {
            System.out.println("The winner is: " + winner);
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static char checkWinner(char[][] board) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0]; // Return the winner ('X' or 'O')
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j]; // Return the winner ('X' or 'O')
            }
        }

        // Check diagonals
        // TODO

        return ' '; // No winner
    }
}
