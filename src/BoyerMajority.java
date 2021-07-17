package diverse;

public class BoyerMajority {

	public static void main(String[] args) {
		int[] array= {1,8,7,4,1,2,2,2,2};
		System.out.println(findMajority(array));
	}

	private static int findMajority(int[] array) {
		int m=-1;
		int count=0;
		
		for(int i=0;i<array.length;i++) {
			if(count==0) {
				m=array[i];
				count=1;
			}
			else if 
				(array[i]==m) {
					m=array[i];
					count++;
			}
			
			 
			else {
				count--;
			}
		}
		
		return m;
		 
		
	}

}
