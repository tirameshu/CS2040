import java.util.*;

public class WaitingQueue {
    private String[] waitingHere;
    private int front;
    private int back;
    
    private static final int ARR_LENGTH = 10;
    
    public WaitingQueue() {
        waitingHere = new String(ARR_LENGTH);
    }

    public void addAPerson(String name) {
        if (back == ARR_LENGTH) {

    }

    public String serveNextPerson() {
        String person = waitingHere.get(0);
        waitingHere.remove(person);
        return person;
    }
    
    public boolean leave(String name) {
        if (waitingHere.contains(name)) {
            waitingHere.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return waitingHere[0] == null;
    }

    public static void main(String[] args) {
        WaitingQueue q = new WaitingQueue();

        q.addAPerson("Person 1");
        q.addAPerson("Person 2");
        q.addAPerson("Person 3");
        q.addAPerson("Person 4");
        q.addAPerson("Person 5");
        q.addAPerson("Person 6");
        q.addAPerson("Person 7");
        q.addAPerson("Person 8");

        System.out.println(q.serveNextPerson());
        System.out.println(q.serveNextPerson());

        boolean b1 = q.leave("Person 2");
        boolean b2 = q.leave("Person 3");
        boolean b3 = q.leave("Person 4");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        while (!q.isEmpty()) {
            System.out.println(q.serveNextPerson());
        }
    }
}
