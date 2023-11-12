import java.util.Scanner;

public class Solution 
{
    public void transpose(int[][] arr, int n) 
	{
        for (int i = 0; i < n; i++) 
		{
            for (int j = i + 1; j < n; j++) 
			{
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        if (input.equals("[[]]")) {
            System.out.println("[[]]");
        } 
		else 
		{
            String[] elements = input.substring(2, input.length() - 2).split("], \\[");
            int n = elements.length;
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) 
			{
                String[] row = elements[i].split(", ");
                for (int j = 0; j < n; j++) 
				{
                    arr[i][j] = Integer.parseInt(row[j]);
                }
            }

            Solution solution = new Solution();
            solution.transpose(arr, n);

            System.out.print("[");
            for (int i = 0; i < n; i++) 
			{
                System.out.print("[");
                for (int j = 0; j < n; j++) 
				{
                    System.out.print(arr[i][j]);
                    if (j < n - 1) 
					{
                        System.out.print(", ");
                    }
                }
                System.out.print("]");
                if (i < n - 1) 
				{
                    System.out.print(", ");
                }
            }
            System.out.print("]");
        }
    }
}
