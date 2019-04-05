/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Racing {
	List<List<Integer>> result = new ArrayList<>(); // to be populated with the permutations
	int n;
	long d;

	private void permute(List<Integer> start, List<Integer> end) {
		if (end.size() == 0) {
			result.add(start);
		} else {
			for (int k = 0; k < end.size(); k++) {
				int element = end.get(k);
				List<Integer> newStart = new ArrayList<>();
				for (int e: start) {
					newStart.add(e);
				}
				newStart.add(element);
				List<Integer> newEnd = new ArrayList<>();
				for (int e2: end) {
					newEnd.add(e2);
				}
				newEnd.remove(k);
				permute(newStart, newEnd);
			}
		}
	}

	private int count() {
		int counter = 0;
		for (List<Integer> perm: result) {
			int difficulty = 0;
			for (int j = 0; j < n-1; j++) {
				difficulty += Math.pow(perm.get(j+1) - perm.get(j), 2);
			}

			if (difficulty <= d) {
				counter++;
			}
		}
		return counter;
	}

	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		List<Integer> original = new ArrayList<>();
		n = sc.nextInt();
		d = sc.nextLong();

		for (int i = 0; i < n; i++) {
			original.add(sc.nextInt());
		}

		permute(new ArrayList<Integer>(), original);
		System.out.println(count());
	}

	public static void main(String[] args) {
		Racing newRacing = new Racing();
		newRacing.run();
	}
}
