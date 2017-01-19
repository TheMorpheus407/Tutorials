import java.awt.Image;


public abstract class Moving {
	private int x;
	private int y;
	public Image current = null;
	private Image down;
	private Image up;
	private Image left;
	private Image right;
	
	public abstract void animate(int direction);
	
	public void move(int newX, int newY)
	{
		if(Math.abs(x-newX)+Math.abs(y-newY) > 1)
		{
			return;
		}
		else if(x-newX == 1)
		{
			this.current = this.down;
		}
		else if(x-newX == -1)
		{
			this.current = this.up;
		}
		else if(y-newY == 1)
		{
			this.current = this.left;
		}
		else if(y-newY == -1)
		{
			this.current = this.right;
		}
		this.x = newX;
		this.y = newY;
	}

}
