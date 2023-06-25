import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background{
	private Image img; 	
	private AffineTransform tx;
	private int x, y, vx, width;

	public Background() {
		img = getImage("/imgs/background_final.png"); //load the image for Tree
		this.x = -720;
		this.y = 0;
		this.vx = 0;
		this.width = 2569;
		

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
		g2.drawImage(img, tx, null);
		update();

	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1.75, 1.75);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	private void update() {
		x = x + vx;
		tx.setToTranslation(x, y);
		tx.scale(1.75, 1.75);
	}
	
	public void slide(boolean moveLeft, boolean moveRight) {
		if (moveLeft == true) {
			vx = 2;
			this.x += vx;
		}
		else if (moveRight == true) {
			vx = -2;
			this.x += vx;
		}
		else {
			vx = 0;
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	
	public int getWidth() {
		return width;
	}

}
