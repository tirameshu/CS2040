import java.util.*;

public class Main {
    private static double add(Stack<Double> numbers) {
        double result = 0;
        while (!numbers.empty()) {
            result += numbers.pop();
        }
        return result;
    }

    private static double minus(Stack<Double> numbers) {
        double result = numbers.pop();
        int count = 0;
        while (!numbers.empty()) {
            result -= numbers.pop();
        }
            
        if (count == 0) {
            return result*(-1);
        } else {
            return result;
        }
    }

    private static double times(Stack<Double> numbers) {
        double result = 1;
        while (!numbers.empty()) {
            result *= numbers.pop();
        }
        return result;
    }

    private static double divide(Stack<Double> numbers) {
        double result = numbers.pop();
        int count = 0;

        while (!numbers.empty()) {
            result /= numbers.pop();
        }
        if (count == 0) {
            return 1/result;
        } else {
            return result;
        }
    }

    private static double calculate(String op, Stack<Double> numbers) {
        if (op.equals("+")) {
            return add(numbers);
        } else if (op.equals("-")) {
            return minus(numbers);
        } else if (op.equals("*")) {
            return times(numbers);
        } else if (op.equals("/")) {
            return divide(numbers);
        } else if (op.equals("(")) {
            System.out.println("Why is there an open bracket instead of operator?");
            return 0;
        } else {
            System.out.println("unknown situation");
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Object> stack1 = new Stack<>();
        Stack<Double> numbers = new Stack<>();
          
       while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                while (sc.hasNextDouble()) {
                    numbers.push(sc.nextDouble());
                }
                String next = sc.next();
                if (next.equals(")")) {
                   Object _next = stack1.pop();
                   if (_next instanceof Double) {
                       numbers.push((double) _next);
                       while (!stack1.empty()) {
                           Object item = stack1.pop();
                           if (item instanceof Double) {
                               numbers.push((double) item);
                           } else if (!item.equals("(")) {
                               String op = (String) item;
                               double result = calculate(op, numbers);
                               stack1.push(result);
                               break;
                           }
                       }
                   } else {
                       String op = (String) _next;
                       double result = calculate(op, numbers);
                       stack1.pop(); //removing the open bracket
                       stack1.push(result);
                   }
                } else if (next.equals("(")) {
                    String op = (String) stack1.peek();
                    double result = calculate(op, numbers);
                    stack1.push(result);
                    stack1.push(next);
                }
                
            } else {
                stack1.push(sc.next());
            }
       }
       
       System.out.println(stack1.pop());
    }
}
