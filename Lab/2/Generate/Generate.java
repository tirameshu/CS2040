/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Generate {
    private ArrayList<String> permutate(String str) {
        char firstLetter = str.charAt(0);
        String substring = new StringBuilder(str).substring(1);
        return slot(firstLetter, substring);
    }

	private void run() {
		//implement your "main" method here
        Scanner sc = new Scanner(System.in);

        String w = sc.next();
        int length = w.length();
	}

	public static void main(String[] args) {
		Generate newGenerate = new Generate();
		newGenerate.run();
	}
}
