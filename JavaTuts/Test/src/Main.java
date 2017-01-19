import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Main {

	JFrame jf;
	
	JPanel p;
	JCheckBox jc;
	JCheckBox jc1;
	JCheckBox jc2;
	JTextField jt;
	
	JPanel p1;
	JLabel jl;
	JLabel jl2;
	JButton jb;
	JButton jb1;
	JPanel p2;
	JLabel jl3;
	
	 Main(){
		 jf = new JFrame("PasswordGenerator v2");
		 jf.setSize(700,400);
		 jf.setLayout(null);
		 jf.setLocationRelativeTo(null);
		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jf.setVisible(true);
		 
		 /* Panel start */
		 p = new JPanel();
		 p.setLayout(null);
		 p.setBackground(Color.YELLOW);
		 p.setBounds(0, 0, 700, 150);
		 
		 final ButtonGroup bg = new ButtonGroup();
		 
		 jc = new JCheckBox("Password with small letters");
		 jc.setBounds(10, 10, 200, 30);
		 jc.setToolTipText("Easy password");
		 bg.add(jc);
		 
		 jc1 = new JCheckBox("Password with small and big letters");
		 jc1.setBounds(10, 40, 250, 30);
		 jc1.setToolTipText("good password");
		 bg.add(jc1);
		 
		 jc2 = new JCheckBox("Password with small, big letters and numbers");
		 jc2.setBounds(10, 70, 300, 30);
		 jc2.setToolTipText("better then good password");
		 bg.add(jc2);
		 
		 jl = new JLabel("Hello Label");
		 jl.setBounds(500, 40, 100, 30);
		 
		 p.add(jc);
		 p.add(jc1);
		 p.add(jc2);
		 p.add(jl);
		 jf.add(p);
		 /* Panel end */
		 
		 /* Panel start */
		 p1 = new JPanel();
		 p1.setLayout(null);
		 p1.setBounds(225, 250, 400, 100);
		 p1.setBackground(Color.RED);
		 
		 jb = new JButton("Submit");
		 jb.setBounds(0, 50, 100, 30);
		 jb.setToolTipText("Hello Button");
		 jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jc.isSelected()){
					int num = 1;
					jl.setBounds(500, 40, 150, 30);
					jl.setText("First one done");
				}else if(jc1.isSelected()){
					int num = 2;
					jl.setBounds(500, 40, 150, 30);
					jl.setText("Secound one done");
				}else if(jc2.isSelected()){
					int num = 3;
					jl.setBounds(500, 40, 150, 30);
					jl.setText("Last one done");
				}
			}
		});
		 
		 jb1 = new JButton("Close");
		 jb1.setBounds(110, 50, 100, 30);
		 jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		 
		 
		 p1.add(jb);
		 p1.add(jb1);
		 jf.add(p1);
		
		 p2 = new JPanel();
		 p2.setLayout(null);
		 p2.setBounds(0, 150, 700, 100);
		 p2.setBackground(Color.GREEN);
		 
		 jl3 = new JLabel("Output password:");
		 jl3.setBounds(10, 10, 100, 20);
		 
		 jt = new JTextField();
		 jt.setBounds(150, 10, 200, 20);
		 jt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String stuff = jt.getText();
				jl.setText(stuff);
				
			}
		});
		 p2.add(jl3);
		 p2.add(jt);
		 jf.add(p2);
	 }
	
	public static void main(String[] args) {
		new Main();

	}

}