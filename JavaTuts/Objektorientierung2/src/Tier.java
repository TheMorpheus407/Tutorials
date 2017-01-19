
public class Tier {
	private int beine = 1;
	
	public void macheDichBemerkbar(){
		System.out.println("Tier");
	}
	
	public void doSth(int i)
	{
		System.out.println(i);
		if(i == 0)
		{
			return;
		}
		this.doSth(i-1);
	}
	
	public int getBeine()
	{
		return this.beine;
	}
	
	private void lassBeineWachsen()
	{
		this.beine++;
	}
}
