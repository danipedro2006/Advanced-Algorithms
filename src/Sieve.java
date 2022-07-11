package problems;

public class Sieve {

	public static void main(String[] args) {
		
		int max=1000;
		
		boolean[] isPrime=new boolean[max+1];
		
		for(int i=0;i<max+1; i++) {
			isPrime[i]=true;//assume that all numbers are prime
		}
		
		isPrime[0]=isPrime[1]=false;//0 and 1 are not primes
		// to compute all primes we have to rule out all multiples of all integers less than square root of max
		int n=(int) Math.sqrt(max);
		
		// for each integer from 0 to n
		
		for(int i=0;i<=n;i++) {
			if(isPrime[i])
			//rule out all multiples of odd numbers
			//odd numbers of form 2*j+1, for j=1 to max
			
			for(int j=2*i;j<max;j=j+i) {
				isPrime[j]=false;
			}
		}
		
		//print primes
		
		for(int i=0;i<max;i++) {
			if(isPrime[i])
				System.out.println(i);
		}
	}

}
