import java.util.Arrays;

public class Board {
    public static final int NUM_ROW = 3;
    public static final int NUM_COLS = 3;
    public static final String EMPTY = " ";
    private String[][] board;

    public Board() {
        board = new String[NUM_ROW][NUM_COLS];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    @Override
    public String toString() {
        String s = " ";
        System.out.print(" ");
        for (int row = 1; row <= board[0].length; row++) {
            s += row + " ";
        }
        s += "\n";
        for (int row = 0; row < board.length; row++) {
            s += (row + 1) + " ";
            for (int col = 0; col < board[0].length; col++) {
                s += board[row][col] + " ";
            }
            s += "\n";
        }
        return s;
    }

    public boolean shoot(int row, int col, Player player) {
        if (row < 0 || row >= NUM_ROW || col < 0 || col >= NUM_COLS) {
            System.out.println("Wrong ROW or COL");
            return false;
        }
        String symbol = player.getSymbol();
        if (board[row][col] == EMPTY) {
            board[row][col] = symbol;
            return true;
        } else {
            System.out.println("Position already in use");
            return false;
        }

    }

    public boolean wins() {
        for (int row = 0; row < board.length; row++) {
            String symbol = board[row][0];
            if (symbol != EMPTY) {
                int cont = 1;
                for (int col = 1; col < board[0].length; col++) {
                    if (board[row][col] == symbol) {
                        cont++;
                    }
                }
                if (cont == NUM_COLS) {
                    return true;
                }
            }

        }

        for (int col = 0; col < board[0].length; col++) {
            String symbol = board[0][col];
            if (symbol != EMPTY) {
                int cont = 1;
                for (int row = 1; row < board.length; row++) {
                    if (board[row][col] == symbol) {
                        cont++;
                    }
                }
                if (cont == NUM_ROW) {
                    return true;
                }
            }

        }

        //CHECK DIAGONAL 1

        String symbol = board[0][0];
        if (symbol != EMPTY) {
            int cont = 1;
            for (int i = 1; i < board.length; i++) {
                if (board[i][i] == symbol) {
                    cont++;
                }
            }
            if (cont == NUM_COLS) {
                return true;
            }
        }

        //CHECK DIAGONAL 2

        symbol = board[0][NUM_COLS - 1];
        if (symbol != EMPTY) {
            int cont = 1;
            int row = 1;
            for (int i = NUM_COLS - 2; i >= 0; i--) {
                if (board[row][i] == symbol) {
                    cont++;
                    row++;
                }
            }
            if (cont == NUM_ROW) {
                return true;
            }
        }
        return false;
    }

    /*public boolean checkDraw(){

    }*/
}
