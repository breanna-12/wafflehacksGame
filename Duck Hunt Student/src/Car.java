import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
public class Car{
	private Image img; 	
	private AffineTransform tx;
	private int x, y, vx, width;
	private boolean isPersonInCar;
	public Car() {
		img = getImage("/imgs/car.png"); //load the image for Tree
		this.x = 0;
		this.y = -50;
		this.width = 500;
		isPersonInCar = false;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		update();
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.5, 1.5);
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Car.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void setImage() {
	 if (isPersonInCar) {
	 isPersonInCar = false;
	 img = getImage("/imgs/car.png");
	 } else {
	 isPersonInCar = true;
	 img = getImage("/imgs/pcar.png");
	
	 }
	}
	public void rightPressed(boolean rightPressed) {
		if (rightPressed == true) {
			vx = 4;
			rightPressed = false;
		} else {
			vx = 0;
		}
	}
	
	public void leftPressed(boolean leftPressed) {
		if (leftPressed == true) {
			vx = -4;
			leftPressed = false;
		} else {
			vx = 0;
		}
	}
	
	public void update() {
		x += vx;
		tx.setToTranslation(x, y);	
		tx.scale(1.5, 1.5);		
	}
	
	public boolean getIsPersonInCar() {
		return isPersonInCar;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	
	public void setY(int newY) {
		this.y = newY;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setVX(int newVX) {
		this.vx = newVX;
	}
	
}