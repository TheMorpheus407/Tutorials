import java.util.ArrayList;

public class Main {
	public static double k = 5;

	public static void main(String[] args) {
		ArrayList<DataObject> objs = new ArrayList<DataObject>();
		objs.add(new DataObject(5, 1, 0));
		objs.add(new DataObject(6, 1, 0));
		objs.add(new DataObject(5, 2, 0));
		objs.add(new DataObject(6, 2, 0));
		objs.add(new DataObject(7, 1, 0));
		objs.add(new DataObject(0, 4, 1));
		objs.add(new DataObject(1, 4, 1));
		objs.add(new DataObject(0, 5, 1));
		objs.add(new DataObject(1, 5, 1));
		DataObject o = new DataObject(25, 25);
		
		k = Math.sqrt(10);

		System.out.println(parzen(o, objs));
	}

	public static int parzen(DataObject o, ArrayList<DataObject> objs) {
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < objs.size(); i++)
		{
			if(distance(o, objs.get(i)) < k)
			{
				if(objs.get(i).klasse == 0)
				{
					a++;
				}
				else
				{
					b++;
				}
			}
		}
		
		if(a > b)
		{
			return 0;
		}
		else if(a == b)
		{
			return -1;
		}
		else
		{
			return 1;
		}
		
	}

	public static double distance(DataObject o, DataObject ref) {
		return (o.x - ref.x) * (o.x - ref.x) + (o.y - ref.y) * (o.y - ref.y);
	}
}
