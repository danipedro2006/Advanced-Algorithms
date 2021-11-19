 /* Java program for   left rotating an array by  
  some d elements */ 


class ArrayRotation { 

    /* Method to  rotate  an array of size n by d elements */

   private void rotateLeft(int array[], int d, int n) 
    { 
        int i, j, m;
         int temp; 
        int g_c_d = HCF(d, n);    // method call to calculate HCF of d and n
// HCF is same as GCD
        for (i = 0; i < g_c_d; i++) { 
            temp = arr[i]; 
            j = i; 
            while (true) { 
                m = j + d; 
                if (m >= n) 
                    m = m - n; 
                if (m == i) 
                    break; 
                arr[j] = arr[m]; 
                j = m; 
            } 
            arr[j] = temp; 
        } 
    } 
  
   
  
    /* method for  printing  an array */
    void printArr(int arr[]) 
    { 
        
        for (int i = 0; i < arr.length(); i++) 
            System.out.print(arr[i] + " "); 
    } 
  
    // method to calculate HCF of d and n
    int HCF(int d, int n) 
    { 
        if (n == 0) 
            return d; 
        else
            return HCF(n,d%n); 
    } 
  
    // main  functions 
    public static void main(String[] args) 
    { 
        ArrayRotation rotate = new ArrayRotation(); 
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; 
        rotate.rotateLeft(arr, 3, 9); 
        rotate.printArr(arr); 
    } 
} 
