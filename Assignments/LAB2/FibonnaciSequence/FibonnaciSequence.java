import java.util.Scanner;

public class Fibonacci {
    public static int findNthFibonacci(int n) 
	{
        if (n <= 0) return 0;
        else if (n == 1) return 0;
            
        int first = 0;
        int second = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) 
		{
            result = first + second;
            first = second;
            second = result;
        }

        return first;
    }

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 1 || n > 40) 
		{
            System.out.println("Invalid");
        } 
		else 
		{
            int nthFibonacci = findNthFibonacci(n);
            System.out.println(nthFibonacci);
        }
    }
}
