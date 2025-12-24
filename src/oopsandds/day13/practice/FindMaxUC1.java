package oopsandds.day13.practice;

public class FindMaxUC1 {

    public static <T extends Comparable> T maxFind(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        Integer result1 = maxFind(30, 20, 10);
        System.out.println("Test Case 1 (Max at 1st): " + result1);

        Integer result2 = maxFind(20, 50, 10);
        System.out.println("Test Case 2 (Max at 2st): " + result2);

        Integer result3 = maxFind(20, 10, 100);
        System.out.println("Test Case 3 (Max at 3st): " + result3);

    }
}
