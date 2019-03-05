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

        long r = sc.nextLong();
        long c = sc.nextLong();

        boolean[][] matrix = new boolean[r][c];
        //by default all false

        for (int i = 0; i < q; i++) {
            String command = sc.next();
            if (command.equals("SIT")) {
                matrix[sc.nextLong()][sc.nextLong()] = true;
            } else if (command.equals("BOX")) {
                if (matrix[sc.nextLong()][sc.nextLong()]) {
                    System.out.println("Y");
                } else {
                    System.out.println("N");
                }
            } else if (command.equals("ROW")) {
                boolean[] row = matrix[sc.nextLong()];
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
                long c = sc.nextLong();
                boolean has = false;
                for (long j = 0; j < r; j++) {
                    //go through all rows and find the specified col
                    if (matrix[j][c]) {
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
