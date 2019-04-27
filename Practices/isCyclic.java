import java.util.*;

class isCyclic {
	int n;
	boolean[] visited;
	HashMap<Integer, ArrayList<Integer>> neighbours = new HashMap<>();
	boolean flag = false;

	// start with parent = -1
	public boolean isCyclic(int v, boolean[] visited, int parent) {
		visited[v] = true;
		for (int neighbour: neighbours.getOrDefault(v, new ArrayList<>())) {
			if (!visited[neighbour]) {
				//System.out.println("first time visiting: " + neighbour);
				visited[neighbour] = true;
				if (flag) {
					break;
				}
				isCyclic(neighbour, visited, v);
			} else {
				//System.out.println("I'm visiting my parent " + parent);
				if (neighbour != parent) {
					//System.out.println("oh no " + neighbour + " is not my parent");
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n+1]; // assuming 1-base, n = #vertices
		int e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int v = sc.nextInt();
			int u = sc.nextInt();
			ArrayList<Integer> list = neighbours.getOrDefault(v, new ArrayList<>());
			list.add(u);
			neighbours.put(v, list);

			ArrayList<Integer> list2 = neighbours.getOrDefault(u, new ArrayList<>());
			list2.add(v);
			neighbours.put(u, list2);
		}
		System.out.println(isCyclic(1, visited, -1));
	}

	public static void main(String[] args) {
		isCyclic cyclic = new isCyclic();
		cyclic.run();
	}
}
