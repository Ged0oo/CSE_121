import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] elements = input.replaceAll("\\[|\\]", "").split(",");
        int sumEvens = 0, sumOdds = 0;
        for (String element : elements) 
		{
            element = element.trim();
            if (!element.isEmpty()) 
			{
                int num = Integer.parseInt(element);
                if (num % 2 == 0) sumEvens += num;
				else sumOdds += num;
            }
        }
        System.out.println("[" + sumEvens + ", " + sumOdds + "]");
    }
}
