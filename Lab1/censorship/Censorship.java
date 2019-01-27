/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Censorship {
	private void run() {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.next().toLowerCase());
        }

        while (sc.hasNext()) {
            String word = sc.next();
            if (arr.contains(word.toLowerCase())) {
                for (int i = 0; i < word.length(); i++) {
                    System.out.print("*");
                }
                System.out.print(" ");
            } else {
                System.out.print(word + " ");
            }
        }
	}

	public static void main(String[] args) {
		Censorship newCensorship = new Censorship();
		newCensorship.run();
	}
}
