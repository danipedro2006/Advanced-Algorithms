package problems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class pancakeSort {
	
	public static void flip(int[] arr, int k) {
		int left=0;
		while(left<k) {
			int temp=arr[left];
			arr[left]=arr[k];
			arr[k]=temp;
			k--;
			left++;
		}
	}
	
	public static int maxIndex(int[] arr, int k) {
		int index=0;
		for(int i=0;i<k;i++) {
			if(arr[i]>arr[index]) {
				index=i;
			}
		}
		return index;
	}
	
	public static void pancakeSort(int[] arr) {
		int maxindex;
		int n=arr.length;
		while(n>1) {
			maxindex=maxIndex(arr, n);
			if(maxindex!=n) {
				flip(arr, maxindex);
				flip(arr, n-1);
			}
			n--;
		}
	}

	public static void main(String[] args) {
		int[] array= {3,5,1,6,7,8,2};
		System.out.println(Arrays.toString(array));
		
		pancakeSort(array);
		System.out.println(Arrays.toString(array));
	}

}
