package problems;

import java.util.ArrayList;

public class DFSAdj {
	
	static ArrayList<Node> nodes=new ArrayList<>();
	
	static class Node {
		int data;
		boolean visited;
		
		Node(int data){
			this.data=data;
		}
		
		
	}
	
	public ArrayList findNeighbours(int adjMatrix[][], Node x) {
		int nodeIndex=-1;
		ArrayList<Node> neighbours=new ArrayList<>();
		
		for(int i=0;i<nodes.size();i++) {
			if(nodes.get(i).equals(x)) {
				nodeIndex=i;
				break;
			}
		}
		
		if(nodeIndex!=-1) {
			for(int j=0;j<adjMatrix[nodeIndex].length;j++) {
				if(adjMatrix[nodeIndex][j]==1) {
					neighbours.add(nodes.get(j));
				}
			}
		}
		return neighbours;
		
	}
	
	public void DFS(int[][] matrix, Node node) {
		
		System.out.println(node.data+"\t");
		
		ArrayList<Node> neighbours= findNeighbours(matrix, node);
		node.visited=true;
		for(int i=0;i<neighbours.size();i++) {
			Node n=neighbours.get(i);
			
			if(n!=null && !n.visited) {
				
				DFS(matrix,n);
			}
		}
		
	}
	public static void main(String[] args) {
		
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node4=new Node(4);
		Node node5=new Node(5);
		Node node7=new Node(7);
		Node node8=new Node(8);
		Node node3=new Node(3);
		Node node6=new Node(6);
		
		//store nodes in the arraylist
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node4);
		nodes.add(node5);
		nodes.add(node7);
		nodes.add(node8);
		nodes.add(node3);
		nodes.add(node6);
		
		int[][] matrix= {
				
				{0,1,0,0,0,0,1,0},
				{1,0,1,1,0,0,0,0},
				{0,1,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0},
				{0,0,0,1,0,0,0,0},
				{0,0,0,1,0,0,0,0},
				{1,0,0,0,0,0,0,1},
				{0,0,0,0,0,0,1,0}
		};
		
		DFSAdj dfs=new DFSAdj();
		
		dfs.DFS(matrix, node1);
	}

}
