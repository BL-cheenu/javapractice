package constructor.day6.practice;

public class TemperatureConversion {

    public static void temperatureConversion(double temperature, char ch) {
        if (ch == 'C' || ch == 'c') {
            double celsius = (temperature - 32) / 1.8;
            System.out.println("celsius: " + celsius);
        } else if (ch == 'F' || ch == 'f') {
            double fahrenheit = (temperature * 1.8) + 32;
            System.out.println("fahrenheit: " + fahrenheit);
        } else {
            System.out.println("Invalid unit! Use C or F");
        }
    }

    public static void main(String[] args) {
        temperatureConversion(100, 'C');
        temperatureConversion(212, 'F');

    }
}
