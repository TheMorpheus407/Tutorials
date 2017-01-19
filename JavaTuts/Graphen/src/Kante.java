import java.util.ArrayList;


public class Kante {
	int ausgang;
	int eingang;
	int weight = 0;
	
	public Kante(int in, int out, ArrayList<Integer> knoten)
	{
		if(knoten.contains(in) || knoten.contains(out))
		{
			ausgang = out;
			eingang = in;
		}
		else
		{
			throw new Error("keine Knoten vorhanden.");
		}
	}
	public Kante(int in, int out, ArrayList<Integer> knoten, int weight)
	{
		if(knoten.contains(in) || knoten.contains(out))
		{
			ausgang = out;
			eingang = in;
			this.weight = weight;
		}
		else
		{
			throw new Error("keine Knoten vorhanden.");
		}
	}
}
