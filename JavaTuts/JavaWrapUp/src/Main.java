
public class Main {

	public static void main(String[] args) {
		int v = 0;
		boolean b = false;
		char c = 'c';
		String s = new String("hello world");
		int c2 = (int)c;
		System.out.println("Hello World " + c2);
		

		int[] array = new int[42];
		for(int i = 0; i < 42; i++)
		{
			array[i] = i;
		}
		
		Main m = new Main();
		System.out.println(m.toString());
	}
	private int i;
	
	public int getI()
	{
		return i;
	}
	
	public void setI(int i)
	{
		if(i != 42)
		{
			return;
		}
		else
		{
			this.i = i;
		}
	}
	
	public Main get()
	{
		return this;
	}
	
	@Override
	public String toString()
	{
		return "Main und i = " + i; 
	}
}
