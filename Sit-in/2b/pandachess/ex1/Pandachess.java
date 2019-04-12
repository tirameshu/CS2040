/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Pandachess {
	List<Rook> rooks = new ArrayList<>();

	private List<List<Rook>> powerSet(List<Rook> rooks) {
		// need keep result as a set of sets
		if (rooks.size() == 0) {
			List<List<Rook>> result = new ArrayList<>();
			result.add(rooks);
			return result;
		} else {
			Rook head = rooks.get(0);
			List<List<Rook>> sublist = powerSet(rooks.subList(1, rooks.size()));
			List<List<Rook>> combined = new ArrayList<>(sublist);
			for (List<Rook> list: sublist) {
				List<Rook> temp = new ArrayList<>(list);
				temp.add(head);
				combined.add(temp);
			}
			return combined;
		}
	}

	private boolean isValid(List<Rook> way) {
		List<Rook> remaining = new ArrayList<>();
		for (Rook rook: rooks) {
			if (!way.contains(rook)) {
				remaining.add(rook);
			}
		}

		remaining.sort((x, y) -> Long.compare(x.row, y.row)); // sort in asc order of row
		for (int i = 0; i < remaining.size()-1; i++) {
			if (remaining.get(i).row == remaining.get(i+1).row) {
				return false;
			}
		}

		remaining.sort((x, y) -> Long.compare(x.col, y.col));
		for (int i = 0; i < remaining.size()-1; i++) {
			if (remaining.get(i).col == remaining.get(i+1).col) {
				return false;
			}
		}
		return true;
	}

	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;

		for (int i = 0; i < n; i++) {
			Rook rook = new Rook(sc.nextLong(), sc.nextLong());
			rooks.add(rook);
		}

		List<List<Rook>> allWays = powerSet(rooks);

		for (List<Rook> way: allWays) {
			if (way.size() == n || !isValid(way)) {
				continue;
			} else {
				count++;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		Pandachess newPandachess = new Pandachess();
		newPandachess.run();
	}
}

class Rook {
	long row;
	long col;

	public Rook(long row, long col) {
		this.row = row;
		this.col = col;
	}

	public String toString() {
		return "(" + row + ", " + col + ")";
	}
}
