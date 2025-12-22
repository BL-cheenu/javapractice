package oopsandds.day8.practice;

public class LineComparisonProblemUC2 {
    public static void main(String[] args) {
        System.out.println("Displaying Welcome to Line Comparison Computation");

        Double length1 = Geometry.calculateCartesianLength(2, 5, 7, 6);
        Double length2 = Geometry.calculateCartesianLength(1, 3, 6, 4);

        if (length1.equals(length2)) {
            System.out.println("Both are equal length.");
        } else {
            System.out.println("Both are not equal length.");
        }
    }
}
