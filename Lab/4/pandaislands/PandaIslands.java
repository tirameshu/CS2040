/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class PandaIslands {

	class Island {
		int number;
		int area;
		int colour;
		ArrayList<Island> neighbours = new ArrayList<>();

		public Island(int number, int area) {
			this.number = number;
			this.area = area;
			this.colour = -1;
		}

		void addNeighbour(Island neighbour) {
			this.neighbours.add(neighbour);
		}
	}

	boolean[] visited;
	Island[] islands;
	int white = 0, black = 0;
	int totalArea = 0;
	// int[] colour;

	private void colouring(Island start) {
		Queue<Island> queue = new LinkedList<>();
		queue.offer(start);
		white += start.area;
		
		while (!queue.isEmpty()) {
			Island island = queue.poll(); // all islands in queue should have colours alr

			for (Island neighbour: island.neighbours) {
				if (!visited[neighbour.number]) {
					visited[neighbour.number] = true;
					if (island.colour == 0) {
						neighbour.colour = 1;
						black += neighbour.area;
						//System.out.println("island " + island.number + " is white and neighbour " + neighbour.number + " is black, with area " + neighbour.area);
					} else {
						neighbour.colour = 0;
						white += neighbour.area;
						//System.out.println("island " + island.number + " is white and neighbour " + neighbour.number + " is black, with area " + neighbour.area);
					}
					queue.offer(neighbour);
				}
			}
		}
	}

	private void run() {
		//implement your "main" method here
		// Run bfs once on an arbitrary source vertex s.
		// Initially, colour[s] = 0. For each of its neighbour, colour[neighbour] = 1
		// Regardless of which vertex you start from, the vertices of the same colour will remain the same.
		// When running bfs(s), track area of the blacks and whites.

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of islands
		int e = sc.nextInt(); // number of bridges
		visited = new boolean[n+1];
		islands = new Island[n+1];
		// colour = new int[n+1];
		// colour[0] = -1;
		
		for (int i = 1; i <= n; i++) {
			int area = sc.nextInt();
			totalArea += area;
			islands[i] = new Island(i, area); // initialised with no. and area 
		}

		for (int i = 0; i < e; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			Island islandA = islands[A];
			Island islandB = islands[B];
			islandA.addNeighbour(islandB);
			islandB.addNeighbour(islandA);
		}

		int min = 0;
		for (int i = 1; i <= n; i++) {
			Island start = islands[i];
			if (!visited[i] && start.colour == -1) {
				start.colour = 0;
				visited[i] = true;
				colouring(start);
				min += Math.min(white, black);
				white = 0; black = 0;
			}
		}
		//System.out.println("total: "  + totalArea);
		//System.out.println("white: " + white);
		//System.out.println("black: " + black);
		System.out.println(min);
		
	}
	public static void main(String[] args) {
		PandaIslands newPandaIslands = new PandaIslands();
		newPandaIslands.run();
	}
}
