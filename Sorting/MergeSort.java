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
            int mid = (start + end) / 2;
            sort(start, mid - 1);
            sort(mid, end);
            merge(start, mid, end);
            //calling sort on the different intervals is just so that the left and right will call merge eventually
            //even when the left and right end up with 1 item, such that sort(...) is invalid, calling merge will still merge the two items.
        }
    }

    public void sort() {
        return sort(0, arr.length - 1);
    }
