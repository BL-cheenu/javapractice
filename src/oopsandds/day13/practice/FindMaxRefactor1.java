package oopsandds.day13.practice;

public class FindMaxRefactor1 {
    public static <T extends Comparable<T>> T FindMaxRefactor1(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        Integer result1 = FindMaxRefactor1(30, 20, 10);
        System.out.println("Test Case 1 (Max at 1st): " + result1);

        Integer result2 = FindMaxRefactor1(20, 50, 10);
        System.out.println("Test Case 2 (Max at 2st): " + result2);

        Integer result3 = FindMaxRefactor1(20, 10, 100);
        System.out.println("Test Case 3 (Max at 3st): " + result3);

        Float result4 = FindMaxRefactor1(30.0f, 20.0f, 10.0f);
        System.out.println("Test Case 1 (Max at 1st): " + result4);

        Float result5 = FindMaxRefactor1(200.0f, 500.0f, 100.0f);
        System.out.println("Test Case 2 (Max at 2st): " + result5);

        Float result6 = FindMaxRefactor1(50.0f, 100.0f, 300.0f);
        System.out.println("Test Case 3 (Max at 3st): " + result6);

        String result7 = FindMaxRefactor1("abc", "ab", "a");
        System.out.println("Test Case 1 (Max at 1st): " + result7);

        String result8 = FindMaxRefactor1("a", "abc", "ab");
        System.out.println("Test Case 2 (Max at 2st): " + result8);

        String result9 = FindMaxRefactor1("a", "ab", "abc");
        System.out.println("Test Case 3 (Max at 3st): " + result9);
    }
}
