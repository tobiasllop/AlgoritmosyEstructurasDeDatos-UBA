package aed;

public class IPv4Sorter {

    public static void mergeSortIPv4(IPv4Address[] ipv4Addresses) {
        if (ipv4Addresses == null || ipv4Addresses.length <= 1) {
            return;
        }

        int n = ipv4Addresses.length;
        IPv4Address[] tempArray = new IPv4Address[n];

        mergeSortHelper(ipv4Addresses, tempArray, 0, n - 1);
    }

    private static void mergeSortHelper(IPv4Address[] ipv4Addresses, IPv4Address[] tempArray, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSortHelper(ipv4Addresses, tempArray, left, mid);
            mergeSortHelper(ipv4Addresses, tempArray, mid + 1, right);

            merge(ipv4Addresses, tempArray, left, mid, right);
        }
    }

    private static void merge(IPv4Address[] ipv4Addresses, IPv4Address[] tempArray, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tempArray[i] = ipv4Addresses[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (compareByOctet(tempArray[i], tempArray[j], k % 4) <= 0) {
                ipv4Addresses[k++] = tempArray[i++];
            } else {
                ipv4Addresses[k++] = tempArray[j++];
            }
        }

        while (i <= mid) {
            ipv4Addresses[k++] = tempArray[i++];
        }
    }

    private static int compareByOctet(IPv4Address a, IPv4Address b, int octetIndex) {
        return Integer.compare(a.getOctet(octetIndex), b.getOctet(octetIndex));
    }
}