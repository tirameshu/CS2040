/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Printing {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < q; i++) {
			String command = sc.next();

			switch (command) {
				case "ADD":
					long priority = sc.nextLong();
					queue.offer(priority);
					break;

				case "PRINT":
					System.out.println(queue.poll());
					break;

				case "PRINTALL":
					int count = 1;
					long p = queue.poll();
					while (queue.size() > 0 && queue.peek() == p) {
						count++;
						queue.poll();
					}
					System.out.println(count+ " " + p);
					break;
			}
		}

		Stack<Long> stack = new Stack<>();
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		int size = stack.size();
		for (int i = 0; i < size-1; i++) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println(stack.pop());
	}

	public static void main(String[] args) {
		Printing newPrinting = new Printing();
		newPrinting.run();
	}
}
