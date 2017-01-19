import java.util.ArrayList;


public class Main {
	public static Zustand aktuell;
	public static void main(String args[])
	{
		Zustand sonne = new Zustand();
		Zustand wolken = new Zustand();
		Zustand regen = new Zustand();
		
		sonne.out.add(sonne);
		sonne.out.add(wolken);
		sonne.out.add(regen);
		wolken.out.add(sonne);
		wolken.out.add(wolken);
		wolken.out.add(regen);
		regen.out.add(sonne);
		regen.out.add(wolken);
		regen.out.add(regen);
		
		sonne.outWahrscheinlichkeit.add(0.8);
		sonne.outWahrscheinlichkeit.add(0.1);
		sonne.outWahrscheinlichkeit.add(0.1);

		wolken.outWahrscheinlichkeit.add(0.2);
		wolken.outWahrscheinlichkeit.add(0.6);
		wolken.outWahrscheinlichkeit.add(0.2);

		regen.outWahrscheinlichkeit.add(0.3);
		regen.outWahrscheinlichkeit.add(0.3);
		regen.outWahrscheinlichkeit.add(0.4);
		ArrayList<Zustand> f = new ArrayList<Zustand>();
		f.add(regen);
		f.add(sonne);
		f.add(sonne);
		System.out.println(Main.folge(f));
	}
	
	public static double folge(ArrayList<Zustand> zustandsfolge)
	{
		double wkeit = 1;
		Main.aktuell = zustandsfolge.get(0);
		
		for(int i = 1; i < zustandsfolge.size(); i++)
		{
			wkeit = wkeit * aktuell.traverse(zustandsfolge.get(i));
			Main.aktuell = zustandsfolge.get(i);
		}
		
		return wkeit;
	}
}
