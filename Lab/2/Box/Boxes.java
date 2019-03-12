/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Boxes {
	private void run() {
		//implement your "main" method here

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        long r = sc.nextLong();
        long c = sc.nextLong();

        //sit: hashmap.put(x, y). key is x, val is y coord
        //box: lookup hashmap to see if coordinates in map, ie if map.containsKey(x) && map.get(x).contains(y)
        //row: lookup hashmap to see if map.containsKey(x)
        //col: lookup hashmap to see if map.values().contains(y)
        
        HashMap<Long, ArrayList<Long>> map = new HashMap<>();

        for (int i = 0; i < q; i++) {
            String command = sc.next();
            if (command.equals("SIT")) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                if (map.containsKey(x)) {
                    ArrayList<Long> curr = map.get(x);
                    curr.add(y);
                    map.replace(x, curr);
                } else {
                    ArrayList<Long> lst = new ArrayList<>();
                    lst.add(y);
                    map.put(x, lst);
                }
            } else if (command.equals("BOX")) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                if (map.containsKey(x) && map.get(x).contains(y)){ 
                    System.out.println("Y");
                } else {
                    System.out.println("N");
                }
            } else if (command.equals("ROW")) {
                long x = sc.nextLong();
                if (map.containsKey(x)) {
                    System.out.println("Y");
                } else {
                    System.out.println("N");
                }
            } else if (command.equals("COL")) {
                long y = sc.nextLong();
                Collection<ArrayList<Long>> values = map.values();
                boolean found = false;
                for (ArrayList<Long> lst: values) {
                    if (lst.contains(y)) {
                        System.out.println("Y");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("N");
                }
            }
        }
    }

    public static void main(String[] args) {
        Boxes newBoxes = new Boxes();
        newBoxes.run();
    }
}
