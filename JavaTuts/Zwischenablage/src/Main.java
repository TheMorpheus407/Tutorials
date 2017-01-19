import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		Clipboard systemClip = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		systemClip.setContents(new StringSelection("ich bin die Zwischenablage"), null);
		
		Transferable transfer = systemClip.getContents(null);
		
		for(int i = 0; i < transfer.getTransferDataFlavors().length; i++)
		{
			Object content = null;
			try {
				content = transfer.getTransferData(transfer.getTransferDataFlavors()[i]);
			} catch (UnsupportedFlavorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(content instanceof String)
			{
				System.out.println(content);
				break;
			}
		}
	}

}
