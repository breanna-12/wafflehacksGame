import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Clothes{
	private Image img; 	
	private AffineTransform tx;
	private int x, y, vx, width, height;
	private boolean isShowing;

	public Clothes() {
		img = getImage("/imgs/clothes_together.png"); //load the image for Tree
		this.x = 0;
		this.y = -300;
		this.width = 225;
		this.height = 94;
		isShowing = false;

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
		tx.scale(0.5, 0.5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Clothes.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void setImage() {
	    if (isShowing) {
	        isShowing = false;
	        this.y = -300;
	    } else {
	        isShowing = true;
	        this.y = 190;
	    }
	}
 
	
	private void update() {
		tx.setToTranslation(x, y);	
		tx.scale(0.5, 0.5);		
	}
	
	public boolean getIsShowing() {
		return isShowing;
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
