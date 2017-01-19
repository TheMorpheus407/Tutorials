
public class Elefant extends Tier{
	private int beine = 4;

	@Override
	public void macheDichBemerkbar() {
		System.out.println("Törö");
	}

	@Override
	public void doSth(int i) {
		System.out.println("Blubb");
		if(i == 0)
		{
			return;
		}
		super.doSth(i);
	}
	
}
