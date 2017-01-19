import java.awt.Color;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EdgeDetector {
	public static int beschneiden(int alt){
		if (alt > 255)
			return 255;
		else if (alt < 0)
			return 0;
		else
			return alt;
	}
	
	public static double[][] luminanz(BufferedImage img)
	{
		double[][] ret = new double[img.getWidth()][img.getHeight()];
		for(int x = 0; x < img.getWidth(); x++)
		{
			for(int y = 0; y < img.getHeight(); y++)
			{
				Color pixel = new Color(img.getRGB(x, y));
				ret[x][y] = 0.299*pixel.getRed() + 0.587*pixel.getGreen() + 0.114*pixel.getBlue();
			}
		}
		return ret;
	}
	
    public static void main(String[] args) {
    	
    	int[][] filter1 = {
    			{-1,0,1},
    			{-2,0,2},
    			{-1,0,1}
    	};
    	int[][] filter2 = {
    			{1,2,1},
    			{0,0,0},
    			{-1,-2,-1}
    	};
    	
        BufferedImage img = null;
	    try {
	    	img = ImageIO.read(new File("/media/morpheus/Volume/Tuts/JavaTuts/Bildbearbeitung/src/wallpaper-1467792.jpg"));
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
        }
        int width    = img.getWidth();
        int height   = img.getHeight();

        double[][] lum = luminanz(img);
        
        for(int x = 1; x < width -1 ; x++){
        	for(int y = 1; y < height -1; y++)
        	{
        		int grayx = 0;
        		int grayy = 0;
        		for(int i = -1; i < 2; i++)
        		{
        			for(int j = -1; j < 2; j++)
        			{
        				grayx += (int) Math.round(lum[x+i][y+j] * filter1[1+i][1+j]);
        				grayy += (int) Math.round(lum[x+i][y+j] * filter2[1+i][1+j]);
        			}
        		}
        		int gray = beschneiden((int)Math.sqrt(grayx * grayx + grayy * grayy));
        		img.setRGB(x, y, new Color(gray,gray,gray).getRGB());
        	}
        }
        
        File f = null;
        try{
        	  f = new File("Output.jpg");
        	  ImageIO.write(img, "jpg", f);
        	}catch(IOException e){
        	  System.out.println(e);
        	}
    }

   
}