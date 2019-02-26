import java.util.*;

class RadixSort {
    private int[] arr;
    private ArrayList<Stack<Integer>> groups; //index corresponds to the last digit

    public RadixSort(int[] arr) {
        this.arr = arr;
        this.groups = new ArrayList<>();
    }

    private void populate() {
        for (int j = 0; j < 10; j++) {
            this.groups.add(new Stack<Integer>());
        }
    }

    public void sort() {
        populate();
        for (int num: arr) {
            int digit = num / 1;
            groups.get(digit - 1).push(num);
        }
    }

    public String toString() {
        int index  = 0;
        for (int i = 0; i < groups.size(); i++) {
            Stack<Integer> group = groups.get(i);
            while (!group.empty()) {
                this.arr[index] = group.pop();
                index++;
            }
        }
        return Arrays.toString(this.arr);
    }
}
