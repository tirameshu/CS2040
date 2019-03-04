/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Generate {
    private static ArrayList<String> perms = new ArrayList<>();
    private static SortedSet<String> powerSet = new TreeSet<>();

    private ArrayList<String> slot(String firstLetter, ArrayList<String> lst) {
        ArrayList<String> newList = new ArrayList<>();
        for (String s: lst) {
            if (s.length() > 0) {
                powerSet.add(s);
            }
            for (int i = 0; i <= s.length(); i++) {
                String string = new StringBuilder(s).insert(i, firstLetter).toString();
                if (!newList.contains(string)) {
                    newList.add(string);
                }
            }
        }
        
        return newList;
    }

    private ArrayList<String> permutate(String str) {
        if (str.length() == 0) {
            ArrayList<String> lst = new ArrayList<>();
            lst.add(str);
            return lst;
        }
        String firstLetter = String.valueOf(str.charAt(0));
        powerSet.add(firstLetter);
        String substring = new StringBuilder(str).substring(1);
        return slot(firstLetter, permutate(substring));
    }

    private void subSeq(String string) {
        StringBuilder sb;
        for (int j = 0; j < string.length(); j++) {
            sb = new StringBuilder(string);
            String letter = sb.substring(j, j+1).toString();
            for (int k = j + 1; k < string.length(); k++) {
                sb = new StringBuilder(letter); //ensures that all possible pairs are made
                String toAdd = sb.append(string.charAt(k)).toString();
                powerSet.add(toAdd);
            }
        }
    }

    /*
    private void addTo(SortedSet<Set<String>> ss, String str) {
        TreeSet<String> set = new TreeSet<>();
        set.add(str);
        ss.add(set);
    }
    */

	private void run() {
		//implement your "main" method here
        Scanner sc = new Scanner(System.in);

        String w = sc.next();
        perms = permutate(w);
        Collections.sort(perms);
        for (String res: perms) {
            System.out.println(res);
        }
        subSeq(w);
        powerSet.forEach(System.out::println);
        /*
        subSeq(w);
        Collections.sort(powerSet);
        for (String p: powerSet) {
            System.out.println(p);
        }
        */
	}

	public static void main(String[] args) {
		Generate newGenerate = new Generate();
		newGenerate.run();
	}
}
