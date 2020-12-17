package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 1;
	}
	
	void draw (Graphics g) {
		loadImage("bullet.png");
		g.drawImage(image, x, y, width, height, null);
	}
	
	void update () {
		y += speed;
	}
}
