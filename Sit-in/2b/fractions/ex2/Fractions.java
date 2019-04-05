/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Fractions {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<MixedFrac> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			MixedFrac frac = new MixedFrac(sc.nextInt(), sc.nextInt(), sc.nextInt());
			queue.add(frac);
		}

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

	public static void main(String[] args) {
		Fractions newFractions = new Fractions();
		newFractions.run();
	}
}

class MixedFrac implements Comparable<MixedFrac> {
	int a;
	int b;
	int c;
	long numerator;
	int denominator;

	public MixedFrac(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.numerator = a*c+b;
		this.denominator = c;
	}

	public int compareTo(MixedFrac other) {
		long lhs = this.numerator * other.denominator;
		long rhs = this.denominator * other.numerator;
		if (lhs < rhs) {
			return -1;
		} else if (lhs == rhs) {
			if (this.a == other.a) {
				if (this.b == other.b) {
					return this.c - other.c;
				} else {
					return this.b - (other.b);
				}
			} else {
				return this.a - other.a;
			}
		} else {
			return 1;
		}
	}

	public String toString() {
		return (this.a + " " + this.b + " " + this.c);
	}
}
