/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Ballpassing {
	private void run() {
        List<String> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            students.add(sc.next());
        }

        long q = sc.nextLong();
        int index = 0;

        for (int j = 0; j < q; j++) {
            String event = sc.next();

            if (event.equals("NEXT")) {
                index++;
            } else if (event.equals("JOIN")) {
                String newStudent = sc.next();
                index++;
                if (index < students.size()) {
                    students.add(index, newStudent);
                } else {
                    students.add(newStudent);
                }
            } else {
                students.remove(index);
            }

            index = index % students.size();
            System.out.println(students.get(index));
        }
	}

	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}
