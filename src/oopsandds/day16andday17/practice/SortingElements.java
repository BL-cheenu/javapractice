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
        }
    }

    private static void mergeSorting(int[] array, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSorting(array, l, mid);
            mergeSorting(array, mid + 1, r);
            merge(array, l, mid, r);
        }
    }

    private static void merge(int[] array, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] lArray = new int[n1];
        int[] rArray = new int[n2];

        for (int x = 0; x < n1; x++)
            lArray[x] = array[l + x];

        for (int x = 0; x < n2; x++)
            rArray[x] = array[mid + 1 + x];

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (lArray[i] <= rArray[j]) {
                array[k] = lArray[i];
                i++;
            } else {
                array[k] = rArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = lArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 1, 8, 5};
        int[] array1 = {2, 4, 3, 1, 8, 5};
        int size = array.length;

        System.out.println("Sorting the elements using bubble: ");
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

        System.out.println();
        System.out.println("Sorting the elements using merge: ");
        System.out.println("before sorting");
        for (int num : array1) {
            System.out.print(num + " ");
        }

        mergeSorting(array1, 0, array1.length - 1);
        System.out.println();
        System.out.println("after sorting");
        for (int num : array1) {
            System.out.print(num + " ");
        }
    }


}
