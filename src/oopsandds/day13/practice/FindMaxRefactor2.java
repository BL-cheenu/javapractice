package oopsandds.day13.practice;

public class FindMaxRefactor2<T extends Comparable<T>> {
    T a;
    T b;
    T c;

    public FindMaxRefactor2(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static <T extends Comparable<T>> T findMaxRefactor2(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    public T testMaximum() {
        return FindMaxRefactor2.findMaxRefactor2(a, b, c);
    }

    public static void main(String[] args) {
        FindMaxRefactor2<Integer> intMax = new FindMaxRefactor2<>(10, 20, 30);
        System.out.println("Integer Max: " + intMax.testMaximum());

        FindMaxRefactor2<Float> floatMax = new FindMaxRefactor2<>(10.5f, 5.5f, 20.5f);
        System.out.println("Float Max: " + floatMax.testMaximum());

        FindMaxRefactor2<String> stringMax = new FindMaxRefactor2<>("abc", "ab", "a");
        System.out.println("String Max: " + stringMax.testMaximum());

    }
}
