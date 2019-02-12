import java.util.*;

public class WaitingQueue {
    private String[] waitingHere;
    private int front;
    private int back;
    
    private static final int ARR_LENGTH = 10;
    
    public WaitingQueue() {
        waitingHere = new String[ARR_LENGTH];
    }

    public boolean addAPerson(String name) {
        if ((back + 1) % ARR_LENGTH == front) {
            //if back and front coincide, the list is empty
            //so if back is right before front, the list is full 
            return false;
        } else {
            waitingHere[back] = name;
            return true;
        }

    }

    public String serveNextPerson() {
        String person = waitingHere[front];
        waitingHere[front] = null;
        front = (front + 1) % ARR_LENGTH;
        return person;
    }
    
    public boolean leave(String name) {
        int pos = ARR_LENGTH;
        //loop through array to find the person who left
        if (pos < ARR_LENGTH) {
            waitingHere[pos] = null;
            while (waitingHere[pos] == null && pos != back) {
                waitingHere[pos] = waitingHere[pos+1];
                pos = (pos + 1) % ARR_LENGTH;
                waitingHere[pos] = null;
            }

            if (back > 0) {
                back = (back - 1) % ARR_LENGTH;
            } else {
                back = ARR_LENGTH;
            }
            return true;

        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return front == back;
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
