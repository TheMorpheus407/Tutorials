import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GridBadLayout extends Frame implements ActionListener {
	Button schliesen;
	
	public GridBadLayout() {
		super("Drogen sind schlimm mkay?");
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		schliesen = new Button("Schließen");
		schliesen.addActionListener(this);
		gbl.setConstraints(schliesen, gbc);
		add(schliesen);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		Label l = new Label("Meine GUI");
		gbl.setConstraints(l, gbc);
		add(l);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		List list = new List(5);
		list.add("Java");
		list.add("Python");
		list.add("PHP");
		list.add("JavaScript");
		list.add("C");
		gbl.setConstraints(list, gbc);
		add(list);
		pack();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		GridBadLayout gbl = new GridBadLayout();
		gbl.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == schliesen)
		{
			this.dispose();
		}
	}

}
