package constructor.day6.practice;

public class sqrt {
    public static double sqrt(double c) {
        double epsilon = 1e-15;
        double t = c;

        while (Math.abs(t - c / t) > epsilon * t) {
            t = (t + c / t) / 2;
        }
        return t;
    }

    public static void main(String[] args) {
        double c = 9;
        System.out.println("Square root: " + sqrt(c));
    }
}
