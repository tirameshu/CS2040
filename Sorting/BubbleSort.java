import java.util.*;

class BubbleSort {
    private int[] arr;

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (this.arr[i] > this.arr[i+1]) {
                int temp = this.arr[i];
                this.arr[i] = this.arr[i+1];
                this.arr[i+1] = temp;
                isSorted = false;
            }
        }

        if (!isSorted) {
            sort();
        }
    }

    public String toString() {
        return Arrays.toString(this.arr);
    }
}
