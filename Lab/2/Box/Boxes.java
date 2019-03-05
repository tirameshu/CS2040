/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Boxes {
	private void run() {
		//implement your "main" method here
        //Output as scanner loops to take in tokens
        //Maintain a boolean matrix (2d array)

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();

        boolean[][] matrix = new boolean[r][c];
        //by default all false

        for (int i = 0; i < q; i++) {
            String command = sc.next();
            if (command.equals("SIT")) {
                matrix[sc.nextInt()][sc.nextInt()] = true;
            } else if (command.equals("BOX")) {
                if (matrix[sc.nextInt()][sc.nextInt()]) {
                    System.out.println("Y");
                } else {
                    System.out.println("N");
                }
            } else if (command.equals("ROW")) {
                boolean[] row = matrix[sc.nextInt()];
                boolean has = false;
                for (boolean b: row) {
                    if (b) {
                        has = true;
                        break;
                    }
                }
                if (has) {
                    System.out.println("Y");
                } else {
                    System.out.println("N");
                }
            } else if (command.equals("COL")) {
                int col = sc.nextInt();
                boolean has = false;
                for (int j = 0; j < r; j++) {
                    //go through all rows and find the specified col
                    if (matrix[j][col]) {
                        has = true;
                        break;
                    }
                }
                if (has) {
                    System.out.println("Y");
                } else {
                    System.out.println("N");
                }
            } else {
                System.out.println("idk");
            }
        }
	}

	public static void main(String[] args) {
		Boxes newBoxes = new Boxes();
		newBoxes.run();
	}
}
