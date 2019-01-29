/**
 *
 * author	: [Wang Xinman]
 * matric no: [A0180257E]
 * 
 */

import java.util.*;

public class StringComparison {
	
	public static void main(String[] args) {

		// declare the necessary variables
        String string1;
        String string2;


		// declare a Scanner object to read input
        Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
        string1 = sc.next().toLowerCase();
        string2 = sc.next().toLowerCase();

        if (string1.compareTo(string2) < 0) {
            System.out.println("1");
        } else if (string1.compareTo(string2) > 0) {
            System.out.println("2");
        } else {
            System.out.println("0");
        }

	}
}
