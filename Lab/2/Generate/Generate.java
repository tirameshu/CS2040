/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Generate {
    private static ArrayList<String> perms = new ArrayList<>();
    private static ArrayList<String> powerSet = new ArrayList<>();
    private ArrayList<String> slotAndSubseq(char firstLetter, ArrayList<String> lst) {
        ArrayList<String> newList = new ArrayList<>();
        for (String s: lst) {
            for (int i = 0; i <= s.length(); i++) {
                String string = new StringBuilder(s).insert(i, firstLetter).toString();
                char[] arr = string.toCharArray();
                Arrays.sort(arr);
                String sortedString = new String(arr);
                System.out.println("sorted: " + sortedString);
                if (i == 0 && !powerSet.contains(sortedString)) {//adds to the front of the last letter in the string
                    powerSet.add(string);
                }
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
        char firstLetter = str.charAt(0);
        String substring = new StringBuilder(str).substring(1);
        return slotAndSubseq(firstLetter, permutate(substring));
    }

    private void subSeq(String string) {
        StringBuilder sb;
        for (int j = 0; j < string.length(); j++) {
            sb = new StringBuilder(string);
            String letter = sb.substring(j, j+1).toString(); //add the individual letters
            if (!powerSet.contains(letter)) {
                powerSet.add(letter);
            }
            for (int k = j + 1; k < string.length(); k++) {
                sb = new StringBuilder(letter); //ensures that all possible pairs are made
                String toAdd = sb.append(string.charAt(k)).toString();
                if (!powerSet.contains(toAdd)) {
                    powerSet.add(toAdd);
                }
            }
        }
    }

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
        Collections.sort(powerSet);
        for (String p: powerSet) {
            System.out.println(p);
        }
	}

	public static void main(String[] args) {
		Generate newGenerate = new Generate();
		newGenerate.run();
	}
}
