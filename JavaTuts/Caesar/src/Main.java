
public class Main {

	public static void main(String[] args) {
		String s = "ich bin uncodiertZ";
		int offset = 2;
		System.out.println(encryptString(s, offset));
	}

	public static String decrypt(String s, int offset)
	{
		String ret = "";
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if((int)c+offset < 97 && false)
			{
				//ret+= (char)((int)c-offset+26);
			}
			else
			{
				ret += (char)((int)c-offset);
			}
		}
		return ret;
	}
	
	public static String encryptString(String s, int offset)
	{
		String ret = "";
		for(int i = 0; i < s.length(); i++)
		{
			ret += encrypt(s.charAt(i), offset);
		}
		return ret;
	}
	
	public static char encrypt(char c, int offset)
	{
		if((int)c+offset > 122 && false)
		{
			//return (char)((int)c+offset-26);
		}
		//else
		{
			return (char)((int)c+offset);
		}
	}
}
