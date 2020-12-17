package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 1;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		loadImage("alien.png");
		g.drawImage(image, 0, 0, width, height, null);
        g.fillRect(x, y, width, height);
	}
	
	void update() {
        y += speed;  // Moves Alien down
	}
	
}
