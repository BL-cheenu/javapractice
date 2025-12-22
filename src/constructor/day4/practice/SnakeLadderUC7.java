package constructor.day4.practice;

public class SnakeLadderUC7 {

    static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    static int checkOption() {
        return (int) (Math.random() * 3);
    }

    static int movePlayer(int position, int dice, int option) {

        int newPosition = position;

        switch (option) {
            case 0: // No Play
                break;

            case 1: // Ladder
                newPosition += dice;
                break;

            case 2: // Snake
                newPosition -= dice;
                if (newPosition < 0) {
                    newPosition = 0;
                }
                break;
        }

        if (newPosition < 0) {
            newPosition = 0;
        }

        if (newPosition > 100) {
            return position;
        }

        return newPosition;
    }

    public static void main(String[] args) {

        int player1 = 0;
        int player2 = 0;
        int currentPlayer = 1;

        System.out.println("2 Player Snake and Ladder Game Started");

        while (player1 != 100 && player2 != 100) {

            int dice = rollDice();
            int option = checkOption();

            System.out.println("Player " + currentPlayer + " rolled dice: " + dice + " | Option: " + option);

            if (currentPlayer == 1) {
                player1 = movePlayer(player1, dice, option);
                System.out.println("Player 1 position: " + player1);
            } else {
                player2 = movePlayer(player2, dice, option);
                System.out.println("Player 2 position: " + player2);
            }

            if (option != 1) {
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }
        }
        if (player1 == 100) {
            System.out.println("Player 1 WON the game!");
        } else {
            System.out.println("Player 2 WON the game!");
        }
    }
}
