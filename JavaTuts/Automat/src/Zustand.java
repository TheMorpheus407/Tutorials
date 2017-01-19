
public class Zustand {
	int nummer;
	
	public Zustand()
	{
		nummer = 0;
	}
	
	public int input(int in)
	{
		switch(nummer)
		{
		case 0:
			if(in == 0)
			{
				return 1;
			}
			else
			{
				nummer = 1;
				return 0;
			}
		case 1:
			if(in == 1)
			{
				nummer = 2;
			}
			return in;
		case 2:
			if(in == 0)
			{
				nummer = 0;
			}
			return 1;
		default:
			System.out.println("error");
			return -1;
		}
	}

}
