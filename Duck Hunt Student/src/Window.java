import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Window{
	private Image img; 	
	private AffineTransform tx;
	private int x, y, vx, width;
	private int state;

	public Window() {
		img = getImage("/imgs/window_good.gif"); //load the image for Tree
		this.x = 0;
		this.y = 25;
		this.width = 2569;
		state = 0;

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
			URL imageURL = Window.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void setImage(String windowType) {
		if (windowType.equals("good")) {
			img = getImage("/imgs/window_good.gif");
		}
		if (windowType.equals("mid")) {
			img = getImage("/imgs/window_mid.gif");
		}
		if (windowType.equals("bad")) {
			img = getImage("/imgs/window_bad.gif");
		}
	}
	
	private void update() {
		x = x + vx;
		tx.setToTranslation(x, y);
		tx.scale(0.45, 0.45);
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

}
