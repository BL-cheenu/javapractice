package constructor.day3.practice;

class Geometry {
    int x1;
    int y1;
    int x2;
    int y2;

    public Geometry(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double calculateCartesianLength() {
        return Math.sqrt((Math.pow(x2 - x1, 2) + (Math.pow(y2 - y1, 2))));
    }

    void compareTwoLines(Double length1, Double length2) {
        if (length1.equals(length2)) {
            System.out.println("Both lines are equal.");
        } else {
            System.out.println("Both lines are not equal.");
        }
    }

    void displayLineComparison(Double length1, Double length2) {
        int result = length1.compareTo(length2);

        if (result == 0) {
            System.out.println("Line 1 is equal to Line 2");
        } else if (result > 0) {
            System.out.println("Line 1 is greater than Line 2");
        } else {
            System.out.println("Line 1 is less than Line 2");
        }
    }
}

public class LineComparison {
    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation");

        Geometry line = new Geometry(1, 2, 4, 6);
        double result = line.calculateCartesianLength();
        System.out.println("calculateCartesianLength: " + result);

        Geometry line1 = new Geometry(1, 2, 4, 6);
        Geometry line2 = new Geometry(0, 0, 3, 4);

        Double length1 = line1.calculateCartesianLength();
        Double length2 = line2.calculateCartesianLength();

        line.compareTwoLines(length1, length2);
        line.displayLineComparison(length1, length2);

    }


}
