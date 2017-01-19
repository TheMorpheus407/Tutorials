import java.util.ArrayList;


public class Main {
	public static void main(String[] args)
	{
		ArrayList<Tier> tiere = new ArrayList<Tier>();
		tiere.add(new Hund());
		tiere.add(new Elefant());
		tiere.add(new Tier() {
			@Override
			public void macheDichBemerkbar() {
				System.out.println("Miau");
			}
		});
		
		for(int i = 0; i < tiere.size(); i++)
		{
			//tiere.get(i).macheDichBemerkbar();
		}
		
		Elefant t = new Elefant();
		System.out.println(t.getBeine());
	}
}
