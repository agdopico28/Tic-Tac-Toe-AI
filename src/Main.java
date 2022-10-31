import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Player p1, p2, currentPlayer;
        Board board = new Board();
        boolean gameOver = false;
        p1 = getPlayerFromKeyboard();
        p2 = getPlayerFromKeyboard();
        currentPlayer = getRamdomPlayer(p1, p2);
        while (!gameOver) {
            System.out.println(board);
            Shot shot = getShot(currentPlayer);
            if (board.correctShoot(shot, currentPlayer)) {
                if (board.wins()) {
                    System.out.println(board);
                    System.out.println("WINNER:" + currentPlayer.getName());
                    gameOver = true;
                } else {
                    if (board.checkDraw()) {
                        System.out.println(board);
                        System.out.println("IT IS A DRAW");
                        gameOver = true;
                    } else {
                        currentPlayer = changePlayer(p1, p2, currentPlayer);
                    }
                }

            }


        }

    }

    public static Shot getShot(Player currentPlayer) {
        System.out.println(currentPlayer.getName() + "(" + currentPlayer.getSymbol()
                + ")" + " Enter row and col");
        System.out.print("Row: ");
        int row = input.nextInt() - 1;
        System.out.println("Colum: ");
        int col = input.nextInt() - 1;
        return new Shot(row, col);
    }


    private static Player changePlayer(Player p1, Player p2, Player currentPlayer) {
        return currentPlayer == p1 ? p2 : p1;
    }

    private static Player getRamdomPlayer(Player p1, Player p2) {
        int rand = (int) (Math.random() * 2);
        return rand == 0 ? p1 : p2;
        /* if (rand == 0){
            return p1;
        }else{
            return  p2;
        }*/
    }

    private static Player getPlayerFromKeyboard() {
        System.out.println("Enter the number of player" + (Player.getNumPlayers() == 0 ? "1" : "2"));
        /* if (Player.getNumPlayers() == 0){
            System.out.println("Enter the number of player 1");
        }else{
            System.out.println("Enter the number of player 2");
        }*/
        String name = input.next();
        return new Player(name);
    }
}
