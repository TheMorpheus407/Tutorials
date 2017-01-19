
public class ListElement {
	String s;
	ListElement next;
	
	public ListElement(String s)
	{
		this.s = s;
		next = null;
	}
	
	public boolean hasNext()
	{
		if(this.next == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}