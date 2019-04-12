import java.util.*;

// barebones implementation of max heap

public class BinaryHeap {
  private ArrayList<Integer> A;
  private int BinaryHeapSize;
  private HashMap<Integer, HashSet<Integer>> valToIndex = new HashMap<>();

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
  
  void updateMap(int val, int toRemove, int newIndex) {
	  HashSet<Integer> list = valToIndex.getOrDefault(val, new HashSet<>()); // added
	  list.remove(toRemove); // added
	  list.add(newIndex); // added
	  valToIndex.put(val, list); // added
  }

  void updateMap(int val, int index) {
	  HashSet<Integer> list = valToIndex.getOrDefault(val, new HashSet<Integer>());
	  list.add(index);
	  valToIndex.put(val, list);
  }
 
  void shiftUp(int i) {
    while (i > 1 && A.get(parent(i)) < A.get(i)) {
      int temp = A.get(i);
	  int parent = A.get(parent(i));

      A.set(i, parent);
	  updateMap(parent, parent(i), i);

	  A.set(parent(i), temp);
	  updateMap(temp, i, parent(i));

      i = parent(i);
    }
  }

  void Insert(int key) {
    BinaryHeapSize++;
    if (BinaryHeapSize >= A.size()) {
      A.add(key);
	  updateMap(key, A.size()-1);
	} else {
      A.set(BinaryHeapSize, key);
	  updateMap(key, BinaryHeapSize);
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
		updateMap(m, max_id, i);

        A.set(max_id, temp);
		updateMap(temp, i, max_id);

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
	valToIndex.get(maxV).remove(1); // added
	updateMap(A.get(BinaryHeapSize), BinaryHeapSize, 1); // added
    BinaryHeapSize--; // virtual decrease
    shiftDown(1);
    
    return maxV;
  }
  
  void UpdateKey(int i, int j) {
    // implement this function
	Iterator<Integer> it = valToIndex.get(i).iterator();
	int index = it.next(); // assummed non-empty
	// System.out.println("I replaced " + i + " at index " + index + " to " + j);
	A.set(index, j); // updated
	
	valToIndex.get(i).remove(index);
	updateMap(j, index);

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
    A.add(0); // dummy, this BinaryHeap is 1-based
    for (int i = 1; i <= BinaryHeapSize; i++) {// copy the content
      A.add(arr[i-1]);
	  updateMap(arr[i-1], i);
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
	  updateMap(max, N-i+1);
	}
    return A; // ignore the first index 0
  }

  int size() { return BinaryHeapSize; }
  
  boolean isEmpty() { return BinaryHeapSize == 0; }
}
