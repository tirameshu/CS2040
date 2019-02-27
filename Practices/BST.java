class BST {
    public static boolean search (int[] arr, int val) {
        return search(arr, val, 0, arr.length);
    }
    
    private static boolean search(int[] arr, int val, int start, int end) {
        if (start == end) {
            return (val == arr[start]);
        }

        int mid = (start + end)/2;
        if (val < arr[mid]) {
            return search(arr, val, start, mid);
        } else if (val == arr[mid]) {
            return true;
        } else {
            return search(arr, val, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-9, -3, 0, 3, 9, 20};

        System.out.println(BST.search(arr, 20));
        System.out.println(BST.search(arr, 3));
        System.out.println(BST.search(arr, 1));
    }
}
