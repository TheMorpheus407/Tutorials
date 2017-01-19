import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener {

	private final int level[][] = {};

	public Board() {
		setFocusable(true);

		setBackground(Color.black);
		setDoubleBuffered(true);
	}

	private void playGame(Graphics2D g2d) {
	}

	private void death() {
	}

	private void moveGhosts(Graphics2D g2d) {
	}

	private void drawGhost(Graphics2D g2d, int x, int y) {
	}

	private void movePacman() {

	}

	private void drawPacman(Graphics2D g2d) {

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, 1280, 720);
		Toolkit.getDefaultToolkit().sync();
		g2d.dispose();
	}

	class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT) {
				
			} else if (key == KeyEvent.VK_RIGHT) {

			} else if (key == KeyEvent.VK_UP) {

			} else if (key == KeyEvent.VK_DOWN) {

			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
