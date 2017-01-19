import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Labyrinth {

	public static void main(String[] args) {
		BufferedImage img = Labyrinth.getImg(createLab(50, 50));
		File outputfile = new File("saved.png");
		try {
			ImageIO.write(img, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int[][] createLab(int width, int height) {
		int[][] lab = new int[width][height];
		ArrayList<int[]> next = new ArrayList<int[]>();
		int[] start = { 0, 1 };
		int[] start1 = { 1, 0 };
		lab[0][0] = 1;
		lab[1][1] = -1;
		next.add(start);
		next.add(start1);

		while (!next.isEmpty()) {
			int random = (int) Math.floor(next.size() * Math.random());
			int[] field = next.get(random);
			lab[field[0]][field[1]] = 1;

			int x = field[0] - 1;
			int y = field[1];
			int[] add = new int[2];
			if (x < 0 || y < 0 || x >= width || y >= height) {
			} else if (lab[x][y] == 1 || lab[x][y] == -1
					|| (y + 1 < height && lab[x][y + 1] == 1)
					|| (y - 1 > 0 && lab[x][y - 1] == 1)) {
				lab[x][y] = -1;
			} else {
				add[0] = x;
				add[1] = y;
				next.add(add);
			}

			x = field[0];
			y = field[1] - 1;
			if (x < 0 || y < 0 || x >= width || y >= height) {
			} else if (lab[x][y] == 1 || lab[x][y] == -1
					|| (x + 1 < width && lab[x + 1][y] == 1)
					|| (x - 1 > 0 && lab[x - 1][y] == 1)) {
				lab[x][y] = -1;
			} else {
				add[0] = x;
				add[1] = y;
				next.add(add);
			}

			x = field[0] + 1;
			y = field[1];
			if (x < 0 || y < 0 || x >= width || y >= height) {
			} else if (lab[x][y] == 1 || lab[x][y] == -1
					|| (y + 1 < height && lab[x][y + 1] == 1)
					|| (y - 1 > 0 && lab[x][y - 1] == 1)) {
				lab[x][y] = -1;
			} else {
				add[0] = x;
				add[1] = y;
				next.add(add);
			}

			x = field[0];
			y = field[1] + 1;
			if (x < 0 || y < 0 || x >= width || y >= height) {
			} else if (lab[x][y] == 1 || lab[x][y] == -1
					|| (x + 1 < width && lab[x + 1][y] == 1)
					|| (x - 1 > 0 && lab[x - 1][y] == 1)) {
				lab[x][y] = -1;
			} else {
				add[0] = x;
				add[1] = y;
				next.add(add);
			}

			next.remove(random);
		}

		return lab;
	}

	public static BufferedImage getImg(int[][] lab) {
		BufferedImage img = new BufferedImage(lab.length + 2,
				lab[0].length + 2, BufferedImage.TYPE_BYTE_GRAY);
		for (int i = 1; i < lab.length + 1; i++) {
			for (int j = 1; j < lab[0].length + 1; j++) {
				int rgb = 0;
				if (lab[i - 1][j - 1] == 1) {
					rgb = Integer.MAX_VALUE;
				}
				if (lab[i - 1][j - 1] == -1) {
					rgb = 0;
				}
				img.setRGB(i, j, rgb);
			}
		}
		return img;
	}
}
