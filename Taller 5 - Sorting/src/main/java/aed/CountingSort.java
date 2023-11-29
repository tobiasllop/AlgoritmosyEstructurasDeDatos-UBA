package aed;
public class CountingSort {
    public static void sort(Fragment[] arr) {
        int maxId = findMaxId(arr);

        countingSort(arr, maxId);
    }

    private static int findMaxId(Fragment[] arr) {
        int maxId = Integer.MIN_VALUE;
        for (Fragment fragment : arr) {
            maxId = Math.max(maxId, fragment._id);
        }
        return maxId;
    }

    private static void countingSort(Fragment[] arr, int maxId) {
        int[] count = new int[maxId + 1];
        Fragment[] output = new Fragment[arr.length];

        // Contar la frecuencia de cada _id
        for (Fragment fragment : arr) {
            count[fragment._id]++;
        }

        // Actualizar el conteo para que cada posición contenga la posición final del _id correspondiente
        for (int i = 1; i <= maxId; i++) {
            count[i] += count[i - 1];
        }

        // Construir el array ordenado
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]._id] - 1] = arr[i];
            count[arr[i]._id]--;
        }

        // Copiar el array ordenado de nuevo a arr
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
