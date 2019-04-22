import java.util.*;
import java.util.List;

class Bipartite {

	HashMap<Integer, List<Integer>> graph = new HashMap<>();
	int vertices, edges;
	boolean visited[];
	int[] colour;
	boolean flag = true;

	void addNeighbour(int v, int u) {
		List<Integer> neighbours = graph.getOrDefault(v, new ArrayList<>());
		neighbours.add(u);
		graph.put(v, neighbours);
	}

	void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			visited[u] = true;
			List<Integer> neighbours = graph.getOrDefault(u, new ArrayList<>());
			if (colour[u] == -1) {
				colour[u] = 0;
			}
			
			int c = colour[u];
			for (int neighbour: neighbours) {
				if (!visited[neighbour]) {
					queue.offer(neighbour);
					visited[neighbour] = true;
				}
				if (colour[neighbour] == c) {
					flag = false;
				} else {
					colour[neighbour] = (c+1) % 2;
				}
			}
		}
	}

	boolean isBipartite() {
		// a bipartite graph need not be connected
		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				bfs(i);
			}
		}
		return flag;
	}								

	public void run() {
		Scanner sc = new Scanner(System.in);
		vertices = sc.nextInt();
		edges = sc.nextInt();
		visited = new boolean[vertices];
		colour = new int[vertices];
		Arrays.fill(colour, -1);

		for (int i = 0; i < edges; i++) {
			int v = sc.nextInt();
			int u = sc.nextInt();
			addNeighbour(v, u);
			addNeighbour(u, v);
		}
		if (isBipartite()) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	public static void main(String[] args) {
		Bipartite bipartite = new Bipartite();
		bipartite.run();
	}
	}
