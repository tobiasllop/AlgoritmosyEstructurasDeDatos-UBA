package aed;

public class InsertionSort {
    public static void sort(Fragment[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Fragment key = arr[i];
            int j = i - 1;

            // Mueve los elementos del arreglo que son mayores que key
            // a una posición adelante de su posición actual
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
