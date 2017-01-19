import java.util.ArrayList;


public class Laufzeit {
	public void KonstanteLZ(ArrayList<String> s)
	{
		int x = 1+1;
	}

	public void lineareLZ(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			a[i] = 5;
		}
	}
	
	public void quadratischeLZ(ArrayList<String> s)
	{
		for(int i = 0; i < s.size(); i++)
		{
			s.set(i, "abc");
		}
	}
	
	public void logarithmischeLZ(ArrayList<String> s)
	{
		
	}
	
	public int exponentielleLZ(int i)
	{
		return exponentielleLZ(i-1) + exponentielleLZ(i-2);
	}
	
	
}
