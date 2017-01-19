public class Fifo {
	private Element first = null;
	
	public String pop()
	{
		if(first == null)
		{
			return null;
		}
		String ret = first.current;
		this.first = this.first.next;
		return ret;
	}
	
	public void push(String s)
	{
		if(first == null)
		{
			first = new Element(s);
		}
		else
		{
			Element iterator = first;
			while(iterator.next != null)
			{
				iterator = iterator.next;
			}
			iterator.next = new Element(s);
		}
	}
}
