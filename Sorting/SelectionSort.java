import java.util.Arrays;

class SelectionSort {
    private int[] arr;

    public SelectionSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int largest = this.arr[0];
        int indexOfLargest = 0;
        int end = this.arr.length - 1;
        for (int i = 0; i < this.arr.length - 1; i++) {
            for (int j = 0; j <= end; j++) {
                if (this.arr[j] > largest) {
                    largest = this.arr[j];
                    indexOfLargest = j;
                }
            }
            //swap largst with last e
            this.arr[indexOfLargest] = this.arr[end];
            this.arr[end] = largest;
            end--;
            largest = this.arr[0];
        }
    }

    public String toString() {
        return Arrays.toString(this.arr);
    }
}
