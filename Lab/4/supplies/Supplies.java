/*
 * Name       : Wang Xinman
 * Matric No. : A0180257E
 * Plab Acct. : -
 */
import java.util.*;

public class Supplies {
	static final int INF = 1000000000;

	int[] distance;
	int n;
	HashMap<Integer, List<Pair>> map = new HashMap<>(); // map of cost between 2 cities
	PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost); // queue of cost from source

	class Pair {
		int v;
		int cost;

		public Pair(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}

	void modifiedD(int source) {
		distance = new int[n];

		for (int i = 0; i < n; i++) {
			if (i == source) {
				distance[source] = 0;
			} else {
				distance[i] = INF;
			}
		}

		pq.offer(new Pair(source, distance[source]));

		while(!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (pair.cost == distance[pair.v]) {
				//System.out.println("Vertex " + pair.v + " of distance " + distance[pair.v] + " from source has been processed");
				List<Pair> neighbours = map.getOrDefault(pair.v, new ArrayList<>());
				for (Pair neigh: neighbours) {
					if (distance[neigh.v] > distance[pair.v] + neigh.cost) {
						distance[neigh.v] = distance[pair.v] + neigh.cost;
						pq.offer(new Pair(neigh.v, distance[neigh.v]));
					}
				}
			}
		}
	}

    private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int e = sc.nextInt();
		int source = sc.nextInt();
		int dest = sc.nextInt();


		for (int i = 0; i < e; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			List<Pair> neighbours = map.getOrDefault(A, new ArrayList<Pair>());
			neighbours.add(new Pair(B, C));
			map.put(A, neighbours);
		}

		modifiedD(source);
		if (distance[dest] == INF) {
			System.out.println(-1);
		} else {
			int currentCost = distance[dest];
			modifiedD(dest);
			if (distance[source] == INF) {
				System.out.println(-1);
			} else {
				System.out.println((currentCost + distance[source]));
			}
		}
		
	}

    public static void main(String[] args) {
        Supplies newSupplies = new Supplies();
        newSupplies.run();
    }
}
