/**
 *
 * author	: [Wang Xinman]
 * matric no: [A0180257E]
 * 
 */

import java.util.*;

public class HelloWorld {
	public static void parse(String op, String first, String second) {
        if (op.equals("AND")) {
            if (first.equals("1") && second.equals("1")) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        } else {
            if (first.equals("1") || second.equals("1")) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

	public static void main(String[] args) {

		// declare the necessary variables
        String input;
        int n;
        String operator;


		// declare a Scanner object to read input
        Scanner sc = new Scanner(System.in);


		// read input and process them accordingly
        input = sc.next();

        if (input.equals("1")) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                operator = sc.next();
                parse(operator, sc.next(), sc.next());
            }
        } else if (input.equals("2")) {
            operator = sc.next();
            while (!operator.equals("0")) {
                parse(operator, sc.next(), sc.next());
                operator = sc.next();
            }
        } else {
            while (sc.hasNext()) {
                operator = sc.next();
                parse(operator, sc.next(), sc.next());
            }
        }
            

	}
}
