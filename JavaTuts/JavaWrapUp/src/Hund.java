
public class Hund extends Tier{
	public String rasse;
	
	public Hund()
	{
		super(4);
		this.rasse = "";
	}
	
	public Hund(String rasse)
	{
		super(4);
		this.rasse = rasse;
	}
	
	public String renne()
	{
		return "hebt alle seine " + this.beine + " an.";
	}
}
