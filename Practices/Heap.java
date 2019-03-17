class Heap {
    private int HEAPSIZE = 0; //pointer to the end, not actual size of arr
    private int[] arr;

    /*
    public Heap() {
        this.arr = new int[] {-999, 8, 7, 3, 2, 1, 2, 0, 0, 0, 0, 0};
    }
    */

    public Heap(int size) {
        this.arr = new int[size*2];
    }

    private int left(int parent) {
        return parent*2;
    }

    private int right(int parent) {
        return parent*2+1;
    }

    private int parent(int child) {
        return child/2;
    }

    private void swap(int index1, int index2) {
        int temp = this.arr[index1];
        this.arr[index1] = this.arr[index2];
        this.arr[index2] = temp;
    }

    private void bubbleUp(int end) {
        int val = this.arr[end];
        while (end > 1 && val > this.arr[parent(end)]) {
            swap(end, parent(end));
            end = parent(end);
            val = this.arr[end];
        }
    }

    public void insert(int val) {
        HEAPSIZE++;
        this.arr[HEAPSIZE] = val;
        bubbleUp(HEAPSIZE);
    }

    public int extractMax() {
        int maxV = this.arr[1];
        this.arr[1] = this.arr[HEAPSIZE];
        HEAPSIZE--;
        bubbleDown(1);
        return maxV;
    }

    private void bubbleDown(int newRoot) {
        while (newRoot <= HEAPSIZE) {
            int maxV = this.arr[newRoot]; //local variable; does not affect maxV in the function that calls it
            int max_id = newRoot;
            if (left(newRoot) <= HEAPSIZE && maxV < this.arr[left(newRoot)]) {
                maxV = this.arr[left(newRoot)];
                max_id = left(newRoot);
            }
            if (right(newRoot) <= HEAPSIZE && maxV < this.arr[right(newRoot)]) {
                maxV = this.arr[right(newRoot)];
                max_id = right(newRoot);
            }
            if (max_id == newRoot) {
                break;
            } else {
                swap(newRoot, max_id);
                newRoot = max_id;
            }
        }
    }

    public String toString() {
        String string = "";
        for (int i = 1; i <= HEAPSIZE; i++) {
            string += this.arr[i] + " ";
        }
        return string;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(3);
        heap.insert(8);

        heap.insert(2);
        heap.insert(8);

        heap.insert(5);
        heap.insert(0);

        heap.insert(2);
        heap.insert(1);

        heap.insert(3);
        heap.insert(3);

        System.out.println(heap.toString());

    }
}










