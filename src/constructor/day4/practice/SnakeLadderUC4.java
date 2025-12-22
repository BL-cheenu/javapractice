package constructor.day4.practice;

public class SnakeLadderUC4 {

    private static int playerMoved(int option, int position, int dice) {
        switch (option) {
            case 0: // No Play
                break;

            case 1: // Ladder
                position += dice;
                break;

            case 2: // Snake
                position -= dice;
                if (position < 0) {
                    position = 0;
                }
                break;
        }
        return position;
    }

    public static void main(String[] args) {
        int position = 0;

        System.out.println("Snake and Ladder game played");
        System.out.println("Player starting position: " + position);
        while (position < 100) {

            int dice = SnakeLadderUC2.rollDice();
            int option = SnakeLadderUC3.checkOption();

            position = SnakeLadderUC3.playerMoved(option, position, dice);
            System.out.println("Dice: " + dice + " | Option: " + option + " | Position: " + position);
        }

        System.out.println("Player reached 100. Game Over!");
    }
}
