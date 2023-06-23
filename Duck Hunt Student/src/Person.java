import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Person{
	private Image img; 	
	private AffineTransform tx;
	private int x, y, height, width, vx;

	public Person() {
		img = getImage("/imgs/character_front.png"); //load the image for Tree
		this.x = 100;
		this.y = 100;
		this.vx = 0;

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(0, 0);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		getX();
		g2.drawImage(img, tx, null);

	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Person.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void setImage(boolean walkingLeft, boolean walkingRight) {
		if (walkingRight && !walkingLeft) {
			img = getImage("/imgs/character_walkRight.gif");
		}
		if (walkingLeft && !walkingRight) {
			img = getImage("/imgs/character_walkLeft.gif");
		}
		if (!walkingLeft && !walkingRight) {
			img = getImage("/imgs/character_front.png");
		}
	}
	
	public void rightPressed(boolean rightPressed) {
		if (rightPressed == true) {
			vx = 5;
			rightPressed = false;
		} else {
			vx = 0;
		}
	}
	
	public void leftPressed(boolean leftPressed) {
		if (leftPressed == true) {
			vx = -5;
			leftPressed = false;
		} else {
			vx = 0;
		}
	}
	
	private void getX() {
		x += vx;
	}

}
