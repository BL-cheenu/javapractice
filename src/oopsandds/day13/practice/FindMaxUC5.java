package oopsandds.day13.practice;

import java.util.Arrays;
import java.util.Optional;

public class FindMaxUC5 {
    public static <T extends Comparable<T>> Optional<T> findMaxUc4(T... values) {
        if (values == null || values.length == 0) {
            return Optional.empty();
        }
        Arrays.sort(values);
        T max = values[values.length - 1];
        printMax(max);
        return Optional.of(values[values.length - 1]);
    }

    private static <T extends Comparable<T>> void printMax(T max) {
        System.out.println(max);
    }

    public static void main(String[] args) {
        Optional<Integer> intMax = findMaxUc4(10, 20, 30, 40, 50);
        System.out.println("Integer Max: " + intMax.orElse(null));

        Optional<Float> floatMax = findMaxUc4(10.5f, 5.5f, 20.5f, 1.5f);
        System.out.println("Float Max: " + floatMax.orElse(null));

        Optional<String> stringMax = findMaxUc4("abc", "ab", "a", "abcd");
        System.out.println("String Max: " + stringMax.orElse(null));
    }
}
