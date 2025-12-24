package oopsandds.day13.practice;

public class FindMaxUC2 {
    public static <T extends Comparable<T>> T findMaxUC2(T a, T b, T c) {
        T maxFloat = a;

        if (b.compareTo(maxFloat) > 0) {
            maxFloat = b;
        }
        if (c.compareTo(maxFloat) > 0) {
            maxFloat = c;
        }
        return maxFloat;
    }

    public static void main(String[] args) {
        Float result1 = findMaxUC2(30.0f, 20.0f, 10.0f);
        System.out.println("Test Case 1 (Max at 1st): " + result1);

        Float result2 = findMaxUC2(200.0f, 500.0f, 100.0f);
        System.out.println("Test Case 2 (Max at 2st): " + result2);

        Float result3 = findMaxUC2(50.0f, 100.0f, 300.0f);
        System.out.println("Test Case 3 (Max at 3st): " + result3);
    }
}
