package oopsandds.day8.practice;

class Geometry {
    public static double calculateCartesianLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}

public class LineComparisonProblemUC1 {
    public static void main(String[] args) {
        System.out.println("Displaying Welcome to Line Comparison Computation");

        double length = Geometry.calculateCartesianLength(2, 5, 7, 6);
        System.out.println("Length of the Cartesian: " + length);
    }
}
