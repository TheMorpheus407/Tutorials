import java.util.ArrayList;


public class Neuron {
	double[] gewicht = new double[100];
	double schwellwert;
	double bias;
	ArrayList<Neuron> sendToArrayList;
	
	public Neuron(ArrayList<Neuron> sendTo)
	{
		this.sendToArrayList = sendTo;
	}
	
	public void train(double[] input, int result)
	{
		double alpha = 0.01;
		int step = fire(input);
		if(step - result < 0.1)
		{
			return;
		}
		for(int i = 0; i < gewicht.length; i++)
		{
			gewicht[i] = gewicht[i] + alpha * input[i] * (result - step);
		}
		train(input, result);
	}
	
	public int fire(double[] input)
	{
		double sum = 0;
		double length = Math.min(input.length, gewicht.length);
		for(int i = 0; i < length; i++)
		{
			sum += gewicht[i] * input[i];
		}
		sum += bias;
		if(schwellwert <= sum)
		{
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public int fire(int[] input)
	{
		double sum = 0;
		double length = Math.min(input.length, gewicht.length);
		for(int i = 0; i < length; i++)
		{
			sum += gewicht[i] * input[i];
		}
		if(schwellwert <= sum)
		{
			return 1;
		}
		else{
			return 0;
		}
	}
}
