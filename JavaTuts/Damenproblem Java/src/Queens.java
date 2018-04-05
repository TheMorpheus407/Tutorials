public class Queens {
	int queens[] = new int[8];
	{
		for(int i = 0; i < queens.length; i++)
		{
			queens[i] = Integer.MIN_VALUE;
		}
	}
	
	public static void main(String[] args)
	{
		new Queens().solve();
	}
	
	public void solve()
	{
		for(int i = 0; i < queens.length; i++)
		{
			queens[i] = 0;
			while(isThread(i) && i <= queens.length)
			{
				queens[i]++;
			}
			i = backtrack(i);
			
			if(i < 0 || i >= queens.length)
				return;
			
			if(i == queens.length -1)
			{
				this.print();
				queens[i]++;
				while(isThread(i) && i <= queens.length)
					queens[i]++;
				i = backtrack(i);
			}
		}
	}
	
	private int backtrack(int start)
	{
		int i = start;
		boolean changed = false;
		
		while(queens[i] >= queens.length || queens[i] < 0)
		{
			i--;
			changed = true;
			if(i < 0)
			{
				return -1;
			}
		}
		
		if(changed)
		{
			do{
				queens[i] = queens[i] + 1;
			}
			while(isThread(i));
			
			for(int j = i + 1; j < queens.length; j++)
				queens[j] = Integer.MIN_VALUE;
			
			if(queens[i] >= queens.length)
				i = backtrack(i);
		}
		return i;
	}

	private boolean isThread(int i)
	{
		for(int j = 0; j < queens.length; j++)
		{
			if(i == j)
				continue;
			if(queens[j] < 0 || queens[j] >= queens.length)
				break;
			if(queens[j] == queens[i])
				return true;
			if(Math.abs(queens[j] - queens[i]) == Math.abs(j -i))
				return true;
		}
		return false;
	}

	private void print()
	{
		System.out.print("[");
		for(int i = 0; i < queens.length; i++)
		{
			System.out.print(" | " + queens[i]);
		}
		System.out.print(" ]\n");
	}
}
