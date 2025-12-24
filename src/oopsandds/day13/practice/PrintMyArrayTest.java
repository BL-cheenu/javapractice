package oopsandds.day13.practice;

public class PrintMyArrayTest<X, Y, Z> {
    X[] myXArray;
    Y[] myYArray;
    Z[] myZArray;

    public PrintMyArrayTest(X[] myXArray, Y[] myYArray, Z[] myZArray) {
        this.myXArray = myXArray;
        this.myYArray = myYArray;
        this.myZArray = myZArray;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        Double[] b = {1.1, 2.2, 3.3};
        Character[] c = {'a', 'b'};

        new PrintMyArrayTest<Integer, Double, Character>(a, b, c).toPrint();
    }

    private void toPrint() {
        toPrintArray(myXArray);
        toPrintArray(myYArray);
        toPrintArray(myZArray);
    }

    private <T> void toPrintArray(T[] arraysValue) {
        for (T t : arraysValue) {
            System.out.println(t);
        }
    }
}
