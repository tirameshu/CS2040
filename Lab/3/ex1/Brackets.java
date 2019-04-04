/*
 * Name       : Wang Xinman 
 * Matric No. : A0180257E
 * Plab Acct. : -
 */
import java.util.*;

public class Brackets {
    private void run() {
        //implement your "main" method here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //number of test cases
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt(); //number of brackets
            char[] bracket = sc.next().toCharArray();
            boolean openBeforeClose = true;
            for (int j = 0; j < l; j++) {
                switch (bracket[j]) {
                    case '(':
                    case '[':
                    case '{':
                        brackets.push(bracket[j]);
                        break;
                    case ')':
                        if (brackets.isEmpty() || !brackets.peek().equals('(')) {
                            openBeforeClose = false;
                            break;
                        }
                        brackets.pop();
                        break;
                    case ']':
                        if (brackets.isEmpty() || !brackets.peek().equals('[')) {
                            openBeforeClose = false;
                            break;
                        }
                        brackets.pop();
                        break;
                    case '}':
                        if (brackets.isEmpty() || !brackets.peek().equals('{')) {
                            openBeforeClose = false;
                            break;
                        }
                        brackets.pop();
                        break;
                }
            }
            
            if (brackets.isEmpty() && openBeforeClose) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
            
            brackets.clear(); openBeforeClose = true;
        }
    }
    
    public static void main(String[] args) {
        Brackets newBrackets = new Brackets();
        newBrackets.run();
    }
}
