/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class PandaChess {
	
	/**
	A graph would be constructed based on the m matches
	If graph is cyclical, there is no topo order
	IF graph is not connected, there is no unique topo order
	Else output unique topo order
	*/

	int n, m;
	HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
	ArrayList<Integer> topo = new ArrayList<>();

	boolean[] visited; // assuming 1-base, n = #vertices
	// start with parent = -1

	public boolean isCyclic(int v, boolean[] visited, ArrayList<Integer> elders) {
		visited[v] = true;
		HashSet<Integer> neighbours = graph.getOrDefault(v, new HashSet<Integer>());
		Iterator<Integer> it = neighbours.iterator();
		boolean flag = false;
		while (it.hasNext()) {
			int neighbour = it.next();
			System.out.println("v " + v + " has parents: " + elders + " and has neighbour: " + neighbour);
			if (!visited[neighbour]) {
				elders.add(v);
				if (!flag) flag = isCyclic(neighbour, visited, elders);
			} else if (elders.contains(neighbour)) { // changed
				return true;
			}
		}

		return flag;
	}

	private void toposort(int v) { // dfs
		visited[v] = true;
		HashSet<Integer> neighbours = graph.getOrDefault(v, new HashSet<>());
		Iterator<Integer> it = neighbours.iterator();
		while (it.hasNext()) {
			int neighbour = it.next();
			//System.out.println("neighbour: " + neighbour);
			if (!visited[neighbour]) {
				toposort(neighbour);
			}
		}
		topo.add(v);
	}

	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // number of pandas
		m = sc.nextInt(); // number of matches
		int highest = 0; // highest number of wins yet
		int v = 0; // has to be the one with most number of wins
		visited = new boolean[n+1];

		for (int i = 0; i < m; i++) {
			int winner = sc.nextInt();
			int loser = sc.nextInt();
			HashSet<Integer> losers = graph.getOrDefault(winner, new HashSet<>());
			losers.add(loser);
			if (losers.size() > highest) {
				v = winner;
			}
			graph.put(winner, losers);
		}
		
		if (v != 0 && isCyclic(v, visited, new ArrayList<>())) {
			System.out.println("No possible ranking.");
		} else {
			boolean[] allTrue = new boolean[n+1];
			Arrays.fill(allTrue, true);
			allTrue[0] = false;
			if (v == 0 || !Arrays.equals(visited, allTrue)) {
				// either m == 0 or graph not connected
				System.out.println("V: " + v);
				System.out.println(Arrays.toString(visited));
				System.out.println("Ranking is not unique.");
			} else {
				visited = new boolean[n+1];
				for (int i = 1; i <= n; i++) {
					if (!visited[i]) {
						toposort(i);
					}
				}
				Collections.reverse(topo);
				topo.forEach(System.out::println);
			}
		}
	}

	public static void main(String[] args) {
		PandaChess newPandaChess = new PandaChess();
		newPandaChess.run();
	}
}
