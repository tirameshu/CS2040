import java.util.*;

class MergeSort {
    private int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    private void sort(int start, int end) {
        //if there is more than 2 elements, break into left and right and merge
        //halve the array
        //left starts at "start", right starts at "mid"
        if (start < end) {
            //there is more than 1 item, so can split into two non-empty arr
            //let merge handle the situation where there is only one item in each arr
            int mid = (start + end) / 2 + 1;
            sort(start, mid - 1);
            sort(mid, end);
            merge(start, mid, end);
            //calling sort on the different intervals is just so that the left and right will call merge eventually
            //even if after splitting, the left and right end up with 1 item, such that sort(...) is invalid, calling merge over the current interval will still merge the two items.
        }
    }

    private void merge(int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int left = start, right = mid, it = 0;

        while (left < mid && right <= end) {
            //this decides whether it is in place or not
            if (this.arr[left] <= this.arr[right]) {
                temp[it++] = this.arr[left++];
            } else {
                temp[it++] = this.arr[right++];
            }
        }

        //only one of them will be invoked
        while (left < mid) {
            temp[it++] = this.arr[left++];
        }

        while (right <= end) {
            temp[it++] = this.arr[right++];
        }

        for (int k = 0; k < temp.length; k++) {
            arr[start + k] = temp[k];
        }
    }

    public String toString() {
        return Arrays.toString(this.arr);
    }

    public void sort() {
        sort(0, arr.length - 1);
    }
}
