import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Bathtub{
	private Image img; 	
	private AffineTransform tx;
	private int x, y, vx, width, height;
	private boolean isBathtubOn;

	public Bathtub() {
		img = getImage("/imgs/bathtub_off.png"); //load the image for Tree
		this.x = 0;
		this.y = 275;
		this.width = 355;
		this.height = 206;
		isBathtubOn = false;

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
		tx.scale(2.1, 2.1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Bathtub.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void setImage() {
	    if (isBathtubOn) {
	        isBathtubOn = false;
	        img = getImage("/imgs/bathtub_off.png");
	    } else {
	        isBathtubOn = true;
	        img = getImage("/imgs/bathtub_on.png");
	    }
	}
 
	
	private void update() {
		tx.setToTranslation(x, y);	
		tx.scale(2.1, 2.1);		
	}
	
	public boolean getIsBathtubOn() {
		return isBathtubOn;
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
