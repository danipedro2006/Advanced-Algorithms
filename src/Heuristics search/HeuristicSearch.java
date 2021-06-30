package diverse;

import java.util.ArrayList;
import java.util.List;

public class HeuristicSearch {
	static class Node {
		private Integer element;
		private boolean visited;
		private List<Node> neighbours;
		private int index;
		
		public Node(Integer element, int index) {
			this.element = element;
			this.index = index;
			this.neighbours=new ArrayList<>();
		}
		
		public int getElement() {
			return element;
		}
						
		public void setElement(Integer element) {
			this.element = element;
		}
		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean visited) {
			this.visited = visited;
		}
		public List<Node> getNeighbors() {
			return neighbours;
		}
		public void setNeighbors(Node n) {
			this.neighbours.add(n);
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}

		
	}
	static class Graph{
		private List<Node> allNodes;
		private int nodeMaxNo;
		private double[][] weights;
		
		public Graph (int n) {
			this.allNodes=new ArrayList<>();
			this.nodeMaxNo=n;
			this.weights=new double[this.nodeMaxNo][this.nodeMaxNo];
		}

		public List<Node> getAllNodes() {
			return allNodes;
		}

		public void setAllNodes(List<Node> allNodes) {
			this.allNodes = allNodes;
		}

		
		public double getWeights(int rowNo, int colNo) {
			
			return this.weights[rowNo][colNo];
		}

		public void setWeights(int rowNo, int colNo, int value) {
			this.weights[colNo-1][rowNo-1] =value;
			this.weights[rowNo-1][colNo-1] =value;
		}
	}
	
	static class Heuristics{
		public void search (Graph g) {
			List<Node> nodeList=g.getAllNodes();
			Node root=nodeList.get(0);
			List<Node> neighbours=null;
			
			do {
				neighbours=root.getNeighbors();
				System.out.println(root.getElement());
				double min=Integer.MAX_VALUE;
				int idx=1;
				for(Node n:neighbours) {
					double cost =g.getWeights(root.getIndex()-1,n.getIndex()-1);
					if(cost<min) {
						min=cost;
						idx=n.getIndex();
					}
				}
				
				root=nodeList.get(idx);
				
			} while (neighbours.isEmpty()==false);
		}
	}
	public static void main(String[] args) {
		
		Graph g=new Graph(7);
		Node n1=new Node(1,1);
		Node n2=new Node(2,2);
		Node n3=new Node(3,1);
		Node n4=new Node(4,4);
		Node n5=new Node(5,5);
		Node n6=new Node(6,4);
		Node n7=new Node(7,3);
		
		n1.setNeighbors(n2);
		g.setWeights(1, 2, 10);
		n1.setNeighbors(n3);
		g.setWeights(2, 5, 3);
		
		n2.setNeighbors(n4);
		g.setWeights(2, 4, 1);
		n2.setNeighbors(n7);
		g.setWeights(2, 5, 3);
		
		n3.setNeighbors(n6);
		g.setWeights(3, 6, 20);
		n3.setNeighbors(n7);
		g.setWeights(3, 7, 40);
		
		List<Node> allNodes=new ArrayList<>();
		allNodes.add(n1);
		allNodes.add(n2);
		allNodes.add(n3);
		allNodes.add(n4);
		allNodes.add(n5);
		allNodes.add(n6);
		allNodes.add(n7);
		g.setAllNodes(allNodes);
		Heuristics h=new Heuristics();
		h.search(g);
	}

}
