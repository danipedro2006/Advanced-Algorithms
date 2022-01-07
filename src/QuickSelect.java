// Returns the k'th smallest element in the list within `left…right`
    // (i.e., `left <= k <= right`). The search space within the array is
    // changing for each round – but the list is still the same size.
    // Thus, `k` does not need to be updated with each round.
    public static int quickSelect(int[] A, int left, int right, int k)
    {
        // If the array contains only one element, return that element
        if (left == right) {
            return A[left];
        }
 
        // select a `pIndex` between left and right
        int pIndex = rand(left, right);
 
        pIndex = partition(A, left, right, pIndex);
 
        // The pivot is in its final sorted position
        if (k == pIndex) {
            return A[k];
        }
 
        // if `k` is less than the pivot index
        else if (k < pIndex) {
            return quickSelect(A, left, pIndex - 1, k);
        }
 
        // if `k` is more than the pivot index
        else {
            return quickSelect(A, pIndex + 1, right, k);
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { 7, 4, 6, 3, 9, 1 };
        int k = 2;
 
        System.out.print("k'th smallest element is " +
                quickSelect(A, 0, A.length - 1, k));
    }
}