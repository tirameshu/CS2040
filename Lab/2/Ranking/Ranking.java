/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   :
 */

import java.util.*;

public class Ranking {
	private void run() {
		//implement your "main" method here
        //Mainain a sorted list of scores (reverse = True), separate from a list of names, which has a corresponding list of scores, such that the
        //ith element in namelist corresponds to ith score in rawScore list.
        //For every person, get his score from rawScore, then look through sortedScore.
        //Starting at s = 1, if sortedScore[s] == rawScore[i], System.out.println(name, s)
        //else, s++
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //number of students
        String[] nameList = new String[n];
        long[] rawScore = new long[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            long score = sc.nextLong();
            nameList[i] = name;
            rawScore[i] = score;
        }

        long[] sortedScore = Arrays.copyOf(rawScore, n);
        Arrays.sort(sortedScore);

        int s = n;
        for (int i = 0; i < n; i++) {
            String person = nameList[i];
            while (s >= 0) {
                if (sortedScore[s - 1] == rawScore[i]) {
                    System.out.println(person + " " + (n - s + 1));
                    break;
                } else {
                    s--;
                }
            }
            s = n;
        }
	}

	public static void main(String[] args) {
		Ranking newRanking = new Ranking();
		newRanking.run();
	}
}
