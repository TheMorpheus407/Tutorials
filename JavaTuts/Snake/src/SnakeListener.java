import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SnakeListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		int key_id = e.getKeyCode();
		
		if(key_id == KeyEvent.VK_LEFT && !(Game.direction == 1))
		{
			Game.direction = 0;
		}
		if(key_id == KeyEvent.VK_RIGHT && !(Game.direction == 0))
		{
			Game.direction = 1;
		}
		if(key_id == KeyEvent.VK_UP && !(Game.direction == 3))
		{
			Game.direction = 2;
		}
		if(key_id == KeyEvent.VK_DOWN && !(Game.direction == 2))
		{
			Game.direction = 3;
		}
	}
}
