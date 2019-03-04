import java.util.*;

class Wait {
    public static int computeMinWait(List<Integer> servingTimes) {
        //implement priority queue for the numbers to be in asc order
        //always pop to get the smallest number, multiply by the number of ppl in queue
        PriorityQueue<Integer> queue = new PriorityQueue<>(servingTimes);
        int total = 0;
        
        while (queue.size() != 0) {
            total += queue.poll() * queue.size();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Integer> servingTimes = new ArrayList<>();
        servingTimes.add(10);
        servingTimes.add(3);
        servingTimes.add(2);
        servingTimes.add(9);
        servingTimes.add(4);
        servingTimes.add(23);
        servingTimes.add(30);
        servingTimes.add(1);
        servingTimes.add(5);

        System.out.println(computeMinWait(servingTimes));
    }
}
