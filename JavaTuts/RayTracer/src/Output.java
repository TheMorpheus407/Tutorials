import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Output extends JPanel{
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	private BufferedImage canvas;
	private static Output instance = null;

	public Output(int width, int height) {
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for(int i = 0; i < canvas.getHeight(); i++)
		{
			for(int j = 0; j < canvas.getWidth(); j++)
			{
				canvas.setRGB(j, i, Color.BLUE.getRGB());
			}
		}
		this.setPreferredSize(new Dimension(width, height));
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(canvas, null, null);
	}

	public static Output getOutput()
	{
		if(Output.instance == null)
		{
			Output.instance = new Output(WIDTH, HEIGHT);
		}
		return Output.instance;
	}
	
	public static void setPixel(int x, int y, int rgb)
	{
		Output inst = getOutput();
		if(x > WIDTH - 1 || y > HEIGHT -1 || x < 0 || y < 0)
		{
			return;
		}
		inst.canvas.setRGB(x, y, rgb);
		inst.repaint();
	}
	
	public static void main(String[] args) {
		new RayTracer().trace();
		Output panel = getOutput();
		
		JFrame frame = new JFrame("Direct raytracing demo");
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
