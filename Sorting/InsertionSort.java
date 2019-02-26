import java.util.*;

class InsertionSort {
    private int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        //take the element after the last sorted element
        for (int i = 1; i < arr.length; i++) {
            int next = this.arr[i];
            int index = 0; //if no smaller element exist, next is the smallest
            for (int j = i-1; j >= 0; j--) {
                if (this.arr[j] > next) {
                    this.arr[j+1] = this.arr[j];
                } else {
                    index = j + 1;
                    break;
                }
                this.arr[index] = next;
            }
        }
    }

    public String toString() {
        return Arrays.toString(this.arr);
    }
}
