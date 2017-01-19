
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Difficulty dif = Difficulty.HARD;
		
		switch(dif)
		{
		case HARDCORE: System.out.println("ziemlich hart");
						break;
		default: System.out.println("fuu");
		}
	}

}
