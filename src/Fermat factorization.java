import java.util.*;
public class Fermat_Factorization


public static void FermatFactor(long n)
  {
      long a = (long) Math.ceil(Math.sqrt(n));
      long b = a * a - n;
      while (!isSquare(b))
      {
          a++;
          b = a * a - n;
      }
      long root1 = a - (long)Math.sqrt(b);
      long root2 = n / root1;
  }


public static  boolean isSquare(long n)
   {
       long s = (long) Math.sqrt(n);
       if (s * s == n || (s + 1) * (s + 1) == n)
           return true;
       return false;
   }


public static void main(String[] args) 
   {
       Scanner in = new Scanner(System.in);    
       System.out.println("Enter any odd number");
       long n = in.nextLong();
       Fermat(n);
   }