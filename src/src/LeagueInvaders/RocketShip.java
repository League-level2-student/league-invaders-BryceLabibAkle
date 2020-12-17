package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RocketShip extends GameObject {
	
	/* VARIABLES */
	// Images
	// Doing this my own way
//	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);  // Calls parent's (GameObject) constructor
		this.speed = 10;
	}
	
	void draw(Graphics g) {
		if (needImage) {
			loadImage("rocket.png");
			g.drawImage(image, x, y, width, height, null);
		}
		else {
	        g.setColor(Color.BLUE);
	        g.fillRect(x, y, width, height);
		}
	}
	
	void moveRocketship (int keyPressed) {
		switch (keyPressed) {
		case KeyEvent.VK_UP:
			y -= speed;
			break;
		case KeyEvent.VK_RIGHT:
			x += speed;
			break;
		case KeyEvent.VK_DOWN:
			y += speed;
			break;
		case KeyEvent.VK_LEFT:
			x -= speed;
			break;
		case KeyEvent.VK_SPACE:
			getProjectile();
			System.out.println("worked");
			break;
		default:
			System.out.println("Unknown key event");
			break;
		}
		
	}
	
	public Projectile getProjectile() {
		return new Projectile(x+(width/2), y, 10, 10);
	}
}
