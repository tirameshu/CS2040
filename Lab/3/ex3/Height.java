/*
 * Name       : Wang Xinman 
 * Matric No. : A0180257E
 * Plab Acct. : -
 */
import java.util.*;

public class Height {
    private void run() {
        //implement your "main" method here
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, ArrayList<Pair<Integer, Integer>>> graphs = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int h = sc.nextInt();
            ArrayList<Pair<Integer, Integer>> neighboursOfA;
            if (graphs.containsKey(a)) {
                neighboursOfA = graphs.get(a);
            } else {
                neighboursOfA = new ArrayList<>();
            }
                
            neighboursOfA.add(new Pair<Integer, Integer>(b, h));
            graphs.put(a, neighboursOfA);

            ArrayList<Pair<Integer, Integer>> neighboursOfB;
            if (graphs.containsKey(b)) {
                neighboursOfB = graphs.get(b);
            } else {
                neighboursOfB = new ArrayList<>();
            }    
            neighboursOfB.add(new Pair<Integer, Integer>(a, -h));
            graphs.put(b, neighboursOfB);
        }

        int q = sc.nextInt();
        for (int k = 0; k < q; k++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            if (from == to) {
                System.out.println("0");
                continue;
            }

            boolean[] visited = new boolean[n+1];
            System.out.println(search(from, to, graphs, visited));
        }
    }
    //guaranteed reachable
    private int search(int from, int to, HashMap<Integer, ArrayList<Pair<Integer, Integer>>> graph, boolean[] visited) {
        ArrayList<Pair<Integer, Integer>> neighbours = graph.get(from);
        visited[from] = true;
        int height = 0;
		for (Pair<Integer, Integer> neighbour: neighbours) {
            int key = neighbour.getKey();
            //System.out.println("me is: " + from + "neighbour is: " + key + "to: " + to);
			if (!visited[key]) { //yet to visit
                visited[key] = true;
                if (key != to) {
                    int result = search(neighbour.getKey(), to, graph, visited);
                    if (result != 0) {
                        return neighbour.getValue() + result;
                    } else {
                        continue;
                    }
                } else {
                    return neighbour.getValue();
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Height newHeight = new Height();
        newHeight.run();
    }
}

class Pair<K, V> {
    K key;
    V val;

    public Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }

    K getKey() {
        return this.key;
    }

    V getValue() {
        return this.val;
    }
}
