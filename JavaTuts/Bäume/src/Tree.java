
public class Tree {
	Node root;
	
	public Tree()
	{
		root = null;
	}
	
	public void insert(int value)
	{
		if(root == null)
		{
			root = new Node(value, null);
		}
		else
		{
			insert(root, value);
		}
	}

	private void insert(Node parent, int value) 
	{
		if(parent.wert >= value)
		{
			if(parent.links == null)
			{
				parent.links = new Node(value, parent);
			}
			else
			{
				insert(parent.links, value);
				if(parent.links.hoehe() - parent.rechts.hoehe() == 2)
				{
					if(value - parent.links.wert < 0)
					{
						parent = rotateWithLeftChild(parent);
					}
					else
					{
						parent = doubleRotateWithRightChild(parent);
					}
				}
			}
		}
		else
		{
			if(parent.rechts == null)
			{
				parent.rechts = new Node(value, parent);
			}
			else
			{
				insert(parent.rechts, value);
				if(parent.links.hoehe() - parent.rechts.hoehe() == -2)
				{
					if(value - parent.rechts.wert > 0)
					{
						parent = rotateRightLeftChild(parent);
					}
					else
					{
						parent = doubleRotateWithLeftChild(parent);
					}
				}
			}
		}
	}
	
	private Node doubleRotateWithLeftChild(Node k1) {
		k1.rechts = rotateWithLeftChild(k1.rechts);
		return rotateRightLeftChild(k1);
	}

	private Node doubleRotateWithRightChild(Node k3) {
		k3.links = rotateRightLeftChild(k3.links);
		return rotateWithLeftChild(k3);
	}

	private Node rotateRightLeftChild(Node k1) {
		Node k2 = k1.rechts;
		k1.rechts = k2.links;
		k2.links = k1;
		return k2;
	}

	private Node rotateWithLeftChild(Node k2) {
		Node k1 = k2.links;
		k2.links = k1.rechts;
		k1.rechts = k2;
		return k1;
	}

	public int hoehe()
	{
		int l = 0;
		int r = 0;
		if(root.links != null)
		{
			l = hoehe(root.links) + 1;
		}
		if(root.rechts != null)
		{
			r = hoehe(root.rechts) + 1;
		}
		return Math.max(l, r);
	}
	
	private int hoehe(Node parent) {
		int l = 0;
		int r = 0;
		if(parent.links != null)
		{
			l = hoehe(parent.links) + 1;
		}
		if(parent.rechts != null)
		{
			r = hoehe(parent.rechts) + 1;
		}
		return Math.max(l, r);
	}

	public int anzahl()
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return 1 + anzahl(root.links) + anzahl(root.rechts);
		}
	}

	private int anzahl(Node parent) {
		if(parent == null)
		{
			return 0;
		}
		else
		{
			return 1 + anzahl(parent.links) + anzahl(parent.rechts);
		}
	}
	
	public String toString()
	{
		if(root == null)
		{
			return "leerer Baum";
		}
		else
		{
			return toString(root.links) + " ; " + root.wert + " ; " + toString(root.rechts);
		}
	}

	private String toString(Node parent) {
		if(parent == null)
		{
			return "";
		}
		else
		{
			return toString(parent.links) + " ; " + parent.wert + " ; " + toString(parent.rechts);
		}
	}
}
