package constructor.day4.practice;

public class SnakeLadderUC5 {
    private static int playerMoved(int option, int position, int dice) {
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
        if (newPosition > 100) {
            return position;
        }
        return newPosition;
    }

    public static void main(String[] args) {
        int position = 0;

        System.out.println("Snake and Ladder game played");
        System.out.println("Player starting position: " + position);
        while (position != 100) {

            int dice = SnakeLadderUC2.rollDice();
            int option = SnakeLadderUC3.checkOption();

            position = playerMoved(option, position, dice);
            System.out.println("Dice: " + dice + " | Option: " + option + " | Position: " + position);
        }

        System.out.println("Player reached 100. Game Over!");
    }
}
