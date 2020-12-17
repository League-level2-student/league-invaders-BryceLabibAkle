package LeagueInvaders;

import java.awt.Image;

import javax.imageio.ImageIO;

public class GameObject {
	/* VARIABLES */
	int speed = 0;
	boolean isActive = true;
	int x;
	int y;
	int width;
	int height;
	Image image;
	 
	 public GameObject(int x, int y, int width, int height) {
		 this.x = x;
		 this.y = y;
		 this.width = width;
		 this.height = height;
	 }
	 
	 void update() {
		 
	 }
	 
	 int getX() {
		 return this.x;
	 }
	 
	 int getY() {
		 return this.y;
	 }
	 
	 boolean getIsActive() {
		 return this.isActive;
	 }
	 
	 // Added my self
	 void loadImage(String imageFile) {
		    try {
		        image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    } 
		    catch (Exception e) {
		            
		    }
	 }
}
