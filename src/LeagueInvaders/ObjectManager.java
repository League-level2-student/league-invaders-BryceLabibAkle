package LeagueInvaders;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	/* VARIABLES */
	RocketShip rocketship;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();  // Holds all Projectile objects
	ArrayList<Alien> aliens = new ArrayList<Alien>();  // Holds all Alien objects
	Random random = new Random();
	
	void draw(Graphics g) {
		rocketship.draw(g);  // Draws rocket
		// Draws all aliens
		for (Alien alien : aliens) {
			alien.draw(g);
		}
		// Draws all aliens
		for (Projectile projectile : projectiles) {
			projectile.draw(g);
		}
	}
	
	void update() {
		for (Alien alien : aliens) {
			alien.update();
			if (alien.getY() < 0) {
				aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
			}
		}
		
	}
	
	void purgeObjects() {
		// Removes not active aliens
		for (int alienNum = 0; alienNum < aliens.size(); alienNum++) {  // Can't use for each loop
			if (aliens.get(alienNum).getIsActive() == false) {
				aliens.remove(alienNum);
			}
		}
		// Removes inactive not active projectiles 
		for (int projectileNum = 0; projectileNum < projectiles.size(); projectileNum++) {
			if (aliens.get(projectileNum).getIsActive() == false) {
				aliens.remove(projectileNum);
			}
		}
	}
	
	public ObjectManager(RocketShip rocketship) {
		this.rocketship = rocketship;
	}
	
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void addProjectile(Projectile projectile) {
		projectiles.add(rocketship.getProjectile());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
