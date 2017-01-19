
public class Main {

	public static void main(String[] args) {
		double[] samples = quantizise(3, sample(20, 0, 20));
		for(int i = 1; i < 19; i++)
		{
			System.out.println("fourier " + i + " = " + fourier(i, samples, 2));
		}
		
	}
	
	public static double fourier(int x, double[] samples, int fenster)
	{
		if(fenster / 2 + x < 0 || fenster <= 0 || fenster /2 + x > samples.length)
		{
			return 0;
		}
		double sum = 0;
		for(int i = - fenster / 2 + x; i < fenster / 2 + x; i++)
		{
			sum += samples[i] * Math.cos(x * i);
		}
		return sum;
	}
	
	public static double[] quantizise(int amount, double[] samplingsamples)
	{
		if((samplingsamples == null) || (amount <= 0))
		{
			return null;
		}
		double[] samples = new double[samplingsamples.length];
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		for(int i = 0; i < samplingsamples.length; i++)
		{
			if(max < samplingsamples[i])
			{
				max = samplingsamples[i];
			}
			if(min > samplingsamples[i])
			{
				min = samplingsamples[i];
			}
		}
		double dist = max - min;
		if(dist < 0)
		{
			return null;
		}
		double step = dist / (amount + 1);
		double[] values = new double[amount]; 
		for(int i = 0; i < amount; i++)
		{
			values[i] = min + i * step;
		}
		
		for(int i = 0; i < samples.length; i++)
		{
			for(int j = 0; j < values.length; j++)
			{
				if(Math.abs(samplingsamples[i] - values[j]) < (samples[i] - samplingsamples[i]))
				{
					samples[i] = values[j];
				}
			}
		}
		return samples;
	}
	
	public static double[] sample(int amount, double start, double end)
	{
		double[] samples = new double[amount];
		double distance = end - start;
		if(distance < 0 || amount <= 0)
		{
			return null;
		}
		//schrittweite
		double step = distance / amount;
		
		for(int i = 0; i < amount; i++)
		{
			samples[i] = f(i * step);
		}
		
		return samples;
	}
	
	public static double f(double x)
	{
		//beliebige Funktion, die quantisiert werden soll.
		return Math.sin(x);
	}

}
