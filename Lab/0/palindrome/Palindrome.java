/*
 * author		: [Wang Xinman]
 * matric no.	: [A0180257E]
 */

import java.util.*;

public class Palindrome {
	/* use this method to check whether the string is palindrome word or not
	 * 		PRE-Condition  : 
	 * 		POST-Condition :
	 */
	public static boolean isPalindrome(String word) {
        for (int i = 0; i < (word.length() / 2); i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
	}
	
	public static void main(String[] args) {
		// declare the necessary variables
        String string1;
        String string2;
        String concat;

		// declare a Scanner object to read input
        Scanner sc = new Scanner(System.in);


		// read input and process them accordingly
        string1 = sc.next();
        string2 = sc.next();
        concat = string1 + string2;

        if (isPalindrome(concat)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


		// simulate the problem


		// output the result

	}
}
