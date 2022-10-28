import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player p1, p2, currentPlayer;
        Board board = new Board();
        boolean gameOver = false;
        p1 = getPlayerFromKeyboard(input);
        p2 = getPlayerFromKeyboard(input);
        currentPlayer = getRamdomPlayer(p1,p2);
        while (!gameOver){
            System.out.println(board);
            System.out.println(currentPlayer.getName() + "(" + currentPlayer.getSymbol()
                                + ")"+  " Enter row and col");
            System.out.print( "Row: ");
            int row = input.nextInt() - 1;
            System.out.println("Colum: ");
            int col = input.nextInt() - 1;
            if (board.shoot(row,col, currentPlayer)){
                if(board.wins()){
                    System.out.println("WINNER:" + currentPlayer.getName());
                    gameOver = true;
                }else{
                    currentPlayer = changePlayer(p1,p2,currentPlayer);
                }

            }

        }

    }

    private static Player changePlayer(Player p1, Player p2, Player currentPlayer) {
        return currentPlayer == p1 ? p2 : p1;
    }

    private static Player getRamdomPlayer(Player p1, Player p2) {
        int rand = (int)(Math.random() * 2);
        return rand == 0 ? p1 : p2;
        /* if (rand == 0){
            return p1;
        }else{
            return  p2;
        }*/
    }

    private static Player getPlayerFromKeyboard(Scanner input){
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
