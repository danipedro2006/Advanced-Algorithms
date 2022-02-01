package problems;

import java.util.Arrays;

public class QuickSort {

	static int partition(int array[], int low, int high) {
		// choose pivot the rightmost element
		int pivot = array[high];

		// pointer for greater element
		int i = low - 1;

		// traverse and compare with pivot

		for (int j = low; j < high; j++) {

			if (array[j] <= pivot) {
				// if element smaller than pivot is found swap-it with
				// greater element pointed by i

				i++;

				// swapt the element at i with element at j
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		// swap the pivot element with the greater element pointed by i
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		// return the position from where partition is done
		return (i + 1);

	}

	static void quicksort(int array[], int low, int high) {
		if (low < high) {

			// find pivot such element smaller are on left and greater on right
			int pi = partition(array, low, high);

			// recursive sort on left of pivot
			quicksort(array, low, pi - 1);

			// recursive sort on right of pivot
			quicksort(array, pi + 1, high);
		}
	}

	static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] data = { 8, 7, 6, 1, 0, 9, 2 };
		print(data);

		int size = data.length;
		QuickSort.quicksort(data, 0, size - 1);
		print(data);
	}

}
