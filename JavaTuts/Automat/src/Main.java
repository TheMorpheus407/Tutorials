
public class Main {

	public static void main(String[] args) {
		Zustand z = new Zustand();
		
		String s = new String("0101010101110001010");
		for(int i = 0; i < s.length(); i++)
		{
			System.out.print(z.input(Character.getNumericValue(s.charAt(i))));
		}
	}

}
