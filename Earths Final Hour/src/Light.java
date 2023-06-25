import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Light{
	private Image img; 	
	private AffineTransform tx;
	private int x, y, vx, width, height;
	private boolean isLightOn;

	public Light() {
		img = getImage("/imgs/light_off.png"); //load the image for Tree
		this.x = 0;
		this.y = 0;
		this.width = 94;
		this.height = 105;
		isLightOn = false;

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
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Light.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void setImage() {
	    if (isLightOn) {
	        isLightOn = false;
	        img = getImage("/imgs/light_off.png");
	    } else {
	        isLightOn = true;
	        img = getImage("/imgs/light_on.png");
	    }
	}
 
	
	private void update() {
		tx.setToTranslation(x, y);	
		tx.scale(1, 1);		
	}
	
	public boolean getisLightOn() {
		return isLightOn;
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
