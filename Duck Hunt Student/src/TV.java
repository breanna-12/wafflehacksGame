import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class TV{
	private Image img; 	
	private AffineTransform tx;
	private int x, y, vx, width, height;
	private boolean isTVOn;

	public TV() {
		img = getImage("/imgs/tvOff.png"); //load the image for Tree
		this.x = 0;
		this.y = 268;
		this.width = 139;
		this.height = 175;
		isTVOn = false;

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
		tx.scale(0.4, 0.4);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = TV.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void setImage() {
	    if (isTVOn) {
	        isTVOn = false;
	        img = getImage("/imgs/tvOff.png");
	        tx.setToTranslation(x, y);
	        tx.scale(0.4, 0.4);
	    } else {
	        isTVOn = true;
	        img = getImage("/imgs/tvOn.png");
	        tx.setToTranslation(x, y);
	        tx.scale(0.435, 0.435);
	    }
	}
 
	
	private void update() {
		tx.setToTranslation(x, y);
		if (isTVOn == true) {
			tx.scale(0.435, 0.435);		
		}
		else {
			tx.scale(0.4, 0.4);		
		}

	}
	
	public boolean getIsTVOn() {
		return isTVOn;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
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
	
	public int getHeight() {
		return height;
	}

}
