//extended Euclidean algorithm updates results of gcd(a, b) using the results 
//calculated by recursive call gcd(b%a, a). 
//Let values of x and y calculated by the recursive call be x1 and y1. 
//x and y are updated using the below expressions. 
//x = y1 - ⌊b/a⌋ * x1
//y = x1
// Java program to demonstrate working of extended
// Euclidean Algorithm
 
import java.util.*;
import java.lang.*;
 
class GFG
{
    // extended Euclidean Algorithm


    public static int gcdExtended(int a, int b, int x, int y)
    {
        // Base Case
        if (a == 0)
        {
            x = 0;
            y = 1;
            return b;
        }
 
        int x1=1, y1=1; // To store results of recursive call

        int gcd = gcdExtended(b%a, a, x1, y1);
 
        // Update x and y using results of recursive  // call
        
	x = y1 - (b/a) * x1;
           y = x1;
 
        return gcd;
    }
 
// Driver Program

    public static void main(String[] args)
    {
        int x=1, y=1;
        int a = 35, b = 15;
        int g = gcdExtended(a, b, x, y);

        System.out.print("gcd(" + a +  " , " + b+ ") = " + g);
 
    }
}