import java.util.Scanner;
import java.util.Arrays;

public class Solution 
{
    public int[] reverse(int[] array) 
	{
        int length = array.length;
        int[] reversed = new int[length];

        for (int i = 0; i < length; i++) 
		{
            reversed[i] = array[length - 1 - i];
        }

        return reversed;
    }

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        int[] arr = new int[s.length];

        if (s.length == 1 && s[0].isEmpty()) arr = new int[]{};
            
        else
		{
            for (int i = 0; i < s.length; ++i)
                arr[i] = Integer.parseInt(s[i]);
        }

        int[] res = new Solution().reverse(arr);
        System.out.print("[");
        for (int i = 0; i < res.length; ++i)
		{
            System.out.print(res[i]);
            if (i != s.length - 1) System.out.print(", ");
        }
        System.out.print("]");
    }
}
