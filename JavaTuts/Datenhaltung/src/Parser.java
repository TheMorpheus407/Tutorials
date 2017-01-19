import java.sql.SQLException;
import java.util.Scanner;

public class Parser {
	
	public static void input(Main m)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Geschäftsvorfall: ");
		String input = scan.nextLine();
		
		String[] inputs = input.split(" ");
		
		int action = Parser.getAction(inputs[0]);
		if(action == 0)
		{
			handlePurchase(inputs, m);
		}
	}
	
	private static void handlePurchase(String[] input, Main m) {
		boolean success = false;
		try {
			success = m.buy(input[1], input[2], Integer.parseInt(input[3]));
		} catch (NumberFormatException e) {
			success = false;
		}
		if(success)
		{
			System.out.println("Der Kauf wurde eingetragen.");
		}
	}

	public static int getAction(String keyword)
	{
		if(keyword.toLowerCase().contains("kauf"))
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}

}
