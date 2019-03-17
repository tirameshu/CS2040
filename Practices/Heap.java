class Heap {
    private int HEAPSIZE = 7;
    private int[] arr;

    public Heap() {
        this.arr = new int[] {-999, 8, 7, 3, 2, 1, 2, 0};
    }

    public Heap(int size) {
        this.HEAPSIZE = size;
        this.arr = new int[HEAPSIZE+1];
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

    public static void main(String[] args) {
        Heap heap = new Heap();

        System.out.println(heap.extractMax());

    }
}










