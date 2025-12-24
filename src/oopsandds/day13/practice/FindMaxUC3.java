package oopsandds.day13.practice;

public class FindMaxUC3 {
    public static <T extends Comparable<T>> T findMaxUc3(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        String result1 = findMaxUc3("abc", "ab", "a");
        System.out.println("Test Case 1 (Max at 1st): " + result1);

        String result2 = findMaxUc3("a", "abc", "ab");
        System.out.println("Test Case 2 (Max at 2st): " + result2);

        String result3 = findMaxUc3("a", "ab", "abc");
        System.out.println("Test Case 3 (Max at 3st): " + result3);
    }
}
