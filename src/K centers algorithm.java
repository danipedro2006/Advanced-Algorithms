package problems;

import java.util.ArrayList;

public class KCenters {

	public static void main(String[] args) {
		
		int n=4;
		int[][] weights= {
				{0,4,8,5},
				{4,0,10,7},
				{8,10,0,9},
				{5,7,9,0}
		
	};
		
		int k=2;
		select(n, weights, k);

}

	static int maxindex(int[] dist, int n) {
		int mi=0;
		for(int i=0;i<n;i++) {
			if(dist[i]>dist[mi])
				mi=i;
		}
		return mi;
		
	}
	private static void select(int n, int[][] weights, int k) {
		int[] dist=new int[n];
		ArrayList<Integer> centers=new ArrayList<>();
		for(int i=0;i<n;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		int max=0;
		for(int i=0;i<k;i++) {
			centers.add(max);
			for(int j=0;j<n;j++) {
				dist[j]=Math.min(dist[j], weights[max][j]);
			}
			
			//update index of city with  maximum distance to its closest centre
			max=maxindex(dist,n);
		}
		
	}
}
