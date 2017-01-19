
public class Node {
	public Node links;
	public Node rechts;
	public int wert;
	public Node parent;
	
	public Node(int i, Node parent)
	{
		this.wert = i;
		this.parent = parent;
	}
	
	public int hoehe()
	{
		int l = 0;
		int r = 0;
		if(this.links != null)
		{
			l = this.links.hoehe() + 1;
		}
		if(this.rechts != null)
		{
			r = this.rechts.hoehe() + 1;
		}
		return Math.max(l, r);
	}
}
