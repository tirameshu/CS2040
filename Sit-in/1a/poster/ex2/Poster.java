/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Poster {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		sc.nextLine();
		char[] characters = sc.nextLine().toCharArray();

		int index = 0; // last printed index

		while (index < characters.length) {
			int end = Math.min(index + w, characters.length);
			if (end < characters.length-1 && characters[end] != ' ') { //checks if the letter after the w-th letter is non-empty
				while (characters[end] != ' ') {
					end--;
				}
			}
			// end is now after the last letter to be printed
			System.out.print("|");
			for (int i = index; i < end; i++) {
				System.out.print(characters[i]);
			}
			for (int j = 0; j < w - (end-index); j++) {
				System.out.print(" ");
			}
			System.out.println("|");
			index = end + 1;
		}
	}

	public static void main(String[] args) {
		Poster newPoster = new Poster();
		newPoster.run();
	}
}
