/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Ballpassing {
	private void run() {
        List<String> students = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String lastToCall = sc.next();
        for (int i = 0; i < n - 1; i++) {
            students.add(sc.next());
        }
        students.add(lastToCall);

        long q = sc.nextLong();
        int index = 0;
        String currentStudent;
        ListIterator<String> it = students.listIterator();
        currentStudent = it.next();
        System.out.println(currentStudent);

        for (long j = 0; j < q; j++) {
            String event = sc.next();
            System.out.println(students);

            if (event.equals("NEXT")) {
                index++;
                currentStudent = it.next();
            } else if (event.equals("JOIN")) {
                index++;
                it.add(sc.next()); //inserting newStudent to be called by next()
                it.previous(); //calls the just added e
                currentStudent = it.next();
                //need call next to move cursor back
                /*
                if (index < students.size()) {
                    students.add(index, newStudent);
                } else {
                    students.add(newStudent);
                }
                */
                //System.out.println(newStudent);
            } else {
                System.out.println("previous: " + it.previous());
                System.out.println("next: " + it.next());
                it.remove(); //apparently removes the last e called by next()
                //students.remove(index);
                currentStudent = it.next();
            }

            index = index % students.size();
            System.out.println("index: " + index);
            System.out.println(currentStudent);
            //it.remove();
            //if (currentStudent == null) {
                //set current to null for those that get it by calling .next()
                //so as to check for it.next here
                //if !hasNext(), means at first one, so reassign, then System.out.println(it.next());
                //else: System.out.println(current)
            //it.add(currentStudent); //"adds to end"
            if (currentStudent == students.get(students.size() - 1)) {
                it = students.listIterator();
                System.out.println("new it");
            }
        }
	}

	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}
