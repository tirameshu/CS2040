import java.util.*;

class QuickSort {
    private int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int back = 1;
        while (back < arr.length - 1) {
            int pivot = this.arr[0];
            int front = 0;

            if (this.arr[back] > this.arr[front]) {
                back++;
            } else {
                front++;
                int temp = this.arr[front];
                this.arr[front] = this.arr[back];
                this.arr[back] = temp;
                back++;
            }
        }
    }

    public String toString() {
        return Arrays.toString(this.arr);
    }
}
