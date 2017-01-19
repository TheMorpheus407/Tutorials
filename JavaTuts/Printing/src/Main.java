import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Main {
	public static void main(String[] args)
	{
		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(new PrintObject());
		
		if(printJob.printDialog())
		{
			try {
				printJob.print();
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
