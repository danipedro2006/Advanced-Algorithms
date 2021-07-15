package diverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HamiltonianCycle {

	char vertices[];
	int adjMatrix[][];
	int visited[];
	int start;

	Stack<Integer> stack = new Stack<>();

	int N;
	boolean hasCycle = false;

	

	public HamiltonianCycle(int start, char[] vertices, int[][] adjMatrix) {
		this.start = start;
		this.vertices = vertices;
		this.adjMatrix = adjMatrix;
		this.N = vertices.length;
		this.visited = new int[N];
	}

	void findCycle() {
		stack.push(start);
		solve(start);
	}

	private void solve(int vertex) {
		// if vertex is back to start vertex and all nodes are visited return true
		// and display cycle

		if (vertex == start && stack.size() == N + 1) {
			hasCycle = true;
			displayCycle();

			// if not continue to explore more hamiltonian cycles
			return;

			// iterate through neighbor vertex to find cycle
		}

		for (int i = 0; i < N; i++) {

			if (adjMatrix[vertex][i] == 1 && visited[i] == 0) {
				int neighbor = i;
				
				//visit and add vertex to stack
				visited[neighbor] = 1;
				stack.push(neighbor);
				//goto the neighbor vertex to find cycle
				solve(neighbor);

				// backtrack

				visited[neighbor] = 0;
				stack.pop();

			}
		}
	}

	private void displayCycle() {
		
		List<Character> names=new ArrayList<>();
		for(int index:stack) {
			names.add(vertices[index]);
		}
		System.out.println(names);
		

	}
	
	public static void main(String[] args) {

		char[] vertices= {'A','B','C','D','E','F','G','H'};
		int[][] adjMatrix= {
				{0,1,0,1,0,0,0,1},
				{0,0,1,1,0,0,1,1},
				{0,1,0,1,0,1,0,1},
				{0,0,0,1,1,0,0,1},
				{0,1,0,1,0,0,0,1},
				{0,1,0,1,0,0,0,1},
				{0,0,0,1,1,1,1,1},
				{0,0,0,1,1,0,0,1}
				};
		
		HamiltonianCycle hamiltonian=new HamiltonianCycle(0, vertices, adjMatrix);
		hamiltonian.findCycle();
		if(!hamiltonian.hasCycle) {
			System.out.println("No hamiltonian cycle");
		}
		
		}
}
