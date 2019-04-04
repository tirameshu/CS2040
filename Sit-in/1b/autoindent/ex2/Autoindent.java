/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Autoindent {
	private void print(char[] line, int start, int indent) {
		for (int i = 0; i < indent; i++) {
			System.out.print(" ");
		}
		System.out.println(Arrays.copyOfRange(line, start, line.length));
	}

	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int indent = 0;

		while (sc.hasNext()) {
			char[] line = sc.nextLine().toCharArray();
			int start = 0;
			for (int i = 0; i < line.length; i++) {
				if (line[i] != ' ') {
					start = i;
					break;
				}
			}
			char end = line[line.length-1];

			if (end == '{') {
				print(line, start, indent);
				indent += 2;
			} else if (end == '}') {
				indent -= 2;
				print(line, start, indent);
			} else {
				print(line, start, indent);
			}
		}
	}

	public static void main(String[] args) {
		Autoindent newAutoindent = new Autoindent();
		newAutoindent.run();
	}
}
