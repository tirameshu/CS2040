/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Generate {
    private static ArrayList<String> perms = new ArrayList<>();
    private static List<String> powerSet = new ArrayList<>();

    private ArrayList<String> slot(String firstLetter, ArrayList<String> lst) {
        ArrayList<String> newList = new ArrayList<>();
        for (String s: lst) {
            /*
            if (s.length() > 0) {
                addTo(powerSet, s);
            }
            */
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
        //addTo(powerSet, firstLetter);
        String substring = new StringBuilder(str).substring(1);
        return slot(firstLetter, permutate(substring));
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
    
    /*
    private void addTo(ArrayList<Set<String>> ss, String str) {
        TreeSet<Character> set = new TreeSet<>();
        if (!ss.contains(set)) {
            System.out.println(set.toString());
            ss.add(set);
        }
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
        
        ArrayList<String> letters = new ArrayList<>();
        for (int i = 0; i < w.length(); i++) {
            letters.add(String.valueOf(w.charAt(i)));
        }

        powerSet = powerset(letters);
        powerSet = powerSet.subList(1, powerSet.size());
        Collections.sort(powerSet);
        for (String s: powerSet) {
            System.out.println(s);
        }
        /*
        subSeq(w);
        SortedSet<String> ps = new TreeSet<>();
        for (Set<String> s: powerSet) {
            ps.add(s.toString());
        }
        ps.forEach(System.out::println);
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
