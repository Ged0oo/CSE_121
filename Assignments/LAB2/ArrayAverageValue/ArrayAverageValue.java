import java.util.Scanner;

public class Solution 
{
    public double GetAvg(int[] array) 
    {
        int length = array.length;
        if (length == 0) return 0.0;
        int sum = 0;
        for (int i = 0; i < length; i++) sum += array[i];
        double avg = (double) sum / length;
        return avg;
    }

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        int[] arr = new int[s.length];

        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
		
        else 
		{
            for (int i = 0; i < s.length; ++i)
                arr[i] = Integer.parseInt(s[i]);
        }

        double res = new Solution().GetAvg(arr);
        System.out.print(res);
    }
}
