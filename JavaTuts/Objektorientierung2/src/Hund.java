
public class Hund extends Tier{
	private int beine = 5;

	@Override
	public void macheDichBemerkbar() {
		System.out.println("Wuff");
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
