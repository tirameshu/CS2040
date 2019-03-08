import java.util.*;

class DiffInBinary {
    public static void main(String[] args) {
        String string = "1000010110";
        Queue<Character> q = new LinkedList<>();

        for (char c: string.toCharArray()) {
            if (q.isEmpty()) {
                q.offer(c);
            } else {
                char current = q.peek();
                if (current == c) {
                    q.offer(c);
                } else {
                    q.poll();
                }
            }
        }

        if (q.isEmpty()) {
            System.out.println("There are equal numbers of 1s and 0s");
        } else {
            char remaining = q.peek();
            System.out.println("There are " + q.size() + " " + remaining + "s left");
        }
    }
}
