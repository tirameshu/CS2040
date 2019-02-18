import java.util.*;

class Main {
    public int sum(int n) {
        if (n == 1) {
            return n;
        } else {
            return n + sum(n-1);
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int[] row: matrix) {
            for (int col: row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private void paintBucketFill(int[][] matrix, int row, int col, int colour, int original) {
        if (matrix[row][col] == original) {
            matrix[row][col] = colour;
            if (row < matrix.length) {
                paintBucketFill(matrix, row+1, col, colour, original);
            }
            if (col < matrix[0].length) {
                paintBucketFill(matrix, row, col+1, colour, original);
            }
            if (row > 0) {
                paintBucketFill(matrix, row-1, col, colour, original);
            }
            if (col > 0) {
                paintBucketFill(matrix, row, col-1, colour, original);
            }
        }
    }

    public void paintBucketFill(int[][] matrix, int row, int col, int colour) {
        int original_colour = matrix[row][col];
        if (original_colour != colour) {
            paintBucketFill(matrix, row, col, colour, original_colour);
        }
    }
    
    public int sum(Stack<Integer> s) {
        return s.pop() + sum(s);
    }

    public void insert(Stack<Integer> s, Integer val) {
        if (s.empty()) {
            s.push(val);
            return;
        }
        Integer top = s.peek();
        if (val >= top) {
            s.push(val);
        } else {
            int temp = s.pop();
            insert(s, val);
            s.push(temp);
        }
    }

    public void delete(Stack<Integer> s, Integer val) {
        int top = s.pop();
        if (top != val) {
            delete(s, val);
            s.push(top);
        }
    }
    
    public void sort(Stack<Integer> s) {
        if (!s.empty()) {
            int top = s.pop();
            sort(s);
            insert(s, top);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(2);
        s.push(1);
        s.push(4);
        main.sort(s);
 
        while (!s.empty()) {
            System.out.println(s.pop());
        }
        /*
        int[][] colourMatrix = {
            {1, 1, 1, 1, 2, 2, 2, 1},
            {1, 1, 1, 0, 0, 0, 0, 2},
            {2, 1, 0, 0, 0, 0, 2, 2},
            {1, 0, 0, 0, 0, 0, 2, 2},
            {2, 0, 0, 2, 2, 2, 1, 1},
            {2, 0, 0, 2, 2, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 2}
        };
        System.out.println("Before fill...");
        main.printMatrix(colourMatrix);
        System.out.println();
        main.paintBucketFill(colourMatrix, 2, 3, 2);
        System.out.println("After fill...");
        main.printMatrix(colourMatrix);
        */
    }
}
