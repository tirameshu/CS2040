/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Generate {
    private static ArrayList<String> perms = new ArrayList<>();
    private static List<String> powerSet = new ArrayList<>();

    private void permute(String start, String end) {
        if (end.length() <= 1) {
            perms.add(start+end);
        } else {
            for (int i = 0; i < end.length(); i++) {
                String sub = end.substring(0, i) + end.substring(i+1, end.length());
                String newStart = start + end.substring(i, i+1);
                permute(newStart, sub);
            }
        }
    }

    private void permutate(String str) {
        // permutate takes in two args, a starting and ending string
        // ending string is what has yet to be permutated
        // the start string is what is to be appended to the front of the ending string
        // take out every letter in the endingstring, and add the letter to the front of the permutation of the rest of the letters
        // until ending letter has only 1 letter, permutation of which is just one letter, so can directly add the starting string to it.
        permute("", str);
    }

    private ArrayList<String> powerset(List<String> lst) {
        if (lst.size() == 0) {
            ArrayList<String> l = new ArrayList<>();
            l.add("");
            return l;
        }
        String head = lst.get(0);
        List<String> sublist = powerset(lst.subList(1, lst.size()));
        ArrayList<String> combined = new ArrayList<>(sublist);
        for (String s: sublist) {
            combined.add(head+s);
        }
        return combined;
    }
    
	private void run() {
		//implement your "main" method here
        Scanner sc = new Scanner(System.in);

        String w = sc.next();
        permutate(w);
        Collections.sort(perms);
        StringBuilder result = new StringBuilder();
        for (String res: perms) {
            result.append(res + "\n");
        }
        
        ArrayList<String> letters = new ArrayList<>();
        for (int i = 0; i < w.length(); i++) {
            letters.add(String.valueOf(w.charAt(i)));
        }

        powerSet = powerset(letters);
        powerSet = powerSet.subList(1, powerSet.size());
        Collections.sort(powerSet);
        for (String s: powerSet.subList(0, powerSet.size() - 1)) {
            result.append(s + "\n");
        }
        result.append(powerSet.get(powerSet.size() - 1));
        System.out.println(result.toString());
	}

	public static void main(String[] args) {
		Generate newGenerate = new Generate();
		newGenerate.run();
	}
}
