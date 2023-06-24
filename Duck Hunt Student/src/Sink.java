import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Sink{
	private Image img; 	
	private AffineTransform tx;
	private int x, y, vx, width, height;
	private boolean isSinkOn;

	public Sink() {
		img = getImage("/imgs/sink_off.png"); //load the image for Tree
		this.x = 0;
		this.y = 215;
		this.width = 116;
		this.height = 116;
		isSinkOn = false;

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
		tx.scale(2, 2);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Sink.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void setImage() {
	    if (isSinkOn) {
	        isSinkOn = false;
	        img = getImage("/imgs/sink_off.png");
	    } else {
	        isSinkOn = true;
	        img = getImage("/imgs/sink_on.png");
	    }
	}
 
	
	private void update() {
		tx.setToTranslation(x, y);	
		tx.scale(2, 2);		
	}
	
	public boolean getIsSinkOn() {
		return isSinkOn;
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
