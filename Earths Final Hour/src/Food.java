import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Food {
	private Image img; 	
	private AffineTransform tx;
	private int x, y, height, width;
	private double scaleX, scaleY;
	private String foodType;

	public Food() { //load the image for Tree
		img = getImage("/imgs/meat.png");
	    img = getImage("/imgs/trash.png");
		img = getImage("/imgs/milk.png");
		img = getImage("/imgs/rice.png");
		img = getImage("/imga/lettuce.png");
		img = getImage("/imga/eggs.png");
		img = getImage("/imga/chocolate.png");
		img = getImage("/imga/apples.png");
		img = getImage("/imga/cereal.png");
		img = getImage("/imga/beans.png");
		img = getImage("/imga/apples.png");
		

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	
	public Food(int initX, int initY, double sX, double sY, String foodType) {
		x = initX;
		y = initY;	
		scaleX = sX;
		scaleY = sY;
		
		if (foodType.equals("meat")) {
			this.foodType = "meat";
			height = 40;
			width = 80;
			img = getImage("/imgs/meat.png");
		}
		else if (foodType.equals("milk")) {
			this.foodType = "milk";
			height = 80;
			width = 60;
			img = getImage("/imgs/milk.png");
		}
		else if (foodType.equals("trash")) {
			this.foodType = "trash";
			height = 50;
			width = 50;
			img = getImage("/imgs/trash.png");
		}
		else if (foodType.equals("lettuce")) {
			this.foodType = "lettuce";
			height = 40;
			width = 40;
			img = getImage("/imgs/lettuce.png");
		}
		else if (foodType.equals("eggs")) {
			this.foodType = "eggs";
			height = 40;
			width = 40;
			img = getImage("/imgs/eggs.png");
		}
		else if (foodType.equals("chocolate")) {
			this.foodType = "chooclate";
			height = 40;
			width = 40;
			img = getImage("/imgs/chocolate.png");
		}
		else if (foodType.equals("apples")) {
			this.foodType = "apples";
			height = 40;
			width = 40;
			img = getImage("/imgs/apples.png");
		}
		else if (foodType.equals("cereal")) {
			this.foodType = "cereal";
			height = 30;
			width = 30;
			img = getImage("/imgs/cereal.png");
		}
		else if (foodType.equals("beans")) {
			this.foodType = "beans";
			height = 40;
			width = 40;
			img = getImage("/imgs/beans.png");
		}
		else if (foodType.equals("almonds")) {
			this.foodType = "almonds";
			height = 40;
			width = 40;
			img = getImage("/imgs/almonds.png");
		}
		else {
			this.foodType = "rice";
			height =40;
			width = 60;
			img = getImage("/imgs/rice.png");
		}
		
		tx = AffineTransform.getTranslateInstance(x, y);
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
		tx.scale(.5, .5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Food.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	public void clicked() {
		
	}
	
	public void entered() {
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int width() {
		return width;
	}
	
	public int height() {
		return height;
	}
	
	public void setY(int initY) {
		y = initY;
	}
	
	public void setX(int initX) {
		x = initX;
	}
	
	public void update() {
		tx.setToTranslation(x, y);
		tx.scale(scaleX, scaleY);
	}
	
}
