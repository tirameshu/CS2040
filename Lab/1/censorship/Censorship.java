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
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.next().toLowerCase());
        }

        while (sc.hasNext()) {
            String word = sc.next();
            if (arr.contains(word.toLowerCase())) {
                String string = "";
                for (int i = 0; i < word.length(); i++) {
                    string += "*";
                }
                result.add(string);
            } else {
                result.add(word);
            }
        }
        
        for (int i = 0; i < result.size() - 1; i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println(result.get(result.size() - 1));
	}

	public static void main(String[] args) {
		Censorship newCensorship = new Censorship();
		newCensorship.run();
	}
}
