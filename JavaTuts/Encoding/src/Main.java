import java.math.BigInteger;


public class Main {

	public static void main(String[] args) {
		Encoder e = new Encoder("Ich bin ein String.");
		
		String text = "";
		for(int i = 0; i < e.list.size(); i++)
		{
			text += e.list.get(i).toString();
		}
		
		System.out.println(new String(new BigInteger(text, 2).toByteArray()));
	}

}
