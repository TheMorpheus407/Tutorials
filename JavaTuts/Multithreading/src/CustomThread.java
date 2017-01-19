public class CustomThread extends Thread {
	String name;
	Blubb blubb;
	boolean flag;

	CustomThread(String s, Blubb b, boolean c) {
		this.name = s;
		blubb = b;
		flag = c;
		
	}

	public void run() {
		System.out.println("Starte Thread " + name);
		for(int i = 0; i < 5; i++)
		{
			if(flag)
			{
				blubb.first();
			}
			else
			{
				blubb.second();
			}
		}
		System.out.println("Beende Thread " + name);
	}
}
