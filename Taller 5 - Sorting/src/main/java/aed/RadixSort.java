package aed;
public class RadixSort {
    public static void sort(Fragment[] arr) {
        int maxId = findMaxId(arr);
        countingSort(arr, maxId);
    }

    private static void countingSort(Fragment[] arr, int maxId) {
        int[] count = new int[maxId + 1];
        Fragment[] output = new Fragment[arr.length];

        for (Fragment fragment : arr) {
            count[fragment._id]++;
        }

        for (int i = 1; i <= maxId; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]._id] - 1] = arr[i];
            count[arr[i]._id]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    private static int findMaxId(Fragment[] arr) {
        int maxId = arr[0]._id;
        for (Fragment fragment : arr) {
            maxId = Math.max(maxId, fragment._id);
        }
        return maxId;
    }
}


