public class ToeplitzMatrix {
    private static boolean isToeplitz(int[][] matrix) {
        boolean ans = true;
        int n = matrix.length;
        int m = matrix[0].length;
        
        // First row diagonals
        for (int i = 0; i < m; i++) {
            int x = 0, y = i;
            int curr = matrix[x][y];
            x++; y++;
            while (x < n && y < m) {
                // If any element is not same, this can't be a toeplitz matrix
                if (matrix[x][y] != curr) {
                    ans = false;
                    break;
                }
                // Increment row and column by 1
                x++; y++;
            }
            if (!ans)
                break;
        }
        // First column diagonals
        for (int i = 1; i < n; i++) {
            int x = i, y = 0;
            int curr = matrix[x][y];
            x++; y++;
            while (x < n && y < m) {
                // If any element is not same, this can't be a toeplitz matrix
                if (matrix[x][y] != curr) {
                    ans = false;
                    break;
                }
                // Increment row and column by 1
                x++; y++;
            }
            if (!ans)
                break;
        }
        return ans;
    }
    public static void main(String[] args) {
        // Example 1
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};
        System.out.println(isToeplitz(matrix));
        // Example 2
        int[][] matrix2 = new int[][] {
                {1, 2},
                {2, 2}
        };
        System.out.println(isToeplitz(matrix2));
    }
}