package constructor.day6.practice;

public class ByteProgram {
    public static String toBinary(int n) {

        String binary = "";
        for (int i = 30; i >= 0; i--) {
            int power = 1 << i;

            if (n >= power) {
                binary += "1";
                n = n - power;
            } else {
                binary += "0";
            }
        }

        return binary;
    }

    public static void main(String[] args) {
        int number = 106;
        System.out.println(toBinary(number));
    }
}
