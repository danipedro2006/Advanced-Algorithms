package problems;

public class CyclicPerm {

	public static int countDigits(int n) {
		int count = 0;
		while (n > 0) {
			count++;
			n = n / 10;
		}
		return count;
	}

	public static void cyclic(int N) {
		int num = N;
		int n = countDigits(N);
		while (true) {
			System.out.println(num);
			int rem = num % 10;
			int dev = num / 10;
			num = (int) ((Math.pow(10, n - 1))) * rem + dev;

			if (num == N)
				break;
		}
	}

	public static void main(String[] args) {

		int n = 1234;
		cyclic(n);
	}

}
