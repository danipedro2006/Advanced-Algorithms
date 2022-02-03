package problems;

public class DFS {

	static class GraphAM {

		static int[][] adjmatrix;
		static int numvertices;

		public GraphAM(int numvertices) {

			this.numvertices = numvertices;
			adjmatrix = new int[numvertices][numvertices];
		}

		public void addEdge(int u, int v) {
			adjmatrix[u][v] = 1;
			adjmatrix[v][u] = 1;

		}

		void printmatrix(int[][] adjmatrix) {

			for (int i = 0; i < numvertices; i++) {

				for (int j = 0; j < numvertices; j++) {
					System.out.print(adjmatrix[i][j]);
				}
				System.out.println();
			}
		}

		static void DFS(int startvertex, boolean[] visited) {

			visited[startvertex] = true;

			System.out.println(startvertex);

			for (int i = 0; i < numvertices; i++) {
				if (adjmatrix[startvertex][i] == 1 && visited[i] == false) {
					DFS(i, visited);
				}
			}
		}

		public static void main(String[] args) {
			GraphAM g = new GraphAM(5);
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(0, 3);
			g.addEdge(0, 4);
			g.printmatrix(adjmatrix);
			boolean[] visited = new boolean[numvertices];
			for (int i = 0; i < numvertices; i++)
				visited[i] = false;
			DFS(0, visited);
		}

	}
}
