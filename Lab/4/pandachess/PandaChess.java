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
	int[] indeg;
	Queue<Integer> queue = new LinkedList<>();

	private boolean isCyclic() {
		// queue the vertices with indeg 0
		// remove them from graph; ie set their indeg to -1 and indeg of their neighbours--
		// if no one else has indeg 0, there is a cycle
		// else queue those with indeg 0
		//System.out.println(Arrays.toString(indeg));
		while (!queue.isEmpty()) {
			int u = queue.poll();
			HashSet<Integer> losers = graph.getOrDefault(u, new HashSet<>());
			Iterator<Integer> it = losers.iterator();
			while (it.hasNext()) {
				int neighbour = it.next();
				indeg[neighbour]--;
				if (indeg[neighbour] == 0) {
					queue.offer(neighbour);
				}
			}
			indeg[u] = -1;
		}
		int[] empty = new int[n+1];
		Arrays.fill(empty, -1);
		//System.out.println(Arrays.toString(indeg));
		if (!Arrays.equals(indeg, empty)) {
			// means not all removed from graph
			return true;
		} else {
			return false;
		}
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
		indeg = new int[n+1];
		Arrays.fill(indeg, -1);
		int count = 0;

		for (int i = 0; i < m; i++) {
			int winner = sc.nextInt();
			int loser = sc.nextInt();
			if (indeg[winner] == -1) indeg[winner] = 0;
			if (indeg[loser] == -1) indeg[loser] = 0;
			HashSet<Integer> losers = graph.getOrDefault(winner, new HashSet<>());
			int originalSize = losers.size();
			losers.add(loser);
			indeg[loser] += (losers.size() - originalSize);
			if (losers.size() > highest) v = winner;
			graph.put(winner, losers);
		}
		
		if (v != 0) {
			int[] indegree = new int[n+1];
			for (int i = 1; i < n + 1; i++) {
				indegree[i] = 0;
			}

			// setting indegree for all vertices
			for (int i = 1; i < n + 1; i++) {
				HashSet<Integer> neighbours = graph.getOrDefault(i, new HashSet<>());
				for (Iterator<Integer> it = neighbours.iterator(); it.hasNext();) {
					int neighbour = it.next();
					indegree[neighbour]++;
				}
			}

			// adding all vertices with indegree 0 inside q
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i < n + 1; i++) {
				if (indegree[i] == 0) {
					q.add(i);
				}
			}
			
			boolean noUniqueTopo = false;

			//run bfs
			while (!q.isEmpty()) {
				int vertex = q.poll();
				if (!q.isEmpty()) noUniqueTopo = true;
				HashSet<Integer> neighbours = graph.getOrDefault(vertex, new HashSet<>());
				for (Iterator<Integer> it = neighbours.iterator(); it.hasNext(); ) {
					int neighbour = it.next();
					if (indegree[neighbour] > 0) indegree[neighbour]--;
					if (indegree[neighbour] == 0) q.add(neighbour);
				}
			}

			//System.out.println(Arrays.toString(indeg));

			for (int i = 1; i <= n; i++) {
				if (indeg[i] == 0) {
					count++;
					queue.offer(i);
				}
			}
			
			//System.out.println("count: " + count);
			if (count == 0 || isCyclic()) {
				System.out.println("No possible ranking.");
			} else if (count > 1 || noUniqueTopo) { // not connected 
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
		} else {
			System.out.println("Ranking is not unique.");
		}
	}

	public static void main(String[] args) {
		PandaChess newPandaChess = new PandaChess();
		newPandaChess.run();
	}
}
