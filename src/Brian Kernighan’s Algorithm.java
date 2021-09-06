class Main
{
    // Function to count the total number of set bits in `n`
    public static int countSetBits(int n)
    {
        // `count` stores the total bits set in `n`
        int count = 0;
 
        while (n != 0)
        {
            n = n & (n - 1);    // clear the least significant bit set
            count++;
        }
 
        return count;
    }
 
    public static void main(String[] args)
    {
        int n = -1;
 
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("The total number of set bits in " + n + " is " +
            countSetBits(n));
    }
}



class Main
{
    // Naive solution to count the total number of set bits in `n`
    public static int countSetBits(int n)
    {
        int count = 0;
        while (n != 0)
        {
            count += (n & 1);    // check last bit
            n >>= 1;
        }
 
        return count;
    }
 
    public static void main(String[] args)
    {
        int n = 16;
 
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("The total number of set bits in " + n + " is " +
                    countSetBits(n));
    }
}