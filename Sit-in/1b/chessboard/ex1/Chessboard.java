/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Chessboard {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();

		for (int i = 0; i < r; i ++) {
			for (int j = 0; j < c; j++) {
				if ((i+j) % 2 == 0) {
					System.out.print("O");
				} else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Chessboard newChessboard = new Chessboard();
		newChessboard.run();
	}
}
