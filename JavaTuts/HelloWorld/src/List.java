
public class List {
	ListElement start;
	
	public List()
	{
		start = new ListElement("Kopf");
	}
	
	public void insertLast(String s)
	{
		ListElement newEle = new ListElement(s);
		start.next = newEle;
	}
	
	public String get(int n)
	{
		if(findIndex(n) == null)
		{
			return "";
		}
		return findIndex(n).s;
	}
	
	public void delete(int n)
	{
		if(n < 1)
		{
			return;
		}
		ListElement nth = findIndex(n);
		if(nth == null)
		{
			return;
		}
		/*  pre -> nth -> succ  
		 *      --------->
		 * */
		
		ListElement pre = findIndex(n-1);
		pre.next = nth.next;
		
	}
	
	private ListElement findIndex(int n)
	{
		if(n < 0)
		{
			return null;
		}
		ListElement iterator = start;
		for(int i = 0; i < n; i++)
		{
			if(iterator.hasNext())
			{
				iterator = iterator.next;
			}
			else
			{
				return null;
			}
		}
		return iterator;
	}
}
