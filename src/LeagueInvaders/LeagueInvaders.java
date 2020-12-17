package LeagueInvaders;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.Timer;

public class LeagueInvaders {
	/* Swing Widgets */
	JFrame window; 
	GamePanel mainGamePanel = new GamePanel();
	
	/* Variables */
	// Window Size
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	public static void main(String[] args) {
		new LeagueInvaders().startup();
	}
	
	public LeagueInvaders () {
		// Same as putting "JFrame window = new JFrame();" in Swing Widgets
		this.window = new JFrame();
	}
	
	void startup () {
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.addKeyListener(mainGamePanel);  // Tells GamePanel to process the Key action
		window.setVisible(true);
		
		mainGamePanel.setSize(WIDTH, HEIGHT);
		window.add(mainGamePanel);
		
//		window.pack();  // Pack isn't needed for some reason
	}
	
	static int getWidth() {
		return WIDTH;	
	}
	
	static int getHeight() {
		return HEIGHT;	
	}
}
