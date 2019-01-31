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
        Iterator<String> it = students.iterator();

        for (long j = 0; j < q; j++) {
            String event = sc.next();

            if (event.equals("NEXT")) {
                index++;
                System.out.println(it.next());
            } else if (event.equals("JOIN")) {
                String newStudent = sc.next();
                index++;
                if (index < students.size()) {
                    students.add(index, newStudent);
                } else {
                    students.add(newStudent);
                }
                System.out.println(newStudent);
            } else {
                students.remove(index);
                System.out.println(it.next());
            }

            index = index % students.size();
            if (j >= students.size()) {
                it = students.iterator();
            }
        }
	}

	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}
