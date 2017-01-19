public class Sort {

	public static void main(String[] args) {
		int[] zahlen = { 1, 561, 456, 45, 456, 456, 456, 456123, 1, 15, 12,
				154, 51, 21, 57451, 54 };

		zahlen = insertionsSort(zahlen);
		for (int i = 0; i < zahlen.length; i++) {
			System.out.println(zahlen[i]);
		}

	}
	
	public static int[] mergeSort(int[] unsorted)
	{
		if(unsorted.length == 1)
		{
			return unsorted;
		}
		int[] l = new int[(int) Math.floor(unsorted.length / 2)];
		int[] r = new int[(int) Math.ceil(unsorted.length / 2)];
		for(int i = 0; i < unsorted.length; i++)
		{
			if(i < (int) Math.floor(unsorted.length / 2))
			{
				l[i] = unsorted[i];
			}
			else
			{
				r[i - (int) Math.floor(unsorted.length / 2)] = unsorted[i];
			}
		}
		l = mergeSort(l);
		r = mergeSort(r);
		return merge(l, r);
	}
	
	private static int[] merge(int[] l, int[] r) {
		int[] merge = new int[l.length + r.length];
		int i = 0;
		int j = 0;
		for(int k = 0; k < l.length + r.length; k++)
		{
			if(l[i] <= r[j])
			{
				merge[k] = l[i];
				i++;
			}
			else
			{
				merge[k] = r[j];
			}
		}
		return merge;
	}

	public static int[] insertionsSort(int[] unsorted)
	{
		int[] sorted = new int[unsorted.length];
		for(int i = 0; i < unsorted.length; i++)
		{
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < unsorted.length; j++)
			{
				if(min > unsorted[j])
				{
					int k = min;
					min = unsorted[j];
					unsorted[j] = k;
				}
			}
			sorted[i] = min;
		}
		return sorted;
	}

	public static int[] bubblesort(int[] unsorted) {
		boolean isSorted = false;
		while (!isSorted) 
		{
			isSorted = true;
			for (int i = 0; i < unsorted.length - 1; i++)
			{
				if (unsorted[i] <= unsorted[i + 1]) 
				{
					continue;
				}
				isSorted = false;
				int k = unsorted[i];
				unsorted[i] = unsorted[i + 1];
				unsorted[i + 1] = k;
			}
		}
		return unsorted;
	}
}
