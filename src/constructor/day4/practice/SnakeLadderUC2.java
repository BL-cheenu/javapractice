package constructor.day4.practice;

public class SnakeLadderUC2 {
    public static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    public static void main(String[] args) {
        int position = 0;

        System.out.println("Snake and Ladder game played");
        int dice = rollDice();

        System.out.println("Player starting position: " + position);
        System.out.println("Dice rolled: " + dice);
    }


}
