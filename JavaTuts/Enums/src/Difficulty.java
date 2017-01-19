
public enum Difficulty {
	HARDCORE (3),
	HARD (2),
	MEDIUM (1),
	EZ (0);
	
	private int diff;
	private Difficulty(int diff)
	{
		this.diff = diff;
	}
	public int getDiff()
	{
		return this.diff;
	}
}
