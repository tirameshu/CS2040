import java.util.*;

// barebones implementation of max heap

public class BinaryHeap {
  private ArrayList<Integer> A;
  private int BinaryHeapSize;
  private HashMap<Integer, ArrayList<Integer>> valToIndex;

  BinaryHeap() {
    A = new ArrayList<Integer>();
	valToIndex = new HashMap<>();
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
	  int parent = A.get(parent(i));
      A.set(i, parent);
	  valToIndex.get(parent).remove(Integer.valueOf(parent(i))); // added
	  valToIndex.get(parent).add(i); // added
      A.set(parent(i), temp);
	  valToIndex.get(temp).remove((Integer) i); // added
	  valToIndex.get(temp).add(parent(i)); // added
      i = parent(i);
    }
  }

  void Insert(int key) {
    BinaryHeapSize++;
    if (BinaryHeapSize >= A.size()) {
      A.add(key);
	  ArrayList<Integer> list = valToIndex.getOrDefault(key, new ArrayList<Integer>());
	  list.add(A.size()-1);
	  valToIndex.put(key, list);
	} else {
      A.set(BinaryHeapSize, key);
	  ArrayList<Integer> list = valToIndex.getOrDefault(key, new ArrayList<Integer>());
	  list.add(BinaryHeapSize);
	  valToIndex.put(key, list);
	}
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
		int m = A.get(max_id);
        A.set(i, m);
		valToIndex.get(m).remove((Integer) max_id); // added
		valToIndex.get(m).add(i); // added
        A.set(max_id, temp);
		valToIndex.get(temp).remove((Integer) i); // added
		valToIndex.get(temp).add(max_id); // added
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
	valToIndex.get(maxV).remove((Integer) 1); // added
    BinaryHeapSize--; // virtual decrease
    shiftDown(1);
    
    return maxV;
  }
  
  void UpdateKey(int i, int j) {
    // implement this function
	ArrayList<Integer> indices = valToIndex.get(i);
	int index = indices.get(indices.size()-1); // assummed non-empty
	// System.out.println("I replaced " + i + " at index " + index + " to " + j);
	A.set(index, j); // updated
	indices.remove((Integer) indices.size()-1); // O(1)
	ArrayList<Integer> list = valToIndex.getOrDefault(j, new ArrayList<Integer>());
	list.add(index);
	valToIndex.put(j, list);
	shiftDown(index);
	shiftUp(index);
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
	valToIndex = new HashMap<>(); // added
    A.add(0); // dummy, this BinaryHeap is 1-based
    for (int i = 1; i <= BinaryHeapSize; i++) {// copy the content
      A.add(arr[i-1]);
	  ArrayList<Integer> list = valToIndex.getOrDefault(arr[i-1], new ArrayList<Integer>());
	  list.add(i);
	  valToIndex.put(arr[i-1], list); // added
	}
    for (int i = parent(BinaryHeapSize); i >= 1; i--)
      shiftDown(i);
  }

  ArrayList<Integer> HeapSort(int[] arr) { // array arr is 0-based
    CreateHeap(arr);
    int N = arr.length;
    for (int i = 1; i <= N; i++) {
	  int max = ExtractMax();
      A.set(N-i+1, max);
	  valToIndex.get(max).remove((Integer) 1);
	  valToIndex.get(max).add(N-i+1);
	}
    return A; // ignore the first index 0
  }

  int size() { return BinaryHeapSize; }
  
  boolean isEmpty() { return BinaryHeapSize == 0; }
}
