package diverse;

import java.util.ArrayList;
import java.util.List;

public class GraphColoring {

	static class Vertex {

		// graph is represented by an adjacency list
		String name;
		String color;
		boolean isColored;
		List<Vertex> adjacentVertices;

		public Vertex(String name) {

			this.name = name;
			this.color = "";
			this.isColored = false;
			this.adjacentVertices = new ArrayList<>();
		}

		public void addNeighbor(Vertex vertex) {

			this.adjacentVertices.add(vertex);
			vertex.adjacentVertices.add(vertex);
		}

	}

	static class Coloring {

		String[] colors;
		int colorCount;
		int numOfVeritices;

		public Coloring(String[] colors, int N) {

			this.colors = colors;
			this.numOfVeritices = N;
		}

		public boolean setColors(Vertex vertex) {

			for (int colorIndex = 0; colorIndex < colors.length; colorIndex++) {
				
				if (!canColorWith(colorIndex, vertex))
					continue;
				
				vertex.color = colors[colorIndex];
				vertex.isColored = true;
				colorCount++;

				if (colorCount == numOfVeritices)
					return true;
				
				
				for (Vertex v : vertex.adjacentVertices) {
					if (!v.isColored) {
						if (setColors(v)) 
							return true;
						
					}
				}
			}
			
			// backtrack
			
			vertex.isColored = false;
			vertex.color = "";
			return false;

		}

		private boolean canColorWith(int colorIndex, Vertex vertex) {

			for (Vertex v : vertex.adjacentVertices) {

				if (v.isColored && v.color.equals(colors[colorIndex]))
					return false;
			}
			return true;
		}

		public static void main(String[] args) {

			Vertex vertices[] = { new Vertex("A"), new Vertex("B"), new Vertex("C"), new Vertex("D") };

			vertices[0].addNeighbor(vertices[1]);
			vertices[1].addNeighbor(vertices[2]);
			vertices[2].addNeighbor(vertices[3]);
			vertices[0].addNeighbor(vertices[3]);

			String[] colors = { "Red", "Blue" };

			Coloring colorGraph = new Coloring(colors, vertices.length);

			boolean hasSolution = colorGraph.setColors(vertices[0]);

			if (!hasSolution) {

				System.out.println("No solution");

			} else {

				for (Vertex v : vertices) {

					System.out.println(v.name + " " + v.color);
				}
			}

		}
	}
}