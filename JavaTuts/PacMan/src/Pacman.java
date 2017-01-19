import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pacman extends JFrame {

	JLabel lScore = new JLabel();
	int iScore = 0;
	int lifes = 3;
	
    public Pacman() {
        init();
    }
    
    private void init() {
        add(new Board());
        add(lScore);
        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 420);
        setLocationRelativeTo(null);
        setVisible(true);        
    }
    
    public void updateScore()
    {
    	this.lScore.setText("score: " + iScore + "   lifes: " + lifes);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Pacman ex = new Pacman();
                ex.setVisible(true);
            }
        });
    }
}