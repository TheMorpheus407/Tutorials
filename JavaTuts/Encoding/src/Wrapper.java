
public class Wrapper {
	int amount;
	char digit;
	
	@Override
	public String toString() {
		String ret = "";
		for(int i = 0; i < amount; i++)
		{
			ret += digit;
		}
		return ret;
	}
}
