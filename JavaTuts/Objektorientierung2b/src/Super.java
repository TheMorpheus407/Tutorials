import java.util.Iterator;

public class Super {
	private int x = 5;
	static int y = 10;
	
	public class B implements Iterator<Super>
	{
		int z = x;
		
		public int getX()
		{
			return x;
		}

		public void foo() {
			x++;
		}
	}
}
