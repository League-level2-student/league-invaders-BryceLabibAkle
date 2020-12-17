package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	/* Variables */
	// Game States
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;

	// Fonts
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font sentanceFont = new Font("Arial", Font.PLAIN, 32);

	// Colors
	Color shadow150Alpha = new Color(0, 0, 0, 150);
	Color menuColor = new Color(25, 25, 40);
	Color gameColor = new Color(0, 0, 0);
	Color endColor = new Color(51, 153, 255);
	
	// FrameRate timer
	Timer frameDraw;
	Timer alienSpawn;
	
	// Other
	RocketShip rocketship = new RocketShip(250, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager(rocketship);
	Image backgroundImage;
	
	public GamePanel() {
		// "this" makes the Timer take in GamePanel as an ActionListener since it takes in an ActionListener
		frameDraw = new Timer(1000/60, this);
	    frameDraw.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		switch (currentState) {
		case MENU:
			drawMenuState(g);
			break;

		case GAME:
			drawGameState(g);
			break;

		case END:
			drawEndState(g);
			break;

		default:
			System.out.println("Unknown state: " + currentState);
			break;
		}
	}

	// To update the game's current state
	void updateMenuState() {
		currentState = MENU;
	}

	void updateGameState() {
		currentState = GAME;
		objectManager.update();
	}

	void updateEndState() {
		currentState = END;
	}

	// Functions need a Graphics parameter so they can draw objects onto the panel
	void drawMenuState(Graphics g) {
		// Sets up panel
		g.setColor(menuColor);
		g.fillRect(0, 0, LeagueInvaders.getWidth(), LeagueInvaders.getHeight());

		// Title screen font settings
		g.setFont(titleFont);
		// Shadow
		g.setColor(shadow150Alpha);
		g.drawString("League Invaders™", 20, 195);
		// Front text
		g.setColor(Color.WHITE);
		g.drawString("League Invaders™", 25, 200);

		// Begin game text
		g.setFont(sentanceFont);
		g.setColor(Color.WHITE);
		g.drawString("Press any button to start", 40, 600);
		
		// Instructions text
		g.setFont(sentanceFont);
		g.setColor(Color.WHITE);
		g.drawString("Or press SPACE for instructions", 20, 650);
	}

	void drawGameState(Graphics g) {
		// Sets up panel
		//Draws background
		loadBackgroundImage();
		g.drawImage(backgroundImage, 0, 0, LeagueInvaders.getWidth(), LeagueInvaders.getHeight(), null);

		objectManager.draw(g);
	}

	void drawEndState(Graphics g) {
		// Sets up panel
		g.setColor(endColor);
		g.fillRect(0, 0, LeagueInvaders.getWidth(), LeagueInvaders.getHeight());

		// Title screen font settings
		g.setFont(titleFont);
		// Shadow
		g.setColor(shadow150Alpha);
		g.drawString("You win!", 150, 195);
		// Front text
		g.setColor(Color.WHITE);
		g.drawString("You win!", 155, 200);
		
		// Start over text
		g.setFont(sentanceFont);
		g.drawString("Press enter to go", 125, 400);
		g.drawString("to the menu", 150, 425);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
		switch (currentState) {
		case MENU:
			updateMenuState();
			break;
		case GAME:
			updateGameState();
			break;
		case END:
			updateEndState();
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Action");
		int keyPressed = e.getKeyCode();
		if (keyPressed == KeyEvent.VK_ENTER) {
			if (currentState == MENU) {
		        currentState = GAME;
		        // Spawns aliens
				startGame();
		    } 
			else if (currentState == END) {
		        currentState = MENU;
		    } 
			else {
		        currentState++;
		    }
			System.out.println(currentState);
		}
		rocketship.moveRocketship(keyPressed);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	void loadBackgroundImage() {
	    try {
	        backgroundImage = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
	    } catch (Exception e) {
	            
	    }
	}
	
	void startGame() {
		alienSpawn = new Timer(1000, objectManager);
		alienSpawn.start();
	}
}
