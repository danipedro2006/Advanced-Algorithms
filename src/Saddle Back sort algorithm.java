public class SaddleBack
{  
/* The function searchElement will search for the element
,if found it will print the index of the element else will return false 
all will print "Element not found". */

 private static void searchElement(int TwoDiArray[][], int row, int col, int ele) { 
      
    /* set indexes so as to start searching from bottomleft element */
    
    int i = row - 1, j = 0;
    int flag = 0;  
        while (i >= 0 && j < col) 
        { 
            if (TwoDiArray[i][j] == ele) {
                System.out.println("Element found at index: {"+i+", "+j+"}");
                flag = 1;
                 break;
           }
            if (TwoDiArray[i][j] > ele) 
                i--; // moving upward
            else     
                j++; // moving right in the row
        } 
     if(flag == 0) {
          
        System.out.println("Element not found");
}
} 
  
// main function
public static void main(String args[]) { 
 // array declaration and initialization
int TwoDiArray[][] = {{1, 3, 5},
               {7, 9, 11}, 
               {13, 15, 17}}; 
              
searchElement(TwoDiArray, 3, 3, 15); /* passing array, row = 3 , column = 3 and  element = 15*/ 
} 
} 
