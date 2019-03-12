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

        //sit: hashxAsKey.put(x, y). key is x, val is y coord
        //box: lookup hashxAsKey to see if coordinates in xAsKey, ie if xAsKey.containsKey(x) && xAsKey.get(x).contains(y)
        //row: lookup hashxAsKey to see if xAsKey.containsKey(x)
        //col: lookup hashxAsKey to see if xAsKey.values().contains(y)
        
        HashMap<Long, ArrayList<Long>> xAsKey = new HashMap<>();
        HashMap<Long, ArrayList<Long>> yAsKey = new HashMap<>();

        for (int i = 0; i < q; i++) {
            String command = sc.next();
            if (command.equals("SIT")) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                if (xAsKey.containsKey(x)) {
                    ArrayList<Long> curr = xAsKey.get(x);
                    curr.add(y);
                    xAsKey.replace(x, curr);
                } else {
                    ArrayList<Long> lst = new ArrayList<>();
                    lst.add(y);
                    xAsKey.put(x, lst);
                }
                if (yAsKey.containsKey(y)) {
                    ArrayList<Long> curr = yAsKey.get(y);
                    curr.add(x);
                    yAsKey.replace(y, curr);
                } else {
                    ArrayList<Long> lst = new ArrayList<>();
                    lst.add(x);
                    yAsKey.put(y, lst);
                }
            } else if (command.equals("BOX")) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                if (xAsKey.containsKey(x) && xAsKey.get(x).contains(y)){ 
                    System.out.println("Y");
                } else {
                    System.out.println("N");
                }
            } else if (command.equals("ROW")) {
                long x = sc.nextLong();
                if (xAsKey.containsKey(x)) {
                    System.out.println("Y");
                } else {
                    System.out.println("N");
                }
            } else if (command.equals("COL")) {
                long y = sc.nextLong();
                if (yAsKey.containsKey(y)) {
                    System.out.println("Y");
                } else {
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
