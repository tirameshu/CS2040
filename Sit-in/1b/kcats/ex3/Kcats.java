/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Kcats {
	
	boolean isFlipped = false;

	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		Deque<String> deque = new LinkedList<>();

		for (int i = 0; i < k; i++) {
			String command = sc.next();
			switch (command) {
				case "ADD":
					String name = sc.next();
					if (isFlipped) {
						deque.addFirst(name);
					} else {
						deque.offerLast(name);
					}
					break;

				case "REMOVE":
					if (isFlipped) {
						System.out.println(deque.removeFirst());
					} else {
						System.out.println(deque.removeLast());
					}
					break;

				case "FLIP":
					isFlipped = !isFlipped;
					break;
			}
		}

		int size = deque.size();

		for (int j = 0; j < size-1; j++) {
			if (isFlipped) {
				System.out.print(deque.removeFirst() + " ");
			} else {
				System.out.print(deque.removeLast() + " ");
			}
		}
		if (isFlipped) {
			System.out.println(deque.removeFirst());
		} else {
			System.out.println(deque.removeLast());
		}
	}

	public static void main(String[] args) {
		Kcats newKcats = new Kcats();
		newKcats.run();
	}
}
