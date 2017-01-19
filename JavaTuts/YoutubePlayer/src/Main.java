import java.awt.BorderLayout;
import java.awt.Component;
import java.lang.annotation.Native;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


public class Main {

	public static void main(String[] args) {
		NativeInterface.open();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new JFrame("Youtube Player");
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.getContentPane().add(getBrowserPanel(), BorderLayout.CENTER);
				frame.setSize(800, 600);
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
		});
		NativeInterface.runEventPump();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				NativeInterface.close();
				
			}
		}));
	}

	public static JPanel getBrowserPanel() {
		JPanel browser = new JPanel(new BorderLayout());
		JWebBrowser jbrowser = new JWebBrowser();
		browser.add(jbrowser, BorderLayout.CENTER);
		jbrowser.setBarsVisible(false);
		jbrowser.navigate("https://www.youtube.com/watch?v=f9VGF0_Wkzw");
		return browser;
	}

}
