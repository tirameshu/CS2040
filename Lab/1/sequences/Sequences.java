/**
 * Name         : Wang Xinman
 * Matric. No   : A0180257E
 * PLab Acct.   : 
 */

import java.util.*;

public class Sequences {
	private void run() {
		Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int prog = sc.nextInt();
        long a = sc.nextLong();
        if (prog == 1) {
            long d = sc.nextLong();
            long val = a;
            for (int i = 0; i < n - 1; i++) {
                System.out.print(val + " ");
                val += d;
            }
            System.out.println(val);
        } else {
            long r = sc.nextLong();
            long val = a;
            for (int i = 0; i < n - 1; i++) {
                System.out.print(val + " ");
                val *= r;
            }
            System.out.println(val);
        }
	}

	public static void main(String[] args) {
		Sequences newSequences = new Sequences();
		newSequences.run();
	}
}
