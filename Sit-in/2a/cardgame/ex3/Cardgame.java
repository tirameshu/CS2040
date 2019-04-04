/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Cardgame {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Monster> monsters = new PriorityQueue<>();

		int q = sc.nextInt();
		int heal = 0;

		for (int i = 0; i < q; i++) {
			String command = sc.next();

			switch (command) {
				case "SUMMON":
					long health = sc.nextLong();
					monsters.add(new Monster(health-heal));
					break;

				case "KILL":
					Monster dead = monsters.poll();
					System.out.println((dead.health + heal));
					break;

				case "HEAL":
					heal += sc.nextLong();
					break;
			}
		}

		int size = monsters.size();

		for (int j = 0; j < size-1; j++) {
			System.out.print((monsters.poll().health+heal + " "));
		}
		System.out.println((monsters.poll().health + heal));
	}

	public static void main(String[] args) {
		Cardgame newCardgame = new Cardgame();
		newCardgame.run();
	}
}

class Monster implements Comparable<Monster> {
	long health;

	public Monster(long health) {
		this.health = health;
	}

	public int compareTo(Monster other) {
		return Long.compare(this.health, other.health);
	}
}
