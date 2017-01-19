import java.util.ArrayList;


public class Zustand {
	ArrayList<Zustand> out = new ArrayList<Zustand>();
	ArrayList<Double> outWahrscheinlichkeit = new ArrayList<Double>();

	public double traverse(Zustand to)
	{
		if(out.size() != outWahrscheinlichkeit.size())
		{
			return 0;
		}
		for(int i = 0; i < out.size(); i++)
		{
			if(to == out.get(i))
			{
				return outWahrscheinlichkeit.get(i);
			}
		}
		return 0;
	}
}
