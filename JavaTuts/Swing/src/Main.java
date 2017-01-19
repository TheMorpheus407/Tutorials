import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Main extends JFrame{

	public Main()
	{
		//GUI
		setTitle("Unsre GUI");
		setLocationRelativeTo(null);
		setSize(200, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Button
		JButton button = new JButton("Ende");		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				JFileChooser filechooser = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter("Images", "png");
				filechooser.addChoosableFileFilter(filter);
				int dialog = filechooser.showDialog(getContentPane(), "Datei öffnen");
				
				if(dialog == JFileChooser.APPROVE_OPTION)
				{
					File file = filechooser.getSelectedFile();
					
				}
			}
		});	
		JCheckBox cb = new JCheckBox("Ich bin eine CheckBox");
		cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox cb_source = (JCheckBox) e.getSource();
				if(cb_source.isSelected())
				{
					cb.setFont(new Font("Calibri", Font.ITALIC, 12));
				}
			}
		});
		String[] list = {"Auswahl eins", "Auswahl zwei"};
		JComboBox<String> comb = new JComboBox<String>(list);
		comb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					comb.addItem(e.getItem().toString());
				}
			}
		});
		
		JProgressBar pb = new JProgressBar();
		pb.setValue(0);
		pb.setBackground(Color.green);
		
		JSlider slide = new JSlider();
		slide.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int value = slide.getValue();
				pb.setValue(value);
			}
		});
		
		JToggleButton tb = new JToggleButton("Ich bin togglebar");
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		JScrollPane sp = new JScrollPane();
		JList<String> font_list = new JList<>(ge.getAvailableFontFamilyNames());
		sp.setViewportView(font_list);
		
		JTextArea ta = new JTextArea("fgmog jfdkgfkmnlgklm");
		
		//Menubar
		JMenuBar menu = new JMenuBar();
		JMenu datei = new JMenu("Datei");
		JMenu submenu = new JMenu("Submenu");
		JMenuItem item1 = new JMenuItem("ich bin im sub");
		JMenuItem abo = new JMenuItem("Abonniert mich =)");
		abo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();
				URL url = null;
				try {
					url = new URL("https://www.youtube.com/user/TheMorpheus407");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					desktop.browse(url.toURI());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submenu.add(item1);
		datei.add(submenu);
		datei.add(abo);
		datei.addSeparator();
		menu.add(datei);
		setJMenuBar(menu);
		
		//Layout
		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(button);
		//pane.add(cb);
		//pane.add(comb);
		//pane.add(pb);
		//pane.add(slide);
		//pane.add(tb);
		pane.add(ta);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Main m = new Main();
				m.setVisible(true);
			}
		});
	}

}
