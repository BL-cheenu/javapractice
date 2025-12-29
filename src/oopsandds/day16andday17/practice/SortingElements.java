package oopsandds.day16andday17.practice;

public class SortingElements {
    private static void bubbleSorting(int size, int[] array) {
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println();
            for (int num : array) {
                System.out.print(num + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 1, 8, 5};
        int size = array.length;

        System.out.println("before sorting");
        for (int num : array) {
            System.out.print(num + " ");
        }

        bubbleSorting(size, array);
        System.out.println();
        System.out.println("after sorting");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
