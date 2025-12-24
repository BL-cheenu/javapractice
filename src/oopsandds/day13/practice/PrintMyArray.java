package oopsandds.day13.practice;

public class PrintMyArray<T> {
    T[] myArray;

    public PrintMyArray(T[] myArray) {
        this.myArray = myArray;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        Double[] b = {1.1, 2.2, 3.3};
        Character[] c = {'a', 'b'};

        new PrintMyArray<Integer>(a).toPrint();
        new PrintMyArray<Double>(b).toPrint();
        new PrintMyArray<Character>(c).toPrint();

        toPrintArray(a);
        toPrintArray(b);
        toPrintArray(c);
    }

    private void toPrint() {
        toPrintArray(myArray);
    }

    private static <T extends Object> void toPrintArray(T[] c) {
        for (T t : c) {
            System.out.println(t + " ");
        }
    }
}
