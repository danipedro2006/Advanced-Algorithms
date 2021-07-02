
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {

	static int[][] adjmatrix = {{ 0, 1, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 0, 0, 1, 0 }};

	static Queue<Integer> q = new PriorityQueue<Integer>();

	static boolean[] visited = new boolean[adjmatrix.length];

	static void BFS(int[][] adjm, int start) {

		visited[start] = true;
		int[] distances = new int[adjm.length];
		q.add(start);

		while (!q.isEmpty()) {
			int node = q.remove();
			for (int i = 1; i < adjm[node].length; i++) {
				if (adjm[node][i] == 1 && !visited[i]) {
					visited[i] = true;
					System.out.println(node + 1);
					distances[i] = distances[node] + 1;
					q.add(i);
				}
			}

		}
		System.out.println(Arrays.toString(distances));
	}

	public static void main(String[] args) {

		BFS(adjmatrix, 0);

	}
}