package aed;

public class Heap<T extends Comparable<T>> {
    private T[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int size) {
        this.maxSize = size;
        this.currentSize = 0;
        this.heapArray = (T[]) new Comparable[size];
    }

    public void insert(T item) {
        if (currentSize < maxSize) {
            heapArray[currentSize] = item;
            trickleUp(currentSize);
            currentSize++;
        } else {
            System.out.println("Heap is full, cannot insert more items.");
        }
    }

    public T extractMax() {
        T root = heapArray[0];
        heapArray[0] = heapArray[currentSize - 1];
        currentSize--;
        trickleDown(0);
        return root;
    }

    public int size() {
        return currentSize;
    }

    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        T bottom = heapArray[index];

        while (index > 0 && heapArray[parent].compareTo(bottom) < 0) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }

        heapArray[index] = bottom;
    }

    private void trickleDown(int index) {
        int largerChild;
        T top = heapArray[index];

        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].compareTo(heapArray[rightChild]) < 0) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (top.compareTo(heapArray[largerChild]) >= 0) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }

        heapArray[index] = top;
    }
}
