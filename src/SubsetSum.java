package backtraking;

public class SubsetSum {
//Given a set of n distinctive numbers, find a subset whose elements is m
//1. generate power set 2^n possibilities
//2.Backtracking algorithm
	
		
	private static boolean findSum(int[] array,int n, int sum) {
		if(sum==0)return true;
		if(n==0 && sum !=0) return false;
		if(array[n-1]>sum) return findSum(array, n-1, sum);
		
		if(findSum(array, n-1, sum)) { 
			
		return true;
		}
		
		else {
			
			return findSum(array, n-1, sum-array[n-1]);
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] array= {8,3,2,5};// sum=20, res [8,3,2]
		int n=array.length;
		int sum=12;
//		int counter=0;
//		for(int i=0;i<2;i++) {
//			for(int j=0;j<2;j++) {
//				for(int k=0;k<2;k++) {
//					{
//						if(i*array[0]+j*array[1]+k*array[2]==sum) {
//							System.out.println(i+" "+j+" "+k);
//						counter++;
//						
//					}
//				}
//			}
//		}
//	}
	boolean res= findSum(array, n, sum );
	System.out.println(res);

}


}