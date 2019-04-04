import java.util.*;

// barebones implementation of max heap

public class BinaryHeap {
  private ArrayList<Integer> A;
  private int BinaryHeapSize;

  BinaryHeap() {
    A = new ArrayList<Integer>();
    A.add(0); // dummy
    BinaryHeapSize = 0;
  }

  BinaryHeap(int[] array) {
    CreateHeap(array);
  }

  int parent(int i) { return i>>1; } // shortcut for i/2, round down
  
  int left(int i) { return i<<1; } // shortcut for 2*i
  
  int right(int i) { return (i<<1) + 1; } // shortcut for 2*i + 1
  
  void shiftUp(int i) {
    while (i > 1 && A.get(parent(i)) < A.get(i)) {
      int temp = A.get(i);
      A.set(i, A.get(parent(i)));
      A.set(parent(i), temp);
      i = parent(i);
    }
  }

  void Insert(int key) {
    BinaryHeapSize++;
    if (BinaryHeapSize >= A.size())
      A.add(key);
    else
      A.set(BinaryHeapSize, key);
    shiftUp(BinaryHeapSize);
  }

  void shiftDown(int i) {
    while (i <= BinaryHeapSize) {
      int maxV = A.get(i), max_id = i;

      // compare value of this node with its left subtree, if possible
      if (left(i) <= BinaryHeapSize && maxV < A.get(left(i))) { 
        maxV = A.get(left(i));
        max_id = left(i);
      }
      // now compare with its right subtree, if possible
      if (right(i) <= BinaryHeapSize && maxV < A.get(right(i))) {
        maxV = A.get(right(i)); // can remove this statement since biggest value already found, i.e
                                // maxV no longer needed
        max_id = right(i);
      }
  
      if (max_id != i) {
        int temp = A.get(i);
        A.set(i, A.get(max_id));
        A.set(max_id, temp);
        i = max_id;
      }
      else
        break;
    }
  }
  
  // Question: what happens if heap is empty?
  int ExtractMax() {
  	int maxV = A.get(1);    
      
    A.set(1, A.get(BinaryHeapSize));
    BinaryHeapSize--; // virtual decrease
    shiftDown(1);
    
    return maxV;
  }
  
  void UpdateKey(int i, int j) {
    // implement this function
  } 
  
  void CreateHeapSlow(int[] arr) { // the O(N log N) version, array arr is 0-based
    A = new ArrayList<Integer>();
    A.add(0); // dummy, this BinaryHeap is 1-based
    for (int i = 1; i <= arr.length; i++)
      Insert(arr[i-1]);
  }
  
  void CreateHeap(int[] arr) { // the O(N) version, array arr is 0-based
    BinaryHeapSize = arr.length;
    A = new ArrayList<Integer>();
    A.add(0); // dummy, this BinaryHeap is 1-based
    for (int i = 1; i <= BinaryHeapSize; i++) // copy the content
      A.add(arr[i-1]);
    for (int i = parent(BinaryHeapSize); i >= 1; i--)
      shiftDown(i);
  }

  ArrayList<Integer> HeapSort(int[] arr) { // array arr is 0-based
    CreateHeap(arr);
    int N = arr.length;
    for (int i = 1; i <= N; i++)
      A.set(N-i+1, ExtractMax());
    return A; // ignore the first index 0
  }

  int size() { return BinaryHeapSize; }
  
  boolean isEmpty() { return BinaryHeapSize == 0; }
}
